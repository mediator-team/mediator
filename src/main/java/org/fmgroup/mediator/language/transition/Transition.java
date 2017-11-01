package org.fmgroup.mediator.language.transition;

import org.fmgroup.mediator.language.Automaton;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.term.Term;

public interface Transition extends RawElement {
    Term getGuard() throws ValidationException;
    Automaton getAutomaton();
}
