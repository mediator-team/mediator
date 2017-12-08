package org.fmgroup.mediator.core.scheduler;

import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.entity.Entity;
import org.fmgroup.mediator.language.entity.PortDeclaration;
import org.fmgroup.mediator.language.entity.automaton.Automaton;
import org.fmgroup.mediator.language.entity.automaton.Transition;
import org.fmgroup.mediator.language.entity.automaton.TransitionGroup;
import org.fmgroup.mediator.language.entity.automaton.TransitionSingle;
import org.fmgroup.mediator.language.entity.system.ComponentDeclaration;
import org.fmgroup.mediator.language.entity.system.Connection;
import org.fmgroup.mediator.language.entity.system.InternalDeclaration;
import org.fmgroup.mediator.language.entity.system.System;
import org.fmgroup.mediator.language.scope.Declaration;
import org.fmgroup.mediator.language.scope.VariableDeclaration;
import org.fmgroup.mediator.language.statement.AssignmentStatement;
import org.fmgroup.mediator.language.statement.Statement;
import org.fmgroup.mediator.language.statement.SynchronizingStatement;
import org.fmgroup.mediator.language.term.*;
import org.fmgroup.mediator.language.type.BoolType;
import org.fmgroup.mediator.language.type.IdType;
import org.fmgroup.mediator.language.type.InitType;
import org.fmgroup.mediator.language.type.Type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Scheduler {

    /**
     * Implements the scheduling algorithm in paper `Component-based Modeling in Mediator, FACS 2017`
     * It flats a system (with hierarchy) to a simple automaton
     * @param sys the system that needs to flat
     * @return an automaton, with same name and interface with sys
     * @throws ValidationException
     */
    public static Automaton Schedule (System sys) throws ValidationException {

        Automaton a = new Automaton();
        a.setParent(sys.getParent());

        // name, interface and template should be exactly the same
        a.setName(sys.getName());
        a.setEntityInterface(sys.getEntityInterface() != null ? sys.getEntityInterface().copy(a) : null);
        a.setTemplate(sys.getTemplate() != null ? sys.getTemplate().copy(a) : null);

        // 0. initialize declarationList and connectors
        // declarationList have their own identifiers, so we use these identifiers as the keys in the following hashmap
        // it is very important that in both `declarationList` and `connections`, the values, i.e. automata, are not the
        // original object where they are declared, but should be copies instead
        Map<String, Automaton> components = new HashMap<>();

        // however, connections are declared only by their types (i.e. names of automata), so we use the connection
        // objects themselves as keys
        Map<Connection, Automaton> connections = new HashMap<>();

        // all external transitions in declarationList/connections
        Map<Entity, List<Transition>> externals = new HashMap<>();

        for (ComponentDeclaration compDecl : sys.getComponentCollection().getDeclarationList()) {
            if (compDecl.getType().getProvider() instanceof Automaton) {
                Automaton canonicalized = Scheduler.Canonicalize((Automaton) compDecl.getType().getProvider());
                for (String identifier : compDecl.getIdentifiers()) {
                    components.put(identifier, (Automaton) canonicalized.copy());
                }
            } else {
                Automaton scheduled = Scheduler.Schedule((System) compDecl.getType().getProvider());
                for (String identifier : compDecl.getIdentifiers()) {
                    components.put(identifier, (Automaton) scheduled.copy());
                }
            }
        }


        // 1. variables
        // 1.1 from internals to local variables
        // we use a hashmap to store the rewriting rules
        Map<String, Term> rewriteMap = new HashMap<>();

        for (InternalDeclaration internals : sys.getInternalCollection().getDeclarationList()) {
            for (String internal: internals.getIdentifiers()) {
                // TODO check if the identifier is already used
                VariableDeclaration portval = new VariableDeclaration();
                portval.setParent(a);
                portval.addIdentifier(internal + "_value");
                portval.setType(new IdType().setParent(portval).setIdentifier("TODO"));

                a.getLocalVars().addDeclaration(portval);

                VariableDeclaration portstatus = new VariableDeclaration();
                portstatus.setParent(a);
                portstatus.addIdentifier(internal + "_reqRead");
                portstatus.addIdentifier(internal + "_reqWrite");

                InitType portstatusType = new InitType().setParent(a);
                portstatusType.setBaseType(new BoolType().setParent(a));
                portstatusType.setDefaultValue(new BoolValue().setValue(false).setParent(a));
                portstatus.setType(portstatusType);

                rewriteMap.put(internal + ".value", new IdValue().setParent(a).setIdentifier(internal + "_value"));
                rewriteMap.put(internal + ".reqRead", new IdValue().setParent(a).setIdentifier(internal + "_reqRead"));
                rewriteMap.put(internal + ".reqWrite", new IdValue().setParent(a).setIdentifier(internal + "_reqWrite"));

                a.getLocalVars().addDeclaration(portstatus);
            }
        }


        // we make sure that the new automaton is also canonical
        TransitionGroup baseGroup = new TransitionGroup().setParent(a);
        a.getTransitions().add(baseGroup);

        for (String name : components.keySet()) {
            Map<String, Term> localRewriteMap = new HashMap<>(rewriteMap);
            Map<String, Type> localTypeRewriteMap = new HashMap<>();

            Automaton comp = components.get(name);
            externals.put(comp, new ArrayList<>());
            externals.get(comp).add(null);

            // port variables
            for (PortDeclaration pdecl : comp.getEntityInterface().getDeclarationList()) {
                for (String pname: pdecl.getIdentifiers()) {
                    for (PortVariableType suffix : PortVariableType.values()) {
                        VariableDeclaration vd = new VariableDeclaration().setParent(a);

                        vd.addIdentifier(name + "_" + pname + "_" + suffix.toString());
                        if (suffix == PortVariableType.VALUE) vd.setType(pdecl.getType().copy(vd));
                        else vd.setType(new BoolType());
                        a.getLocalVars().addDeclaration(vd);

                        localRewriteMap.put(
                                pname + "." + suffix,
                                new IdValue().setParent(a).setIdentifier(name + "_" + pname + "_" + suffix)
                        );
                    }
                }
            }

            // template parameters
            ComponentDeclaration currCompDecl = (ComponentDeclaration) sys.getComponentCollection().getDeclaration(name);
            for (RawElement arg : currCompDecl.getType().getParams()) {
                String paramName = comp.getTemplate().getDeclarationIdentifier((
                        currCompDecl.getType().getParams().indexOf(arg)
                ));
                if (arg instanceof Term) {
                    localRewriteMap.put(paramName, (Term) arg);
                } else {
                    localTypeRewriteMap.put(paramName, (Type) arg);
                }
            }

            // local variables
            for (Declaration var : comp.getLocalVars().getDeclarationList()) {
                VariableDeclaration nvar = (VariableDeclaration) var.copy(a);
                for (int i = 0; i < nvar.getIdentifiers().size(); i ++) {
                    String newname = name + "_" + nvar.getIdentifiers().get(i);
                    nvar.getIdentifiers().set(i, newname);
                    localRewriteMap.put(var.getIdentifier(i), new IdValue().setParent(a).setIdentifier(newname));
                }

                nvar.setType(nvar.getType().refactor(localTypeRewriteMap, localRewriteMap));

                a.getLocalVars().addDeclaration(nvar);
            }

            // transitions

            assert components.get(name).getTransitions().size() == 1;
            assert components.get(name).getTransitions().get(0) instanceof TransitionGroup;

            for (Transition t : ((TransitionGroup) components.get(name).getTransition(0)).getTransitions()) {
                assert t instanceof TransitionSingle;
                if (((TransitionSingle) t).isInternal()) {
                    baseGroup.addTransition(
                            t.refactor(localRewriteMap, baseGroup)
                    );
                } else {
                    // deal with the external cases (synchronize)
                    externals.get(comp).add(t.refactor(localRewriteMap, baseGroup));
                }
            }

        }

        for (Connection conn : sys.getConnections()) {
            Map<String, Term> localRewriteMap = new HashMap<>(rewriteMap);
            Map<String, Type> localTypeRewriteMap = new HashMap<>();

            if (conn.getType().getProvider() instanceof System) {
                connections.put(conn, Scheduler.Schedule((System) conn.getType().getProvider()));
            } else {
                connections.put(conn, Scheduler.Canonicalize((Automaton) conn.getType().getProvider()));
            }

            Automaton connection = connections.get(conn);

            externals.put(connection, new ArrayList<>());
            externals.get(connection).add(null);

            // connections do not produce extra port variables
            // port variables are created by componentCollection and internals

            // locate the correct port variables created by other componentCollection/internals
            for (PortDeclaration pdecl : connections.get(conn).getEntityInterface().getDeclarationList()) {
                for (String pname: pdecl.getIdentifiers()) {
                    int index = connections.get(conn).getEntityInterface().getDeclarationIndex(pname);
                    if (conn.getPortIdentifiers().get(index).getOwner() == null) continue;

                    String prefix = conn.getPortIdentifiers().get(index).getOwner()
                            + "_"
                            + conn.getPortIdentifiers().get(index).getPortName() + "_";

                    for (PortVariableType suffix : PortVariableType.values()) {
                        localRewriteMap.put(
                                pname + "." + suffix.toString(),
                                new IdValue().setParent(a).setIdentifier(prefix + suffix.toString())
                        );
                    }
                }
            }


            // templated parameters
            for (RawElement arg : conn.getType().getParams()) {
                String paramName = conn.getType().getProvider().getTemplate().getDeclarationIdentifier(
                        conn.getType().getParams().indexOf(arg)
                );
                if (arg instanceof Term) {
                    localRewriteMap.put(paramName, (Term) arg);
                } else {
                    localTypeRewriteMap.put(paramName, (Type) arg);
                }
            }

            // local variables
            String prefix = connections.get(conn).getName() + "_" + sys.getConnections().indexOf(conn);

            for (VariableDeclaration vd : connections.get(conn).getLocalVars().getDeclarationList()) {
                VariableDeclaration nvd = new VariableDeclaration().setParent(a);

                nvd.setType(vd.getType().copy(nvd).refactor(localTypeRewriteMap, localRewriteMap));

                for (int i = 0; i < nvd.getIdentifiers().size(); i ++) {
                    String newname = prefix + "_" + nvd.getIdentifier(i);
                    nvd.addIdentifier(newname);
                    localRewriteMap.put(vd.getIdentifier(i), new IdValue().setParent(a).setIdentifier(newname));
                }

                a.getLocalVars().addDeclaration(nvd);
            }

            // transitions
            assert connections.get(conn).getTransitions().size() == 1;
            assert connections.get(conn).getTransitions().get(0) instanceof TransitionGroup;

            for (Transition t : ((TransitionGroup) connections.get(conn).getTransition(0)).getTransitions()) {
                assert t instanceof TransitionSingle;
                if (((TransitionSingle) t).isInternal()) {
                    baseGroup.addTransition(
                            t.refactor(localRewriteMap, baseGroup)
                    );
                } else {
                    // deal with the external cases (synchronize)
                    externals.get(connection)
                            .add(t.refactor(localRewriteMap, baseGroup));
                }
            }

        }

        // start synchronization
        // CommandGenerate all possible combinations
        List<Map<Entity, Transition>> combinations = new ArrayList<>();
        combinations.add(new HashMap<>());
        for (Entity owner : externals.keySet()) {
            List<Map<Entity, Transition>> temp = new ArrayList<>();
            for (Transition t : externals.get(owner)) {
                for (Map<Entity, Transition> prevCombination : combinations) {
                    Map<Entity, Transition> newCombination = new HashMap<>(prevCombination);
                    newCombination.put(owner, t);
                    temp.add(newCombination);
                }
            }

            combinations = temp;
        }

        for (Map<Entity, Transition> combination : combinations) {
            TransitionSingle syncTrans = Synchronize(combination, a);
            if (syncTrans != null) {
                baseGroup.addTransition(syncTrans);
            }
        }

        return a;

    }

    private static TransitionSingle Synchronize(Map<Entity, Transition> combination, Entity parent) throws ValidationException {
        /*
        In what case a set of transitions can be synchronized?
        - 1. all internal declarationList are synchronized
        - 2. they can be scheduled
         */
        Term guard = null;
        TopoGraph<Statement> graph = new TopoGraph<>();


        for (Transition t : combination.values()) {
            if (t == null) continue;
            assert t instanceof TransitionSingle;

            // deal with guards
            if (guard == null) guard = t.getGuard();
            else {
                guard = new BinaryOperatorTerm().setOpr(EnumBinaryOperator.LAND)
                        .setLeft(guard)
                        .setRight(t.getGuard());
            }

            // add dependency of statement
            for (int i = -1; i < ((TransitionSingle) t).size(); i ++) {
                List<TopoGraphVertice> froms = new ArrayList<>();
                List<TopoGraphVertice> tos = new ArrayList<>();

                // when i is -1, we add a vertual vertice to the graph
                if (i == -1) froms.add(graph.createVirtualNode());
                else {
                    if (((TransitionSingle) t).getStatement(i) instanceof SynchronizingStatement) {
                        for (SynchronizingStatement st : ((SynchronizingStatement) ((TransitionSingle) t).getStatement(i)).split()) {
                            froms.add(graph.getOrCreateNode(st));
                        }
                    } else {
                        froms.add(graph.getOrCreateNode(((TransitionSingle) t).getStatement(i)));
                    }
                }

                if (i + 1 == ((TransitionSingle) t).size()) {
                    tos.add(graph.createVirtualNode());
                } else {
                    if (((TransitionSingle) t).getStatement(i + 1) instanceof SynchronizingStatement) {
                        for (SynchronizingStatement st : ((SynchronizingStatement) ((TransitionSingle) t).getStatement(i + 1)).split()) {
                            tos.add(graph.getOrCreateNode(st));
                        }
                    } else {
                        tos.add(graph.getOrCreateNode(((TransitionSingle) t).getStatement(i + 1)));
                    }
                }


                for (TopoGraphVertice from : froms) {
                    for (TopoGraphVertice to : tos) {
                        graph.connect(from, to);
                    }
                }
            }

        }

        // check if the graph is valid
        boolean valid = true;
        if (graph.vertices.size() == 0) valid = false;
        for (TopoGraphVertice v : graph.vertices) {
            if (v.element instanceof SynchronizingStatement) {
                if (graph.countInEdges(v) != 2 || graph.countOutEdges(v) != 2) {
                    if (((SynchronizingStatement) v.element).getSynchronizedPort(0).getPortName().contains("_")) {
                        valid = false;
                        break;
                    }
                    // if no "_" included, the port is an external port
                }
            }
        }

        if (!valid) return null;
        // even if the graph is valid, it does not mean that it can be scheduled correctly
        List<Statement> statements = graph.TopologySort();

        // some synchronizing statements should be kept, and some should be replaced with resetting statements

        for (int i = 0; i < statements.size(); i ++) {
            Statement s = statements.get(i);

            if (s instanceof SynchronizingStatement) {
                assert ((SynchronizingStatement) s).getSynchronizedPorts().size() == 1;
                String portId = ((SynchronizingStatement) s).getSynchronizedPort(0).getPortName();

                if (portId.contains("_")) {
                    int index = statements.indexOf(s);
                    statements.remove(index);
                    statements.add(
                            index,
                            new AssignmentStatement()
                                    .setTarget(
                                            new IdValue()
                                                    .setParent(parent)
                                                    .setIdentifier(portId + "_reqRead")
                                    )
                                    .setExpr(new BoolValue().setValue(false))
                            );

                    statements.add(
                            index,
                            new AssignmentStatement()
                                    .setTarget(
                                            new IdValue()
                                                    .setParent(parent)
                                                    .setIdentifier(portId + "_reqWrite")
                                    )
                                    .setExpr(new BoolValue().setValue(false))
                    );
                }
            }
        }

        // TODO combine multiple synchronizing statements if possible

        TransitionSingle trans = new TransitionSingle();
        trans.setGuard(guard);
        trans.setStatements(statements);

        return trans;
    }

    public static List<Transition> CanonicalizeTransitions(Term cond, List<Transition> transitions, RawElement parent) throws ValidationException {
        List<Transition> ctrans = new ArrayList<>();

        if (cond == null) cond = new BoolValue().setValue(false);
        for (Transition t : transitions) {
            if (t instanceof TransitionSingle) {
                TransitionSingle tnew;
                tnew = (TransitionSingle) t.copy(parent);

                tnew.setGuard(new BinaryOperatorTerm()
                        .setParent(tnew)
                        .setOpr(EnumBinaryOperator.LAND)
                        .setLeft(
                                new SingleOperatorTerm()
                                        .setOpr(EnumSingleOperator.LNOT)
                                        .setTerm(cond.copy(parent))
                        )
                        .setRight(tnew.getGuard())
                );

                ctrans.add(tnew);
            } else {
                ctrans.addAll(
                        CanonicalizeTransitions(cond, ((TransitionGroup) t).getTransitions(), parent)
                );
            }

            if (!(t.getParent() instanceof TransitionGroup)) {
                cond = new BinaryOperatorTerm()
                        .setOpr(EnumBinaryOperator.LOR)
                        .setLeft(cond)
                        .setRight(t.getGuard());
            }
        }
        return ctrans;
    }

    public static Automaton Canonicalize(Automaton a) throws ValidationException {
        Automaton an = new Automaton();

        an.setParent(a.getParent());
        an.setName(a.getName());

        if (a.getTemplate() != null) an.setTemplate(a.getTemplate().copy(an));
        an.setEntityInterface(a.getEntityInterface().copy(an));
        an.setLocalVars(a.getLocalVars().copy(an));

        TransitionGroup tg = new TransitionGroup();
        tg.setParent(an);

        try {
            tg.setTransitions(CanonicalizeTransitions(null, a.getTransitions(), tg));
        } catch (ValidationException e) {
            e.printStackTrace();
        }

        an.addTransition(tg);

        return an;
    }

}
