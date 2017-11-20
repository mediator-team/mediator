package org.fmgroup.mediator.language.entity.system;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.MediatorLangParser;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.entity.PortIdentifier;
import org.fmgroup.mediator.language.type.TemplateType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Connection implements RawElement {

    private RawElement parent;

    public List<PortIdentifier> ports = new ArrayList<>();
    public TemplateType type;

    @Override
    public RawElement fromContext(ParserRuleContext context) throws ValidationException {
        if (!(context instanceof MediatorLangParser.ConnectionDeclContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "ConnectionDeclContext", context.getClass().toString());
        }

        type = (TemplateType) new TemplateType().parse(((MediatorLangParser.ConnectionDeclContext) context).type(), this);

        for (MediatorLangParser.PortIdentifierContext portid : ((MediatorLangParser.ConnectionDeclContext) context).portIdentifier()) {
            ports.add((PortIdentifier) new PortIdentifier().parse(portid, this));
        }

        return this;
    }

    @Override
    public String toString() {
        return String.format(
                "%s(%s)",
                type.toString(),
                ports.stream().map(Object::toString).collect(Collectors.joining(", "))
        );
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

//    @Override
//    public RawElement validate() throws ValidationException {
//        if (!(parent instanceof System)) {
//            throw ValidationException.UnexpectedElement(this.getClass(), parent.getClass(),"System", "parent");
//        }
//
//        // are all the connected portDeclarations valid?
//        List<PortDeclaration> connectorPortDeclarations = type.provider.getInterface().portDeclarations;
//        if (ports.size() != connectorPortDeclarations.size())
//            throw ValidationException.FromMessage(
//                    String.format("Number of portDeclarations mismatched at %s.", this.toString())
//            );
//
//        for (IdValue portid : ports) {
//            boolean isInternal = false;
//            if (portid.scopeIdentifiers.size() == 0) {
//                // it is an internal node
//                if (((System) parent).internals.contains(portid.identifier)) {
//                    isInternal = true;
//                }
//            }
//
//            if (!isInternal) {
//                // we are quite sure that it is not an internal node
//                PortDeclaration portDeclaration = ((System) this.parent).locatePort(portid);
//                if (portDeclaration == null) throw ValidationException.UnknownIdentifier(portid.toString(), "portDeclaration");
//
//                PortDeclaration connectorport = connectorPortDeclarations.get(ports.indexOf(portid));
//                // direction and type must match
//                if (portDeclaration.parent.equals(this.parent) && connectorport.direction != portDeclaration.direction) {
//                    // the portDeclaration belongs to the system, then its type should be the same with the connector's portDeclaration
//                    throw ValidationException.FromMessage("PortDeclaration directions dismatch. " + this.toString());
//                }
//                if (!portDeclaration.parent.equals(this.parent) && connectorport.direction == portDeclaration.direction) {
//                    // the portDeclaration belongs to the system, then its type should be the same with the connector's portDeclaration
//                    throw ValidationException.FromMessage("PortDeclaration directions dismatch. " + this.toString());
//                }
//
//                if (!portDeclaration.type.toString().equals(connectorport.type.toString()))
//                    throw ValidationException.FromMessage("PortDeclaration type dismatch. " + this.toString());
//
//            }
//        }
//        return this;
//    }
}
