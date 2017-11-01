package main.java.org.fmgroup.mediator.plugins.generators.arduino;

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

}
