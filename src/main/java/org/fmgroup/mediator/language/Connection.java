package org.fmgroup.mediator.language;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.System;
import org.fmgroup.mediator.language.term.IdValue;
import org.fmgroup.mediator.language.term.Term;
import org.fmgroup.mediator.language.term.TupleTerm;
import org.fmgroup.mediator.language.term.UtilTerm;
import org.fmgroup.mediator.language.type.IdType;
import org.fmgroup.mediator.language.type.InterfaceType;
import org.fmgroup.mediator.language.type.Type;
import org.fmgroup.mediator.language.type.UtilType;

import java.util.ArrayList;
import java.util.List;

public class Connection implements RawElement {

    private RawElement parent;

    public List<IdValue> ports = new ArrayList<>();
    public InterfaceType type;

    private void addPortsFromTerm(Term t) throws ValidationException {
        if (t instanceof IdValue) {
            ports.add((IdValue) t);
        } else if (t instanceof TupleTerm) {
            addPortsFromTerm(((TupleTerm) t).left);
            addPortsFromTerm(((TupleTerm) t).right);
        } else {
            throw ValidationException.UnexpectedTermType(t.getClass(), "IdValue or TupleTerm");
        }
    }

    @Override
    public RawElement fromContext(ParserRuleContext context) throws ValidationException {
        if (!(context instanceof MediatorLangParser.ConnectionDeclContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "ConnectionDeclContext", context.getClass().toString());
        }

        Type connType = UtilType.parse(((MediatorLangParser.ConnectionDeclContext) context).type(), this);
        if (!(connType instanceof InterfaceType) && !(connType instanceof IdType)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "InterfaceType", connType.getClass().toString());
        }

        if (connType instanceof IdType) {
            InterfaceType _connType = (InterfaceType) new InterfaceType().setParent(connType.getParent());
            _connType.reference = (IdValue) new IdValue().setIdentifier(((IdType) connType).identifier).setParent(connType);
            connType = _connType;
            connType.validate();
        }

        type = (InterfaceType) connType;

        this.addPortsFromTerm(UtilTerm.parse(((MediatorLangParser.ConnectionDeclContext) context).term(), this));

        return this.validate();
    }

    @Override
    public String toString() {
        List<String> portStr = new ArrayList<>();
        for (IdValue p : ports) portStr.add(p.toString());

        return type.toString() + "(" + String.join(", ", portStr) + ")";
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

    @Override
    public RawElement clone(RawElement parent) {
        return null;
    }

    @Override
    public RawElement validate() throws ValidationException {
        if (!(parent instanceof System)) {
            throw ValidationException.UnexpectedElement(this.getClass(), parent.getClass(),"System", "parent");
        }

        // are all the connected ports valid?
        List<Port> connectorPorts = type.provider.getInterface().ports;
        if (ports.size() != connectorPorts.size())
            throw ValidationException.FromMessage(
                    String.format("Number of ports mismatched at %s.", this.toString())
            );

        for (IdValue portid : ports) {
            boolean isInternal = false;
            if (portid.scopes.size() == 0) {
                // it is an internal node
                if (((System) parent).internals.contains(portid.identifier)) {
                    isInternal = true;
                }
            }

            if (!isInternal) {
                // we are quite sure that it is not an internal node
                Port port = ((System) this.parent).locatePort(portid);
                if (port == null) throw ValidationException.UnknownIdentifier(portid.toString(), "port");

                Port connectorport = connectorPorts.get(ports.indexOf(portid));
                // direction and type must match
                if (port.parent.equals(this.parent) && connectorport.direction != port.direction) {
                    // the port belongs to the system, then its type should be the same with the connector's port
                    throw ValidationException.FromMessage("Port directions dismatch. " + this.toString());
                }
                if (!port.parent.equals(this.parent) && connectorport.direction == port.direction) {
                    // the port belongs to the system, then its type should be the same with the connector's port
                    throw ValidationException.FromMessage("Port directions dismatch. " + this.toString());
                }

                if (!port.type.toString().equals(connectorport.type.toString()))
                    throw ValidationException.FromMessage("Port type dismatch. " + this.toString());

            }
        }
        return this;
    }
}
