package org.fmgroup.mediator.language.entity;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.entity.system.ComponentDeclaration;
import org.fmgroup.mediator.language.generated.MediatorLangParser;
import org.fmgroup.mediator.language.scope.Scope;

public class PortIdentifier implements RawElement {
    private RawElement parent = null;
    private String portName;
    private String owner;
    private ComponentDeclaration componentReference = null;
    private PortDeclaration reference = null;

    public ComponentDeclaration getComponentReference() {
        return componentReference;
    }

    public String getOwner() {
        return owner;
    }

    public PortIdentifier setOwner(String owner) {
        this.owner = owner;
        return this;
    }

    public String getPortName() {
        return portName;
    }

    public PortIdentifier setPortName(String portName) throws ValidationException {
        return setPortName(portName, false);
    }

    public PortIdentifier setPortName(String portName, boolean noChecking) throws ValidationException {
        this.portName = portName;

        if (noChecking == false) {
            if (owner == null) {
                Scope scope = this.getCurrentScope();
                reference = scope.getPort(portName);
            } else {
                Scope scope = this.getCurrentScope();
                componentReference = scope.getComponent(owner);
                if (componentReference != null) {
                    reference = componentReference.getType().getProvider().getPort(portName);
                }
            }
        }

        return this;
    }

    public PortDeclaration getReference() {
        return reference;
    }

    public PortIdentifier setReference(PortDeclaration reference) {
        this.reference = reference;
        return this;
    }

    @Override
    public PortIdentifier fromContext(ParserRuleContext context, RawElement parent) throws ValidationException {
        if (!(context instanceof MediatorLangParser.PortIdentifierContext || context instanceof MediatorLangParser.ScopedIDContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "PortIdentifierContext", context.getClass().getName());
        }

        setParent(parent);

        if (context instanceof MediatorLangParser.PortIdentifierContext) {
            if (((MediatorLangParser.PortIdentifierContext) context).owner != null) {
                setOwner(
                        ((MediatorLangParser.PortIdentifierContext) context).owner.getText()
                );
            }

            setPortName(((MediatorLangParser.PortIdentifierContext) context).identifier.getText());
        } else {
            if (((MediatorLangParser.ScopedIDContext) context).scopes.size() > 1) {
                throw ValidationException.FromMessage("unknown port");
            }

            if (((MediatorLangParser.ScopedIDContext) context).scopes.size() == 1)
                setOwner(((MediatorLangParser.ScopedIDContext) context).scopes.get(0).getText());

            setPortName(((MediatorLangParser.ScopedIDContext) context).identifier.getText());
        }

        return this;
    }

    @Override
    public String toString() {
        if (owner == null) return portName;
        else return owner + "." + portName;
    }

    @Override
    public RawElement getParent() {
        return parent;
    }

    @Override
    public PortIdentifier setParent(RawElement parent) {
        this.parent = parent;
        return this;
    }

    @Override
    public PortIdentifier copy(RawElement parent) throws ValidationException {
        PortIdentifier portid = new PortIdentifier();
        portid.setParent(parent);

        portid.setOwner(owner);
        portid.setPortName(portName);

        return portid;
    }
}