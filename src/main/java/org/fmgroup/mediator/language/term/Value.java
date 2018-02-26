package org.fmgroup.mediator.language.term;

import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.type.Type;

import java.util.Map;

public interface Value extends Term {
    @Override
    default Term refactor(Map<String, Type> typeRewriteMap, Map<String, Term> termRewriteMap) throws ValidationException {
        if (termRewriteMap.containsKey(toString())) {
            return termRewriteMap.get(toString()).copy(getParent());
        }

        return this;
    }
}
