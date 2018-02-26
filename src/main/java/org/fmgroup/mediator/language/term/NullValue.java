package org.fmgroup.mediator.language.term;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.generated.MediatorLangParser;
import org.fmgroup.mediator.language.type.termType.NullType;
import org.fmgroup.mediator.language.type.Type;

public class NullValue implements Value {

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
    public NullValue fromContext(ParserRuleContext context, RawElement parent) throws ValidationException {
        if (!(context instanceof MediatorLangParser.NullValueContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "NullValueContext", context.toString());
        }

        setParent(parent);

        return this;
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
    public NullValue setParent(RawElement parent) {
        this.parent = parent;
        return this;
    }

    @Override
    public NullValue copy(RawElement parent) throws ValidationException {
        return new NullValue().setParent(parent);
    }

}
