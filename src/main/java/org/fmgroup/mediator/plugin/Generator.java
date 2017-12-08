package org.fmgroup.mediator.plugin;

import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.plugins.generators.arduino.ArduinoGeneratorException;

public interface Generator extends Plugin {
    String generate(RawElement elem) throws ArduinoGeneratorException;

    /**
     * check whether a mediator model can be generated into target code. for example,
     * if a non-arduino model contains pinMode function it cannot be generated
     * @param elem
     * @return
     * @throws ArduinoGeneratorException
     */
    default boolean available(RawElement elem) throws ArduinoGeneratorException {
        return true;
    }

    String getSupportedPlatform();
}
