package org.fmgroup.mediator.language;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.scope.Scope;

import java.util.ArrayList;
import java.util.List;

public interface RawElement {

    static Program getRoot(RawElement e) throws ValidationException {
        while (e != null) {
            if (e instanceof Program) return (Program) e;
            else
                e = e.getParent();
        }

        return null;
    }

    default RawElement fromContext(ParserRuleContext context, RawElement parent) throws ValidationException {
        throw ValidationException.UnderDevelopment();
    }

    RawElement getParent();

    RawElement setParent(RawElement parent);

    /**
     * copy the language element and assign it to another parent
     *
     * @param parent
     * @return
     * @throws ValidationException
     */
    default RawElement copy(RawElement parent) throws ValidationException {
        throw ValidationException.UnderDevelopment();
    }

    /**
     * copy the language element but still keep the parent pointer
     *
     * @return
     * @throws ValidationException
     */
    default RawElement copy() throws ValidationException {
        return copy(this.getParent());
    }

    default List<Scope> getScopes() throws ValidationException {
        RawElement p = this;
        List<Scope> result = new ArrayList<>();

        while (p != null) {
            if (p instanceof Scope) result.add((Scope) p);
            if (p instanceof Program) break;
            p = p.getParent();
        }

        return result;
    }

    default Scope getTopScope() throws ValidationException {
        List<Scope> scopes = this.getScopes();
        return scopes.get(scopes.size() - 1);
    }

    default Scope getCurrentScope() throws ValidationException {
        return getScopes().get(0);
    }
}
