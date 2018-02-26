package org.fmgroup.mediator.language.type.termType;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.generated.MediatorLangParser;
import org.fmgroup.mediator.language.term.BoolValue;
import org.fmgroup.mediator.language.term.Term;
import org.fmgroup.mediator.language.type.Type;

import java.util.Map;

public class BoolType implements Type {

    private RawElement parent = null;

    @Override
    public Type refactor(Map<String, Type> typeRewriteMap, Map<String, Term> termRewriteMap) throws ValidationException {
        return null;
    }

    @Override
    public BoolType fromContext(ParserRuleContext context, RawElement parent) throws ValidationException {
        if (!(context instanceof MediatorLangParser.BoolTypeContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "BoolTypeContext", context.toString());
        }


        setParent(parent);
        return this;
    }

    @Override
    public Term getInitValue() throws ValidationException {
        return new BoolValue().setValue(false);
    }

    @Override
    public String toString() {
        return "bool";
    }

    @Override
    public RawElement getParent() {
        return parent;
    }

    @Override
    public BoolType setParent(RawElement parent) {
        this.parent = parent;
        return this;
    }

    @Override
    public BoolType copy(RawElement parent) throws ValidationException {
        return new BoolType().setParent(parent);
    }
}
