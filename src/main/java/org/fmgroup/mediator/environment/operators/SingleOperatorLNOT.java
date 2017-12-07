package org.fmgroup.mediator.environment.operators;

import org.fmgroup.mediator.language.term.BoolValue;
import org.fmgroup.mediator.language.term.Term;

public class SingleOperatorLNOT {
    public static Term compute(Term t) {
        return new BoolValue()
                .setParent(t.getParent())
                .setValue(!((BoolValue) t).getValue());
    }
}
