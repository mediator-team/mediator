package org.fmgroup.mediator.plugins.simulator;

import org.fmgroup.mediator.language.entity.automaton.TransitionSingle;
import org.fmgroup.mediator.language.statement.Statement;


public class SimulatorState {

    private TransitionSingle selectedTransition = null;
    private Statement selectedStatement = null;
    private Evaluation evaluation = null;
    private Evaluation bufferedEvaluation = null;

    public Evaluation getBufferedEvaluation() {
        return bufferedEvaluation;
    }

    public SimulatorState setBufferedEvaluation(Evaluation bufferedEvaluation) {
        this.bufferedEvaluation = bufferedEvaluation;
        return this;
    }

    public TransitionSingle getSelectedTransition() {
        return selectedTransition;
    }

    public SimulatorState setSelectedTransition(TransitionSingle selectedTransition) {
        this.selectedTransition = selectedTransition;
        return this;
    }

    public Statement getSelectedStatement() {
        return selectedStatement;
    }

    public SimulatorState setSelectedStatement(Statement selectedStatement) {
        this.selectedStatement = selectedStatement;
        return this;
    }

    public Evaluation getEvaluation() {
        return evaluation;
    }

    public SimulatorState setEvaluation(Evaluation evaluation) {
        this.evaluation = evaluation;
        return this;
    }
}
