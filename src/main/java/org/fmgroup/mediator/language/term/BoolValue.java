package org.fmgroup.mediator.language.term;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.generated.MediatorLangParser;
import org.fmgroup.mediator.language.type.termType.BoolType;
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
    public boolean equals(Object obj) {
        if (obj instanceof Boolean) {
            return getValue() == ((Boolean) obj).booleanValue();
        }

        if (obj instanceof BoolValue) {
            return getValue() == ((BoolValue) obj).getValue();
        }

        return false;
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
