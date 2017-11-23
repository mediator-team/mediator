package org.fmgroup.mediator.language.term;

public enum PortVariableType {
    VALUE("value"),
    REQREAD("reqRead"),
    REQWRITE("reqWrite");

    private String value;

    PortVariableType(String value) {
        this.value = value;
    }

    public static PortVariableType fromString(String value) {
        if (value.equals(VALUE.value)) return VALUE;
        else if (value.equals(REQREAD.value)) return REQREAD;
        else if (value.equals(REQWRITE.value)) return REQWRITE;

        return null;
    }

    @Override
    public String toString() {
        return this.value;
    }
}