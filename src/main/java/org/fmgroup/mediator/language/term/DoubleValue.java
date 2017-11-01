package org.fmgroup.mediator.language.term;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.MediatorLangParser;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.type.DoubleType;
import org.fmgroup.mediator.language.type.IntType;
import org.fmgroup.mediator.language.type.Type;

public class DoubleValue implements Term {

    private RawElement parent = null;

    public double value;

    @Override
    public Type getType() {
        return new DoubleType();
    }

    @Override
    public int getPrecedence() {
        return 14;
    }

    @Override
    public RawElement fromContext(ParserRuleContext context) throws ValidationException {
        if (!(context instanceof MediatorLangParser.DoubleValueContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "DoubleValueContext", context.toString());
        }

        this.value = Double.parseDouble(context.getText());
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

    public DoubleValue setValue(double value) { this.value = value; return this; }

    @Override
    public RawElement clone(RawElement parent) throws ValidationException {
        return new DoubleValue().setValue(this.value).setParent(parent).validate();
    }

    @Override
    public RawElement validate() throws ValidationException {
        // TODO
        return this;
    }
}
