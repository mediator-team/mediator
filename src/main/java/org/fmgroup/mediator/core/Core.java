package org.fmgroup.mediator.core;

import org.fmgroup.mediator.core.scheduler.Scheduler;
import org.fmgroup.mediator.language.Program;
import org.fmgroup.mediator.language.*;
import org.fmgroup.mediator.plugins.generators.arduino.ArduinoGenerator;
import org.fmgroup.mediator.plugins.generators.arduino.ArduinoGeneratorException;

import java.lang.System;

public class Core {
    public static void main (String args[]) {
        System.out.println("Mediator Tool Alpha.");

//        Program prog = UtilLang.ParseFile("resources/models/test/types.med");

        Program prog2 = UtilLang.ParseFile("resources/models/smallcar/drivers/motor.med");
        try {
            System.out.println(
                    new ArduinoGenerator().generate(
                            Scheduler.Schedule(prog2.systems.get("testbench"))
                    )
            );
        }
        catch (ArduinoGeneratorException e) {
            e.printStackTrace();
        } catch (ValidationException e) {
            e.printStackTrace();
        }
        return;
    }
}
