package org.fmgroup.mediator.language.entity.system;

import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.Templated;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.entity.PortIdentifier;

import java.util.ArrayList;
import java.util.List;

public abstract class Connection implements RawElement {
    public RawElement parent;
    public List<PortIdentifier> portIdentifiers = new ArrayList<>();

    public abstract Templated getProvider();

    public Templated getProviderWithNoTemplate() throws ValidationException {
        return getProvider().resolveTemplate(getParams());
    }
    public abstract List<RawElement> getParams();

    @Override
    public RawElement getParent() {
        return parent;
    }

    @Override
    public RawElement setParent(RawElement parent) {
        this.parent = parent;
        return this;
    }

    public List<PortIdentifier> getPortIdentifiers() {
        return portIdentifiers;
    }

    public Connection setPortIdentifiers(List<PortIdentifier> portIdentifiers) {
        this.portIdentifiers.forEach(this::addPortIdentifier);
        return this;
    }

    public Connection addPortIdentifier(PortIdentifier portIdentifier) {
        portIdentifiers.add(portIdentifier);
        portIdentifier.setParent(this);
        return this;
    }

}
