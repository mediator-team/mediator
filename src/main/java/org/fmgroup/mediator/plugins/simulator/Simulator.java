package org.fmgroup.mediator.plugins.simulator;


import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.entity.Entity;
import org.fmgroup.mediator.language.entity.automaton.Automaton;
import org.fmgroup.mediator.language.entity.automaton.Transition;
import org.fmgroup.mediator.language.entity.automaton.TransitionGroup;
import org.fmgroup.mediator.language.entity.automaton.TransitionSingle;
import org.fmgroup.mediator.language.scope.VariableDeclaration;
import org.fmgroup.mediator.language.statement.AssignmentStatement;
import org.fmgroup.mediator.language.statement.IteStatement;
import org.fmgroup.mediator.language.statement.Statement;
import org.fmgroup.mediator.language.statement.Statements;
import org.fmgroup.mediator.language.term.Term;
import org.fmgroup.mediator.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Simulator implements Plugin {

    private Entity entity;
    private List<SimulatorState> trace = new ArrayList<>();

    private int position;

    public Simulator () { }

    public Simulator (Entity entity) throws SimulatorException, ValidationException {
        this.entity = entity;
        initialization();
    }

    public void initialization() throws SimulatorException, ValidationException {
        SimulatorState s = new SimulatorState();
        if (entity instanceof Automaton) {
            EvaluationAutomaton ev = new EvaluationAutomaton();
            s.setEvaluation(ev);
            for (VariableDeclaration vardecl: ((Automaton) entity).getLocalVars().getDeclarationList()) {
                for (String identifier: vardecl.getIdentifiers()) {
                    ev.set(identifier, vardecl.getType().getInitValue());
                }
            }

            s.setSelectedTransition(nextTransition(ev));
        } else {
            // todo
            throw SimulatorException.UnderDevelopment();
        }

        trace.add(s);
    }

    public void stepForward() throws SimulatorException, ValidationException {
        // 1. perform the statement
        /** we assume that this function is invoked only after the simulator
         * has already been initialized, i.e. trace contains at least one element.
         */
        assert trace.size() > 0;

        if (entity instanceof Automaton) {
            // get last transition
            SimulatorState ss = trace.get(trace.size() - 1);
            SimulatorState ssNext = new SimulatorState();
            EvaluationAutomaton ev = (EvaluationAutomaton) ss.getEvaluation();
            EvaluationAutomaton bufev = (EvaluationAutomaton) ss.getBufferedEvaluation();

            Statement stmt = ss.getSelectedStatement();
            if (stmt == null) {
                /**
                 * there are two possibilities:
                 * 1. the last statement in current selected transition has been performed
                 * 2. no statements in the current selected transition have been selected
                 */
                if (ss.getBufferedEvaluation() != null) {
                    // case 1
                    ssNext.setEvaluation(bufev.copy());
                    ssNext.setBufferedEvaluation(null);
                    ssNext.setSelectedTransition(nextTransition(ev));
                    ssNext.setSelectedStatement(null);
                } else {
                    // case 2
                    ssNext.setEvaluation(ev.copy());
                    ssNext.setBufferedEvaluation(ev.copy());
                    ssNext.setSelectedStatement(nextStatement(ev, ss));
                    ssNext.setSelectedTransition(ss.getSelectedTransition());
                }
            }
            else if (stmt instanceof AssignmentStatement) {
                // compute the expression
                Term evresult = bufev.eval(((AssignmentStatement) stmt).getExpr());
                // assign to the variable
                ssNext.setEvaluation(ev);
                ssNext.setBufferedEvaluation(bufev.update(((AssignmentStatement) stmt).getTarget(), evresult));
                ssNext.setSelectedTransition(ss.getSelectedTransition());
                ssNext.setSelectedStatement(nextStatement(bufev, ss));
            } else {
                throw SimulatorException.UnderDevelopment();
            }


            trace.add(ssNext);
        }

        // 2. turn to next statement

    }

    public void restartFrom(int position) {}

    private TransitionSingle nextTransition(Evaluation ev) throws SimulatorException, ValidationException {
        if (entity instanceof Automaton && ev instanceof EvaluationAutomaton) {
            for (Transition t: ((Automaton) entity).getTransitions()) {
                if (t instanceof TransitionSingle) {
                    if (((EvaluationAutomaton) ev).eval(t.getGuard()).equals(Boolean.TRUE)) {
                        return (TransitionSingle) t;
                    }
                } else if (t instanceof TransitionGroup) {
                    List<TransitionSingle> options = new ArrayList<>();
                    for (Transition st: ((TransitionGroup) t).getTransitions()) {
                        assert st instanceof TransitionSingle;
                        if (((EvaluationAutomaton) ev).eval(st.getGuard()).equals(Boolean.TRUE)) {
                            options.add((TransitionSingle) st);
                        }
                    }

                    if (options.size() > 0) {
                        Random rand = new Random();
                        return options.get(rand.nextInt(options.size()));
                    }
                }
            }
        } else {
            // todo
            throw SimulatorException.UnderDevelopment();
        }

        return null;
    }

    private Statement nextStatement(Evaluation ev, SimulatorState ss) throws SimulatorException, ValidationException {
        Statement curr = ss.getSelectedStatement();
        if (curr == null) {
            if (ss.getSelectedTransition().getStatements().size() > 0)
                return ss.getSelectedTransition().getStatements().get(0);
            else return null;
        } else {
            if (curr.getParent() instanceof Statements) {
                return ((Statements) curr.getParent()).nextStatement(curr);
            } else {
                throw SimulatorException.UnderDevelopment();
            }
        }
    }

    @Override
    public String getName() {
        return "Simulator";
    }

    @Override
    public String getVersion() {
        return "0.0.1";
    }

    @Override
    public String getDescription() {
        return "a simple simulator based on parallel semantics";
    }
}
