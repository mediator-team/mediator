package org.fmgroup.mediator.generator.framework;

import org.fmgroup.mediator.plugins.generators.arduino.ArduinoGeneratorException;
import org.fmgroup.mediator.language.RawElement;

public abstract class Generator {
    public abstract String generate(RawElement elem) throws ArduinoGeneratorException;
}
