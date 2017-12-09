package org.fmgroup.mediator.language.term;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.entity.PortIdentifier;
import org.fmgroup.mediator.language.generated.MediatorLangParser;


public class PortVariableValue implements RawElement, Value {

    private RawElement parent;
    private PortIdentifier portIdentifier;
    private PortVariableType portVariableType;

    public PortIdentifier getPortIdentifier() {
        return portIdentifier;
    }

    public PortVariableValue setPortIdentifier(PortIdentifier portIdentifier) {
        this.portIdentifier = portIdentifier;
        portIdentifier.setParent(this);
        return this;
    }

    public PortVariableType getPortVariableType() {
        return portVariableType;
    }

    public PortVariableValue setPortVariableType(PortVariableType portVariableType) {
        this.portVariableType = portVariableType;
        return this;
    }

    @Override
    public PortVariableValue fromContext(ParserRuleContext context, RawElement parent) throws ValidationException {
        if (!(context instanceof MediatorLangParser.PortVarValueContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "PortVarValueContext", context.toString());
        }

        setParent(parent);
        setPortIdentifier(new PortIdentifier().fromContext(((MediatorLangParser.PortVarValueContext) context).scopedID(), this));
        setPortVariableType(PortVariableType.fromString(
                ((MediatorLangParser.PortVarValueContext) context).PORTVAR_SUFFIX().getText()
        ));

        return this;
    }

    @Override
    public PortVariableValue copy(RawElement parent) throws ValidationException {
        PortVariableValue npv = new PortVariableValue();

        npv.setParent(parent);
        npv.setPortVariableType(portVariableType);
        npv.setPortIdentifier(getPortIdentifier().copy(npv));

        return npv;
    }

    @Override
    public String toString() {
        return portIdentifier.toString() + "." + portVariableType.toString();
    }

    @Override
    public RawElement getParent() {
        return parent;
    }

    @Override
    public PortVariableValue setParent(RawElement parent) {
        this.parent = parent;
        return this;
    }

    @Override
    public int getPrecedence() {
        return 14;
    }
}
