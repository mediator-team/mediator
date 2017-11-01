package org.fmgroup.mediator.language.type;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.MediatorLangParser;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;

public class DoubleType implements Type {

    public RawElement parent = null;

    @Override
    public String getName() {
        return null;
    }

    @Override
    public RawElement fromContext(ParserRuleContext context) throws ValidationException {
        if (!(context instanceof MediatorLangParser.DoubleTypeContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "DoubleTypeContext", context.toString());
        }

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
    public RawElement setParent(RawElement parent) {
        this.parent = parent;
        return this;
    }

    @Override
    public RawElement clone(RawElement parent) throws ValidationException {
        return new DoubleType().setParent(parent);
    }

    @Override
    public RawElement validate() throws ValidationException {
        return this;
    }
}
