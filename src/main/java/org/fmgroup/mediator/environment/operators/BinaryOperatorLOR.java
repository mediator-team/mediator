package org.fmgroup.mediator.environment.operators;

import org.fmgroup.mediator.language.term.BoolValue;
import org.fmgroup.mediator.language.term.Term;
import org.fmgroup.mediator.plugins.simulator.SimulatorException;

public class BinaryOperatorLOR {
    public static Term compute(Term left, Term right) throws SimulatorException {
        if (left instanceof BoolValue && right instanceof BoolValue) {
            return new BoolValue()
                    .setParent(left.getParent())
                    .setValue(((BoolValue) left).getValue() || ((BoolValue) right).getValue());
        }

        throw SimulatorException.UnderDevelopment();
    }
}
