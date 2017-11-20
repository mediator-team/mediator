package org.fmgroup.mediator.language.entity;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.fmgroup.mediator.language.MediatorLangParser;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.entity.system.ComponentDeclaration;
import org.fmgroup.mediator.language.scope.Scope;

import java.util.ArrayList;
import java.util.List;

public class PortIdentifier implements RawElement {
    public RawElement parent = null;

    public String portName;
    public List<String> scopeIdentifiers = new ArrayList<>();
    public ComponentDeclaration componentReference = null;
    public PortDeclaration reference = null;

    @Override
    public RawElement fromContext(ParserRuleContext context) throws ValidationException {
        if (!(context instanceof MediatorLangParser.PortIdentifierContext || context instanceof MediatorLangParser.ScopedIDContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "PortIdentifierContext", context.getClass().getName());
        }

        if (context instanceof MediatorLangParser.PortIdentifierContext) {
            portName = ((MediatorLangParser.PortIdentifierContext) context).identifier.getText();
            if (((MediatorLangParser.PortIdentifierContext) context).owner != null) {
                scopeIdentifiers.add(((MediatorLangParser.PortIdentifierContext) context).owner.getText());
            }
        } else {
            portName = ((MediatorLangParser.ScopedIDContext) context).identifier.getText();
            for (Token scopeid : ((MediatorLangParser.ScopedIDContext) context).scopes) {
                scopeIdentifiers.add(scopeid.toString());
            }
        }

        if (scopeIdentifiers.size() == 0) {
            Scope scope = this.getCurrentScope();
            reference = scope.getPort(portName);
        } else if (scopeIdentifiers.size() == 1){
            Scope scope = this.getCurrentScope();
            componentReference = scope.getComponent(scopeIdentifiers.get(0));
            if (componentReference != null) {
                reference = componentReference.type.provider.getPort(portName);
            }
        }

        if (reference == null) {
            throw ValidationException.UnknownIdentifier(this.toString(), "port");
        }

        return this;
    }

    @Override
    public String toString() {
        String scopeStr = String.join(".", scopeIdentifiers);
        if (scopeStr.length() == 0) return portName;
        else return scopeStr + "." + portName;
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
        PortIdentifier portid = new PortIdentifier();
        portid.setParent(parent);
        portid.portName = portName;
        portid.reference = reference;
        portid.validate();

        return portid;
    }
}