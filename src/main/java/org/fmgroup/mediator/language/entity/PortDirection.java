package org.fmgroup.mediator.language.entity;

public enum PortDirection {
    IN("in"),
    OUT("out");

    private String value;

    PortDirection(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}