package org.fmgroup.mediator.language.term;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.MediatorLangParser;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.type.IntType;
import org.fmgroup.mediator.language.type.NullType;
import org.fmgroup.mediator.language.type.Type;

public class NullValue implements Term {

    private RawElement parent = null;

    @Override
    public Type getType() {
        return new NullType();
    }

    @Override
    public int getPrecedence() {
        return 14;
    }

    @Override
    public RawElement fromContext(ParserRuleContext context) throws ValidationException {
        if (!(context instanceof MediatorLangParser.NullValueContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "NullValueContext", context.toString());
        }

        return this.validate();
    }

    @Override
    public String toString() {
        return "null";
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
        return new NullValue().setParent(parent).validate();
    }

    @Override
    public RawElement validate() throws ValidationException {
        // TODO
        return this;
    }

}
