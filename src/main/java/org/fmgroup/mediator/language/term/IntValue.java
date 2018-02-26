package org.fmgroup.mediator.language.term;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.generated.MediatorLangParser;
import org.fmgroup.mediator.language.type.termType.IntType;
import org.fmgroup.mediator.language.type.Type;

public class IntValue implements Value {

    private RawElement parent = null;
    private int value;

    public int getValue() {
        return value;
    }

    public IntValue setValue(int value) {
        this.value = value;
        return this;
    }

    @Override
    public Type getType() {
        return new IntType();
    }

    @Override
    public int getPrecedence() {
        return 14;
    }

    @Override
    public IntValue fromContext(ParserRuleContext context, RawElement parent) throws ValidationException {
        if (!(context instanceof MediatorLangParser.IntValueContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "IntValueContext", context.toString());
        }

        setParent(parent);
        setValue(Integer.parseInt(context.getText()));
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
    public IntValue setParent(RawElement parent) {
        this.parent = parent;
        return this;
    }

    @Override
    public IntValue copy(RawElement parent) throws ValidationException {
        return new IntValue().setParent(parent)
                .setValue(this.value);
    }
}
