package org.fmgroup.mediator.language;

import org.fmgroup.mediator.language.type.Type;

enum PortDirection {
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

public class Port {

    public static String [] adjointVariables = {"value", "reqRead", "reqWrite"};

    public String name;
    public PortDirection direction;
    public Type type;
    public InterfacedElement parent;

    public Port() {}

    public Port(Port p, InterfacedElement newParent) {
        parent = newParent;
        name = p.name;
        direction = p.direction;

        // TODO use copy constructor instead
        type = p.type;
    }
}