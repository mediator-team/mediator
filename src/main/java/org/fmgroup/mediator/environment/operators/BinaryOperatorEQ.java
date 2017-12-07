package org.fmgroup.mediator.environment.operators;

import org.fmgroup.mediator.language.term.BoolValue;
import org.fmgroup.mediator.language.term.Term;
import org.fmgroup.mediator.plugins.simulator.SimulatorException;

public class BinaryOperatorEQ {
    public static Term compute(Term left, Term right) throws SimulatorException {
        return new BoolValue()
                .setParent(left.getParent())
                .setValue(left.equals(right));
    }
}
