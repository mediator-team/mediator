package org.fmgroup.mediator.plugins.generators.arduino;

import org.fmgroup.mediator.language.entity.Entity;
import org.fmgroup.mediator.language.statement.Statement;
import org.fmgroup.mediator.language.term.Term;
import org.fmgroup.mediator.language.type.Type;

public class ArduinoGeneratorException extends Exception{

    public ArduinoGeneratorException(String msg) {
        super(msg);
    }

    public static ArduinoGeneratorException UnhandledType(Type t) {
        ArduinoGeneratorException ex = new ArduinoGeneratorException(
                t.toString()
        );
        return ex;
    }

    public static ArduinoGeneratorException UnhandledTerm(Term t) {
        ArduinoGeneratorException ex = new ArduinoGeneratorException(
                t.toString() + " : " + t.getClass().toString()
        );
        return ex;
    }

    public static ArduinoGeneratorException UnhandledStatement(Statement t) {
        ArduinoGeneratorException ex = new ArduinoGeneratorException(
                t.toString() + " : " + t.getClass().toString()
        );
        return ex;
    }

    public static ArduinoGeneratorException UnclosedEntity(Entity entity) {
        ArduinoGeneratorException ex = new ArduinoGeneratorException(
                String.format(
                        "Entity %s is not closed.",
                        entity.getName()
                )
        );
        return ex;
    }

    public static ArduinoGeneratorException InconsistentPinType(int pinIndex) {
        ArduinoGeneratorException ex = new ArduinoGeneratorException(
                String.format(
                        "directions of pin %d are inconsistent.",
                        pinIndex
                )
        );
        return ex;
    }
}
