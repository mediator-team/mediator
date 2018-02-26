package org.fmgroup.mediator.language.type.termType;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.generated.MediatorLangParser;
import org.fmgroup.mediator.language.term.Term;
import org.fmgroup.mediator.language.type.Type;

import java.util.Map;

public class IntType implements Type {

    private RawElement parent = null;

    @Override
    public IntType fromContext(ParserRuleContext context, RawElement parent) throws ValidationException {
        if (!(context instanceof MediatorLangParser.IntTypeContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "IntTypeContext", context.toString());
        }

        setParent(parent);
        return this;
    }

    @Override
    public String toString() {
        return "int";
    }

    @Override
    public RawElement getParent() {
        return parent;
    }

    @Override
    public IntType setParent(RawElement parent) {
        this.parent = parent;
        return this;
    }

    @Override
    public IntType copy(RawElement parent) throws ValidationException {
        return new IntType().setParent(parent);
    }

    @Override
    public Type refactor(Map<String, Type> typeRewriteMap, Map<String, Term> termRewriteMap) throws ValidationException {
        return this;
    }
}
