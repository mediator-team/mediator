package org.fmgroup.mediator.language.transition;

import org.fmgroup.mediator.language.*;
import org.fmgroup.mediator.language.statement.Statement;
import org.fmgroup.mediator.language.statement.UtilStatement;
import org.fmgroup.mediator.language.term.IdValue;
import org.fmgroup.mediator.language.term.Term;
import org.fmgroup.mediator.language.term.UtilTerm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UtilTransition {

    public static Transition parse (MediatorLangParser.TransitionContext context, RawElement parent) throws ValidationException {

        if (context instanceof MediatorLangParser.TransitionSingleContext)
            return (Transition) new TransitionSingle().setParent(parent).fromContext(context);
        if (context instanceof MediatorLangParser.TransitionGroupContext)
            return (Transition) new TransitionGroup().setParent(parent).fromContext(context);

        throw ValidationException.UnregisteredTransition(context.getClass().toString());
    }

    public static Transition refactor(
            Transition t,
            Map<String, Term> baseRewriteMap,
            RawElement parent
    ) throws ValidationException {
        assert t instanceof TransitionSingle;
        TransitionSingle tnew = (TransitionSingle) t.clone(parent);

        // refactor the port variables
        Map<String, Term> rewriteMap = new HashMap<>(baseRewriteMap);

        tnew.guard = UtilTerm.refactor(tnew.guard, rewriteMap);
        for (int i = 0; i < tnew.statements.size(); i ++) {
            tnew.statements.set(
                    i,
                    UtilStatement.refactor(tnew.statements.get(i), rewriteMap)
            );
        }
        return tnew;
    }

}
