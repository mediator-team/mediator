package org.fmgroup.mediator.language.term;

import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.type.termType.EnumType;

public class EnumValue implements Value {

    private RawElement parent;
    private EnumType reference;
    private String identifier;

    public EnumType getReference() {
        return reference;
    }

    public EnumValue setReference(EnumType reference) {
        this.reference = reference;
        return this;
    }

    public String getIdentifier() {
        return identifier;
    }

    public EnumValue setIdentifier(String identifier) throws ValidationException {
        this.identifier = identifier;
        if (!getReference().getItems().contains(identifier)) {
            throw ValidationException.UnknownIdentifier(identifier, "enum item");
        }
        return this;
    }

    @Override
    public EnumValue copy(RawElement parent) throws ValidationException {
        EnumValue newev = new EnumValue().setParent(parent);
        newev.setReference(getReference());
        newev.setIdentifier(getIdentifier());

        return newev;
    }

    @Override
    public String toString() {
        return identifier;
    }

    @Override
    public int getPrecedence() {
        return 14;
    }

    @Override
    public RawElement getParent() {
        return this.parent;
    }

    @Override
    public EnumValue setParent(RawElement parent) {
        this.parent = parent;
        return this;
    }
}
