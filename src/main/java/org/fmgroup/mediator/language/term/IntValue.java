package org.fmgroup.mediator.language.term;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.MediatorLangParser;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.type.IntType;
import org.fmgroup.mediator.language.type.Type;

public class IntValue implements Term {

    private RawElement parent = null;

    public int value;

    @Override
    public Type getType() {
        return new IntType();
    }

    @Override
    public int getPrecedence() {
        return 14;
    }

    @Override
    public RawElement fromContext(ParserRuleContext context) throws ValidationException {
        if (!(context instanceof MediatorLangParser.IntValueContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "IntValueContext", context.toString());
        }

        this.value = Integer.parseInt(context.getText());
        return this.validate();
    }

    @Override
    public String toString() {
        return String.valueOf(value);
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

    public IntValue setValue(int value) { this.value = value; return this; }

    @Override
    public RawElement clone(RawElement parent) throws ValidationException {
        return new IntValue().setValue(this.value).setParent(parent).validate();
    }

    @Override
    public RawElement validate() throws ValidationException {
        // TODO
        return this;
    }
}
