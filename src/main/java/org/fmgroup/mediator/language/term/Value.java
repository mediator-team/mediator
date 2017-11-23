package org.fmgroup.mediator.language.term;

import org.fmgroup.mediator.language.ValidationException;

import java.util.Map;

public interface Value extends Term {
    @Override
    default Term refactor(Map<String, Term> rewriteMap) throws ValidationException {
        if (rewriteMap.containsKey(toString())) {
            return rewriteMap.get(toString()).copy(getParent());
        }

        return this;
    }
}
