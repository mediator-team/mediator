package org.fmgroup.mediator.language.type.termType;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.generated.MediatorLangParser;
import org.fmgroup.mediator.language.term.Term;
import org.fmgroup.mediator.language.type.Type;

import java.util.Map;

public class NullType implements Type {

    private RawElement parent = null;

    @Override
    public NullType fromContext(ParserRuleContext context, RawElement parent) throws ValidationException {
        if (!(context instanceof MediatorLangParser.NullTypeContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "NullTypeContext", context.toString());
        }

        setParent(parent);
        return this;
    }

    @Override
    public String toString() {
        return "NULL";
    }

    @Override
    public RawElement getParent() {
        return parent;
    }

    @Override
    public NullType setParent(RawElement parent) {
        this.parent = parent;
        return this;
    }

    @Override
    public NullType copy(RawElement parent) throws ValidationException {
        return new NullType().setParent(parent);
    }

    @Override
    public NullType refactor(Map<String, Type> typeRewriteMap, Map<String, Term> termRewriteMap) throws ValidationException {
        return this;
    }
}
