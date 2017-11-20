package org.fmgroup.mediator.language.term;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.MediatorLangParser;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.entity.PortIdentifier;


public class PortVariableValue implements RawElement, Term {

    public RawElement parent;
    public PortIdentifier port;
    public PortVariableType type;

    @Override
    public RawElement fromContext(ParserRuleContext context) throws ValidationException {
        if (!(context instanceof MediatorLangParser.PortVarValueContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "PortVarValueContext", context.toString());
        }

        port = (PortIdentifier) new PortIdentifier().parse(((MediatorLangParser.PortVarValueContext) context).scopedID(), this);
        type = PortVariableType.get(
                ((MediatorLangParser.PortVarValueContext) context).PORTVAR_SUFFIX().getText()
        );

        return this;
    }

    @Override
    public RawElement clone(RawElement parent) throws ValidationException {
        PortVariableValue npv = new PortVariableValue();
        npv.parent = this.parent;
        npv.type = this.type;
        npv.port = (PortIdentifier) this.port.clone(npv);

        return npv.validate();
    }

    @Override
    public String toString() {
        return port.toString() + "." + type.toString();
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
    public int getPrecedence() {
        return 14;
    }
}
