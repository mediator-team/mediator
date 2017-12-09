package org.fmgroup.mediator.language.entity.automaton;

import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.generated.MediatorLangParser;
import org.fmgroup.mediator.language.scope.Scope;
import org.fmgroup.mediator.language.term.Term;

import java.util.Map;

public interface Transition extends RawElement {

    static Transition parse(MediatorLangParser.TransitionContext context, RawElement parent) throws ValidationException {

        if (context instanceof MediatorLangParser.TransitionSingleContext)
            return new TransitionSingle().fromContext(context, parent);
        if (context instanceof MediatorLangParser.TransitionGroupContext)
            return new TransitionGroup().fromContext(context, parent);

        throw ValidationException.UnregisteredTransition(context.getClass().toString());
    }

    Term getGuard() throws ValidationException;

    default Automaton getAutomaton() throws ValidationException {
        Scope currScope = getCurrentScope();
        if (currScope instanceof Automaton) return (Automaton) currScope;
        else {
            throw ValidationException.UnexpectedElement(
                    Automaton.class,
                    (Class<? extends RawElement>) currScope.getClass(),
                    "Automaton",
                    "scope"
            );
        }
    }

    default TransitionSingle refactor(Map<String, Term> rewriteMap, RawElement parent) throws ValidationException {
        throw ValidationException.UnderDevelopment();
    }
}
