package org.fmgroup.mediator.plugins.scheduler;

import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.Templated;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.entity.PortDeclaration;
import org.fmgroup.mediator.language.entity.automaton.Automaton;
import org.fmgroup.mediator.language.entity.automaton.Transition;
import org.fmgroup.mediator.language.entity.automaton.TransitionGroup;
import org.fmgroup.mediator.language.entity.automaton.TransitionSingle;
import org.fmgroup.mediator.language.entity.system.ComponentDeclaration;
import org.fmgroup.mediator.language.entity.system.Connection;
import org.fmgroup.mediator.language.entity.system.InternalDeclaration;
import org.fmgroup.mediator.language.entity.system.System;
import org.fmgroup.mediator.language.scope.VariableDeclaration;
import org.fmgroup.mediator.language.statement.AssignmentStatement;
import org.fmgroup.mediator.language.statement.Statement;
import org.fmgroup.mediator.language.statement.SynchronizingStatement;
import org.fmgroup.mediator.language.term.*;
import org.fmgroup.mediator.language.type.Type;
import org.fmgroup.mediator.language.type.termType.BoolType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scheduler {
    public static Automaton Schedule (System sys) throws ValidationException {
        Automaton a = new Automaton();
        a.setParent(sys.getParent());

        // simply copying basic information from the original system
        a.setName(sys.getName());
        a.setTemplate(sys.getTemplate().copy(a));
        a.setEntityInterface(sys.getEntityInterface().copy(a));

        /**
         * A system is composed of a set of components and connections, which are
         * described through automata or systems (we call entities). The variable
         * <i>entities</i> is used to store all scheduled and canonicalized entities
         * of a system.
         */
        List<Automaton> entities = new ArrayList<>();
        Map<Automaton, List<Transition>> extTransitions = new HashMap<>();
        Map<Automaton, Map<String, Type>> typeRewriteMaps = new HashMap<>();
        Map<Automaton, Map<String, Term>> termRewriteMaps = new HashMap<>();

        // generate node variables
        for (InternalDeclaration internalDecl: sys.getInternalCollection().getDeclarationList()) {
            for (String identifier: internalDecl.getIdentifiers()) {
                for (PortVariableType type: PortVariableType.values()) {
                    VariableDeclaration vardecl = new VariableDeclaration();
                    a.getLocalVars().addDeclaration(vardecl);
                    vardecl.addIdentifier(getNodeVariableName(identifier, type));
                    if (type == PortVariableType.VALUE) {
                        vardecl.setType(internalDecl.getType());
                    } else {
                        vardecl.setType(new BoolType());
                    }
                }
            }
        }

        /**
         * a. generate variables used in components, including
         * - port variables
         * - local variables
         * b. refactor transitions in components and store them in *transitions[component]*
         */
        for (ComponentDeclaration compdecl : sys.getComponentCollection().getDeclarationList()) {
            for (String componentName: compdecl.getIdentifiers()) {
                Templated rawComp = compdecl.getType().getProviderWithNoTemplate();
                if (rawComp instanceof System) {
                    rawComp = Schedule((System) rawComp);
                }

                Automaton automatonComp = Canonicalize((Automaton) rawComp);
                Map<String, Type> typeRewriteMap = new HashMap<>();
                Map<String, Term> termRewriteMap = new HashMap<>();

                // generate corresponding local variables
                for (VariableDeclaration vardecl: automatonComp.getLocalVars().getDeclarationList()) {
                    VariableDeclaration newvardecl = vardecl.copy(null).addPrefix(componentName + "_");
                    a.getLocalVars().addDeclaration(newvardecl);

                    for (int i = 0; i < vardecl.size(); i ++) {
                        termRewriteMap.put(
                                vardecl.getIdentifier(i),
                                new IdValue().setParent(a).setIdentifier(newvardecl.getIdentifier(i))
                        );
                    }
                }

                // generate corresponding port variables
                for (PortDeclaration portdecl: automatonComp.getEntityInterface().getDeclarationList()) {
                    for (String identifier: portdecl.getIdentifiers()) {
                        for (PortVariableType type: PortVariableType.values()) {
                            VariableDeclaration vardecl = new VariableDeclaration();
                            a.getLocalVars().addDeclaration(vardecl);
                            String varname = getPortVariableName(componentName, identifier, type);
                            vardecl.addIdentifier(varname);
                            if (type == PortVariableType.VALUE) {
                                vardecl.setType(portdecl.getType());
                            } else {
                                vardecl.setType(new BoolType());
                            }

                            termRewriteMap.put(identifier + "." + type.toString(), new IdValue().setParent(a).setIdentifier(varname));
                        }
                    }
                }

                entities.add(automatonComp);
                typeRewriteMaps.put(automatonComp, typeRewriteMap);
                termRewriteMaps.put(automatonComp, termRewriteMap);
            }
        }

        /**
         * generating variables used in connections, including
         * - local variables
         */
        for (Connection conn : sys.getConnections()) {
            Templated rawConn = conn.getProviderWithNoTemplate();
            if (rawConn instanceof System) {
                rawConn = Schedule((System) rawConn);
            }

            Automaton automatonConn = Canonicalize((Automaton) rawConn);
            Map<String, Type> typeRewriteMap = new HashMap<>();
            Map<String, Term> termRewriteMap = new HashMap<>();

            int connIndex = sys.getConnections().indexOf(conn);

            // generate corresponding variables
            for (VariableDeclaration vardecl: automatonConn.getLocalVars().getDeclarationList()) {
                VariableDeclaration newvardecl = vardecl.copy(null).addPrefix(
                        String.format(
                                "_%s_%d_", automatonConn.getName(), connIndex
                        )
                );
                a.getLocalVars().addDeclaration(newvardecl);

                for (int i = 0; i < vardecl.size(); i ++) {
                    termRewriteMap.put(
                            vardecl.getIdentifier(i),
                            new IdValue().setParent(a).setIdentifier(newvardecl.getIdentifier(i))
                    );
                }
            }

            // generate references of port variables
            for (int i = 0; i < conn.getPortIdentifiers().size(); i ++) {
                String portName = automatonConn.getEntityInterface().getDeclarationIdentifier(i);
                for (PortVariableType type: PortVariableType.values()) {

                    Term extPortVar = null;
                    if (conn.getPortIdentifiers().get(i).getOwner() != null) {
                        // the port belongs to one of its sub-entities
                        extPortVar = new IdValue().setParent(a).setIdentifier(
                                getPortVariableName(
                                        conn.getPortIdentifiers().get(i).getOwner(),
                                        conn.getPortIdentifiers().get(i).getPortName(),
                                        type
                                )
                        );
                    } else {
                        // the port belongs the system itself
                        extPortVar = new PortVariableValue().setParent(a)
                                .setPortIdentifier(conn.getPortIdentifiers().get(i)).setPortVariableType(type);
                    }

                    termRewriteMap.put(
                            portName + "." + type.toString(), extPortVar

                    );
                }
            }

            entities.add(automatonConn);
            typeRewriteMaps.put(automatonConn, typeRewriteMap);
            termRewriteMaps.put(automatonConn, termRewriteMap);
        }

        // deal with transitions;
        TransitionGroup tg = new TransitionGroup().setParent(a);
        a.addTransition(tg);

        // add internal transitions
        // since all automata are in canonical form, we assume that they contains one transition group
        // which is composed of a set of single transitions
        for (Automaton e: entities) {
            assert e.getTransitions().size() == 1 && e.getTransition(0) instanceof TransitionGroup;
            extTransitions.put(e, new ArrayList<>());
            extTransitions.get(e).add(null);
            for (Transition t: ((TransitionGroup) e.getTransition(0)).getTransitions()) {
                assert t instanceof TransitionSingle;
                if (((TransitionSingle) t).isInternal()) {
                    tg.addTransition(t.refactor(typeRewriteMaps.get(e), termRewriteMaps.get(e), tg));
                } else {
                    extTransitions.get(e).add(t.refactor(typeRewriteMaps.get(e), termRewriteMaps.get(e), a));
                }
            }
        }

        // start synchronization
        // CommandGenerate all possible combinations
        List<Map<Automaton, Transition>> combinations = new ArrayList<>();
        combinations.add(new HashMap<>());
        for (Automaton owner : entities) {
            List<Map<Automaton, Transition>> temp = new ArrayList<>();
            for (Transition t : extTransitions.get(owner)) {
                for (Map<Automaton, Transition> prevCombination : combinations) {
                    Map<Automaton, Transition> newCombination = new HashMap<>(prevCombination);
                    newCombination.put(owner, t);
                    temp.add(newCombination);
                }
            }

            combinations = temp;
        }

        for (Map<Automaton, Transition> combination : combinations) {
            TransitionSingle syncTrans = Synchronize(combination, a);
            if (syncTrans != null) {
                tg.addTransition(syncTrans);
            }
        }

        return a;
    }

    public static TransitionSingle Synchronize(Map<Automaton, Transition> combination, Automaton parent) throws ValidationException {
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

    private static String getNodeVariableName(String nodeId, PortVariableType type) {
        return String.format(
                "%s_%s", nodeId, type.toString()
        );
    }

    private static String getPortVariableName(String componentId, String portId, PortVariableType type) {
        return String.format(
                "%s_%s_%s", componentId, portId, type.toString()
        );
    }
}
