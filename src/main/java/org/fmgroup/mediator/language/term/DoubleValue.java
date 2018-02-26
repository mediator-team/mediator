package org.fmgroup.mediator.language.term;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.generated.MediatorLangParser;
import org.fmgroup.mediator.language.type.termType.DoubleType;
import org.fmgroup.mediator.language.type.Type;

public class DoubleValue implements Value {

    private RawElement parent = null;
    private double value;

    @Override
    public Type getType() {
        return (Type) new DoubleType().setParent(parent);
    }

    @Override
    public int getPrecedence() {
        return 14;
    }

    @Override
    public DoubleValue fromContext(ParserRuleContext context, RawElement parent) throws ValidationException {
        if (!(context instanceof MediatorLangParser.DoubleValueContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "DoubleValueContext", context.toString());
        }

        setValue(Double.parseDouble(context.getText()));
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
    public DoubleValue setParent(RawElement parent) {
        this.parent = parent;
        return this;
    }

    public double getValue() {
        return value;
    }

    public DoubleValue setValue(double value) {
        this.value = value;
        return this;
    }

    @Override
    public DoubleValue copy(RawElement parent) throws ValidationException {
        return new DoubleValue()
                .setParent(parent)
                .setValue(this.value);
    }
}
