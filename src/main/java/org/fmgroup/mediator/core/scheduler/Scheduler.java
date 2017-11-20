package org.fmgroup.mediator.core.scheduler;

import org.fmgroup.mediator.language.*;
import org.fmgroup.mediator.language.entity.Entity;
import org.fmgroup.mediator.language.entity.automaton.Automaton;
import org.fmgroup.mediator.language.entity.EntityInterface;
import org.fmgroup.mediator.language.Template;
import org.fmgroup.mediator.language.entity.PortDeclaration;
import org.fmgroup.mediator.language.scope.VariableDeclaration;
import org.fmgroup.mediator.language.entity.system.Connection;
import org.fmgroup.mediator.language.entity.system.System;
import org.fmgroup.mediator.language.statement.AssignmentStatement;
import org.fmgroup.mediator.language.statement.Statement;
import org.fmgroup.mediator.language.statement.SynchronizingStatement;
import org.fmgroup.mediator.language.term.*;
import org.fmgroup.mediator.language.entity.automaton.Transition;
import org.fmgroup.mediator.language.entity.automaton.TransitionGroup;
import org.fmgroup.mediator.language.entity.automaton.TransitionSingle;
import org.fmgroup.mediator.language.entity.automaton.UtilTransition;
import org.fmgroup.mediator.language.type.*;

import java.util.*;


public class Scheduler {

    public static Automaton Schedule (System sys) throws ValidationException {

        Automaton a = new Automaton();
        a.name = sys.name;
        a.entityInterface = (EntityInterface) sys.entityInterface.clone(a);
        a.template = sys.template != null ? (Template) sys.template.clone(a) : null;

        // 0. initialize components and connectors
        Map<String, Automaton> components = new HashMap<>();
        Map<Connection, Automaton> connections = new HashMap<>();
        Map<Entity, List<Transition>> externals = new HashMap<>();

        for (String compname : sys.components.keySet()) {
            // TODO refactor this loop

            if (sys.components.get(compname).provider == null) {
                java.lang.System.err.println("null provider");
            } else {
                if (sys.components.get(compname).provider instanceof Automaton) {
                    components.put(compname, Scheduler.Canonicalize((Automaton) sys.components.get(compname).provider));
                } else {
                    components.put(compname, Scheduler.Schedule((System) sys.components.get(compname).provider));
                }
            }
        }


        // 1. variables
        // 1.1 from internals to local variables
        // we use a hashmap to store the rewriting rules
        Map<String, Term> rewriteMap = new HashMap<>();

        for (String internal : sys.internals) {
            // TODO check if the identifier is already used
            VariableDeclaration portval = new VariableDeclaration();
            portval.setParent(a);
            portval.identifiers.add(internal + "_value");

            // TODO analyse the type
            portval.type = new IdType().setIdentifier("TODO");
            a.localVars.vardecls.add(portval);

            VariableDeclaration portstatus = new VariableDeclaration();
            portstatus.setParent(a);
            portstatus.identifiers.add(internal + "_reqRead");
            portstatus.identifiers.add(internal + "_reqWrite");
            InitType portstatusType = (InitType) new InitType().setParent(a);
            portstatusType.baseType = (Type) new BoolType().setParent(a);
            portstatusType.defaultValue = (Term) new BoolValue().setValue(false).setParent(a);
            portstatus.type = portstatusType;

            rewriteMap.put(internal + ".value", new IdValue().setIdentifier(internal + "_value"));
            rewriteMap.put(internal + ".reqRead", new IdValue().setIdentifier(internal + "_reqRead"));
            rewriteMap.put(internal + ".reqWrite", new IdValue().setIdentifier(internal + "_reqWrite"));

            a.localVars.vardecls.add(portstatus);
        }


        // we make sure that the new automaton is also canonical
        TransitionGroup baseGroup = (TransitionGroup) new TransitionGroup().setParent(a);
        a.transitions.add(baseGroup);

        for (String name : components.keySet()) {
            Map<String, Term> localRewriteMap = new HashMap<>(rewriteMap);
            Map<String, Type> localTypeRewriteMap = new HashMap<>();

            Automaton comp = components.get(name);
            externals.put(comp, new ArrayList<>());
            externals.get(comp).add(null);

            // port variables
            for (PortDeclaration p : comp.entityInterface.portDeclarations) {
                for (String suffix : PortDeclaration.adjointVariables) {
                    VariableDeclaration vd = (VariableDeclaration) new VariableDeclaration().setParent(a);
                    vd.identifiers.add(name + "_" + p.names + "_" + suffix);
                    vd.type = (Type) p.type.clone(vd);
                    a.localVars.vardecls.add(vd);

                    localRewriteMap.put(
                            p.names + "." + suffix,
                            new IdValue().setIdentifier(name + "_" + p.names + "_" + suffix)
                    );
                }
            }

            // template parameters
            for (RawElement arg : sys.components.get(name).params) {
                String paramName = comp.template.getDeclarationIdentifier((
                        sys.components.get(name).params.indexOf(arg)
                ));
                if (arg instanceof Term) {
                    localRewriteMap.put(paramName, (Term) arg);
                } else {
                    localTypeRewriteMap.put(paramName, (Type) arg);
                }
            }

            // local variables
            for (VariableDeclaration var : comp.localVars.vardecls) {
                VariableDeclaration nvar = (VariableDeclaration) var.clone(a);
                for (int i = 0; i < nvar.identifiers.size(); i ++) {
                    String newname = name + "_" + nvar.identifiers.get(i);
                    nvar.identifiers.set(i, newname);
                    localRewriteMap.put(var.identifiers.get(i), new IdValue().setIdentifier(newname));
                }

                nvar.type = UtilType.refactor(nvar.type, localTypeRewriteMap, localRewriteMap);

                a.localVars.vardecls.add(nvar);
            }

            // transitions

            assert components.get(name).transitions.size() == 1;
            assert components.get(name).transitions.get(0) instanceof TransitionGroup;

            for (Transition t : ((TransitionGroup) components.get(name).transitions.get(0)).transitions) {
                assert t instanceof TransitionSingle;
                if (((TransitionSingle) t).isInternal) {
                    baseGroup.transitions.add(
                            UtilTransition.refactor(t, localRewriteMap, baseGroup)
                    );
                } else {
                    // deal with the external cases (synchronize)
                    externals.get(comp).add(UtilTransition.refactor(t, localRewriteMap, baseGroup));
                }
            }

        }

        for (Connection conn : sys.connections) {
            Map<String, Term> localRewriteMap = new HashMap<>(rewriteMap);
            Map<String, Type> localTypeRewriteMap = new HashMap<>();

            if (conn.type.provider instanceof System) {
                connections.put(conn, Scheduler.Schedule((System) conn.type.provider));
            } else {
                connections.put(conn, Scheduler.Canonicalize((Automaton) conn.type.provider));
            }

            externals.put(conn.type.provider, new ArrayList<>());
            externals.get(conn.type.provider).add(null);

            // connections do not produce extra port variables
            // port variables are created by components and internals

            // locate the correct port variables created by other components/internals
            for (PortDeclaration p : connections.get(conn).entityInterface.portDeclarations) {
                int index = connections.get(conn).entityInterface.portDeclarations.indexOf(p);

                if (conn.ports.get(index).scopeIdentifiers.size() == 0) continue;

                String prefix = conn.ports.get(index).scopeIdentifiers.get(0) + "_" + conn.ports.get(index).identifier + "_";

                for (String suffix : PortDeclaration.adjointVariables) {
                    localRewriteMap.put(
                            p.names + "." + suffix,
                            new IdValue().setIdentifier(prefix + suffix)
                    );
                }
            }


            // templated parameters
            for (RawElement arg : conn.type.params) {
                String paramName = conn.type.provider.getTemplate().getDeclarationIdentifier(
                        conn.type.params.indexOf(arg)
                );
                if (arg instanceof Term) {
                    localRewriteMap.put(paramName, (Term) arg);
                } else {
                    localTypeRewriteMap.put(paramName, (Type) arg);
                }
            }

            // local variables
            String prefix = connections.get(conn).name + "_" + sys.connections.indexOf(conn);

            for (VariableDeclaration vd : connections.get(conn).localVars.vardecls) {
                VariableDeclaration nvd = (VariableDeclaration) vd.clone(a);
                for (int i = 0; i < nvd.identifiers.size(); i ++) {
                    String newname = prefix + "_" + nvd.identifiers.get(i);
                    nvd.identifiers.set(i, newname);
                    localRewriteMap.put(vd.identifiers.get(i), new IdValue().setIdentifier(newname));
                }

                nvd.type = UtilType.refactor(nvd.type, localTypeRewriteMap, localRewriteMap);
                a.localVars.vardecls.add(nvd);
            }

            // transitions
            assert connections.get(conn).transitions.size() == 1;
            assert connections.get(conn).transitions.get(0) instanceof TransitionGroup;
            for (Transition t : ((TransitionGroup) connections.get(conn).transitions.get(0)).transitions) {
                assert t instanceof TransitionSingle;
                if (((TransitionSingle) t).isInternal) {
                    baseGroup.transitions.add(
                            UtilTransition.refactor(t, localRewriteMap, baseGroup)
                    );
                } else {
                    // deal with the external cases (synchronize)
                    externals.get(conn.type.provider).add(UtilTransition.refactor(t, localRewriteMap, baseGroup));
                }
            }

        }

        // start synchronization
        // generate all possible combinations
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
            Transition syncTrans = Synchronize(combination);
            if (syncTrans != null) {
                baseGroup.transitions.add(syncTrans);
            }
        }

        return a;

    }

    private static Transition Synchronize(Map<Entity, Transition> combination) throws ValidationException {
        /*
        In what case a set of transitions can be synchronized?
        - 1. all internal portDeclarations are synchronized
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
            for (int i = -1; i < ((TransitionSingle) t).statements.size(); i ++) {
                List<TopoGraphVertice> froms = new ArrayList<>();
                List<TopoGraphVertice> tos = new ArrayList<>();

                // when i is -1, we add a vertual vertice to the graph
                if (i == -1) froms.add(graph.createVirtualNode());
                else {
                    if (((TransitionSingle) t).statements.get(i) instanceof SynchronizingStatement) {
                        for (SynchronizingStatement st : ((SynchronizingStatement) ((TransitionSingle) t).statements.get(i)).split()) {
                            froms.add(graph.getOrCreateNode(st));
                        }
                    } else {
                        froms.add(graph.getOrCreateNode(((TransitionSingle) t).statements.get(i)));
                    }
                }

                if (i + 1 == ((TransitionSingle) t).statements.size()) {
                    tos.add(graph.createVirtualNode());
                } else {
                    if (((TransitionSingle) t).statements.get(i + 1) instanceof SynchronizingStatement) {
                        for (SynchronizingStatement st : ((SynchronizingStatement) ((TransitionSingle) t).statements.get(i + 1)).split()) {
                            tos.add(graph.getOrCreateNode(st));
                        }
                    } else {
                        tos.add(graph.getOrCreateNode(((TransitionSingle) t).statements.get(i + 1)));
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
                    if (((SynchronizingStatement) v.element).synchronizedPorts.get(0).contains("_")) {
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
                assert ((SynchronizingStatement) s).synchronizedPorts.size() == 1;
                String portId = ((SynchronizingStatement) s).synchronizedPorts.get(0);

                if (portId.contains("_")) {
                    int index = statements.indexOf(s);
                    statements.remove(index);
                    statements.add(
                            index,
                            new AssignmentStatement()
                                    .setTarget(new IdValue().setIdentifier(portId + "_reqRead"))
                                    .setExpr(new BoolValue().setValue(false))
                            );

                    statements.add(
                            index,
                            new AssignmentStatement()
                                    .setTarget(new IdValue().setIdentifier(portId + "_reqWrite"))
                                    .setExpr(new BoolValue().setValue(false))
                    );
                }
            }
        }

        // TODO combine multiple synchronizing statements if possible

        TransitionSingle trans = new TransitionSingle();
        trans.guard = guard;
        trans.statements = statements;

        return trans;
    }

    public static List<Transition> CanonicalizeTransitions(Term cond, List<Transition> transitions) throws ValidationException {
        List<Transition> ctrans = new ArrayList<>();
        if (cond == null) cond = new BoolValue().setValue(false);
        for (Transition t : transitions) {
            if (t instanceof TransitionSingle) {
                // TODO reset the parent
                TransitionSingle tnew;
                tnew = (TransitionSingle) t.clone(null);

                tnew.guard = new BinaryOperatorTerm()
                        .setOpr(EnumBinaryOperator.LAND)
                        .setLeft(
                                new SingleOperatorTerm()
                                        .setOpr(EnumSingleOperator.LNOT)
                                        .setTerm(cond)
                        )
                        .setRight(tnew.guard);

                ctrans.add(tnew);
            } else {
                ctrans.addAll(
                        CanonicalizeTransitions(cond, ((TransitionGroup)t).transitions)
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

    public static Automaton Canonicalize(Automaton a) {
        Automaton an = new Automaton();

        an.name = a.name;
        an.localVars = a.localVars;
        an.entityInterface = a.entityInterface;
        an.template = a.template;
        an.setParent(a.getParent());

        TransitionGroup tg = new TransitionGroup();
        tg.setParent(an);

        try {
            tg.transitions = CanonicalizeTransitions(null, a.transitions);
        } catch (ValidationException e) {
            e.printStackTrace();
        }

        for (Transition t : tg.transitions) {
            t.setParent(an);
        }
        an.transitions.add(tg);

        return an;
    }

}
