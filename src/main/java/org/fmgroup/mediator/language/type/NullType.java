package org.fmgroup.mediator.language.type;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.MediatorLangParser;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;

public class NullType implements Type {

    private RawElement parent = null;

    @Override
    public String getName() {
        return "NULL";
    }

    @Override
    public RawElement fromContext(ParserRuleContext context) throws ValidationException {
        if (!(context instanceof MediatorLangParser.NullTypeContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "NullTypeContext", context.toString());
        }

        return this.validate();
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
    public RawElement setParent(RawElement parent)  {
        this.parent = parent;
        return this;
    }

    @Override
    public RawElement clone(RawElement parent) throws ValidationException {
        return new NullType().setParent(parent).validate();
    }

    @Override
    public RawElement validate() throws ValidationException {
        // TODO
        return this;
    }
}
