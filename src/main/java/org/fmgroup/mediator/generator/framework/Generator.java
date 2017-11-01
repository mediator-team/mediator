package org.fmgroup.mediator.generator.framework;

import main.java.org.fmgroup.mediator.plugins.generators.arduino.ArduinoGeneratorException;
import org.fmgroup.mediator.language.RawElement;

public abstract class Generator {
    public abstract String generate(RawElement elem) throws ArduinoGeneratorException;
}
