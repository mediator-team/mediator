package org.fmgroup.mediator.language.type.termType;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.generated.MediatorLangParser;
import org.fmgroup.mediator.language.term.Term;
import org.fmgroup.mediator.language.type.Type;

import java.util.Map;

public class DoubleType implements Type {

    public RawElement parent = null;

    @Override
    public DoubleType fromContext(ParserRuleContext context, RawElement parent) throws ValidationException {
        if (!(context instanceof MediatorLangParser.DoubleTypeContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "DoubleTypeContext", context.toString());
        }

        setParent(parent);
        return this;
    }

    @Override
    public String toString() {
        return "double";
    }

    @Override
    public RawElement getParent() {
        return parent;
    }

    @Override
    public DoubleType setParent(RawElement parent) {
        this.parent = parent;
        return this;
    }

    @Override
    public DoubleType copy(RawElement parent) throws ValidationException {
        return new DoubleType().setParent(parent);
    }

    @Override
    public DoubleType refactor(Map<String, Type> typeRewriteMap, Map<String, Term> termRewriteMap) throws ValidationException {
        return this;
    }
}
