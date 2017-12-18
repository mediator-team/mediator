package org.fmgroup.mediator.language.property;

import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.term.Term;

public interface Formulae extends RawElement, Term {
    @Override
    default int getPrecedence() {
        return 0;
    }
}
