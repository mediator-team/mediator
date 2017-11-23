package org.fmgroup.mediator.language.term;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.MediatorLangParser;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.type.BoolType;
import org.fmgroup.mediator.language.type.Type;

/**
 * formalization for boolean value true/false
 */
public class BoolValue implements Value {

    private boolean value;
    private RawElement parent = null;

    @Override
    public Type getType() {
        return (Type) new BoolType().setParent(parent);
    }

    @Override
    public int getPrecedence() {
        return 14;
    }

    @Override
    public BoolValue fromContext(ParserRuleContext context, RawElement parent) throws ValidationException {
        if (!(context instanceof MediatorLangParser.BoolValueContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "BoolValueContext", context.toString());
        }

        setValue(Boolean.valueOf(context.getText()));
        return this;
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
    public BoolValue setParent(RawElement parent) {
        this.parent = parent;
        return this;
    }

    @Override
    public BoolValue copy(RawElement parent) throws ValidationException {
        return new BoolValue().setParent(parent).setValue(this.value);
    }

    public boolean getValue() {
        return this.value;
    }

    public BoolValue setValue(boolean value) {
        this.value = value;
        return this;
    }
}
