package org.fmgroup.mediator.language.term;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.MediatorLangParser;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.type.BoolType;
import org.fmgroup.mediator.language.type.Type;

public class BoolValue implements Term {

    public boolean value;

    private RawElement parent = null;

    @Override
    public Type getType() {
        return new BoolType();
    }

    @Override
    public int getPrecedence() {
        return 14;
    }

    @Override
    public RawElement fromContext(ParserRuleContext context) throws ValidationException {
        if (!(context instanceof MediatorLangParser.BoolValueContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "BoolValueContext", context.toString());
        }

        this.value = Boolean.valueOf(context.getText());
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
    public RawElement setParent(RawElement parent) {
        this.parent = parent;
        return this;
    }

    @Override
    public RawElement clone(RawElement parent) throws ValidationException {
        return new BoolValue().setValue(this.value).setParent(parent).validate();
    }

    public BoolValue setValue(boolean value) { this.value = value; return this; }

    @Override
    public RawElement validate() throws ValidationException {
        // TODO
        return this;
    }
}
