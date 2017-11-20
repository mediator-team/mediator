package org.fmgroup.mediator.language.entity.automaton;

import org.fmgroup.mediator.language.MediatorLangParser;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.scope.Scope;
import org.fmgroup.mediator.language.statement.Statement;
import org.fmgroup.mediator.language.term.Term;

import java.util.HashMap;
import java.util.Map;

public interface Transition extends RawElement {
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

    static Transition parse (MediatorLangParser.TransitionContext context, RawElement parent) throws ValidationException {

        if (context instanceof MediatorLangParser.TransitionSingleContext)
            return (Transition) new TransitionSingle().setParent(parent).fromContext(context);
        if (context instanceof MediatorLangParser.TransitionGroupContext)
            return (Transition) new TransitionGroup().setParent(parent).fromContext(context);

        throw ValidationException.UnregisteredTransition(context.getClass().toString());
    }

    static Transition refactor(
            Transition t,
            Map<String, Term> baseRewriteMap,
            RawElement parent
    ) throws ValidationException {
        assert t instanceof TransitionSingle;
        TransitionSingle tnew = (TransitionSingle) t.clone(parent);

        // refactor the port variables
        Map<String, Term> rewriteMap = new HashMap<>(baseRewriteMap);

        tnew.guard = Term.refactor(tnew.guard, rewriteMap);
        for (int i = 0; i < tnew.statements.size(); i ++) {
            tnew.statements.set(
                    i,
                    Statement.refactor(tnew.statements.get(i), rewriteMap)
            );
        }
        return tnew;
    }
}
