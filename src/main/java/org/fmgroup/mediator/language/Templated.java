package org.fmgroup.mediator.language;

import org.fmgroup.mediator.language.scope.Scope;
import org.fmgroup.mediator.language.scope.TypeDeclaration;
import org.fmgroup.mediator.language.term.Term;
import org.fmgroup.mediator.language.type.Type;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface Templated extends RawElement, Scope {
    Template getTemplate();
    Templated setTemplate(Template t);

    default Templated resolveTemplate(List<RawElement> params) throws ValidationException {
        if (getTemplate().size() != params.size()) {
            throw ValidationException.UnderDevelopment();
        }

        Templated resolved = (Templated) copy(getParent());

        Map<String, Type> typeRewriteMap = new HashMap<>();
        Map<String, Term> termRewriteMap = new HashMap<>();

        for (int i = 0; i < params.size(); i ++) {
            if (params.get(i) instanceof Type && getTemplate().getDeclaration(i) instanceof TypeDeclaration) {
                typeRewriteMap.put(getTemplate().getDeclarationIdentifier(i), (Type) params.get(i));
            } else {
                termRewriteMap.put(getTemplate().getDeclarationIdentifier(i), (Term) params.get(i));
            }
        }

        resolved.refactor(typeRewriteMap, termRewriteMap);
        resolved.setTemplate(new Template());
        return resolved;
    }

    Templated refactor(Map<String, Type> typeRewriteMap, Map<String, Term> termRewriteMap) throws ValidationException;
}
