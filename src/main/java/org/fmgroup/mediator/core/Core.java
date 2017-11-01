package org.fmgroup.mediator.core;

import org.fmgroup.mediator.core.scheduler.Scheduler;
import main.java.org.fmgroup.mediator.plugins.generators.arduino.ArduinoGenerator;
import main.java.org.fmgroup.mediator.plugins.generators.arduino.ArduinoGeneratorException;
import org.fmgroup.mediator.language.*;

import java.lang.System;

public class Core {
    public static void main (String args[]) {
        System.out.println("Mediator Tool Alpha.");
        Program prog2 = UtilLang.ParseFile("resources/models/testbench.med");
//        Program prog = UtilLang.ParseFile("resources/org.fmgroup.mediator.generator.arduino.libraries/arduino.med");
//        System.out.println(prog.dependencies);
//        GraphBasic gb = new GraphBasic(prog.automata.get(0), null);
//        System.out.println(gb);
//        try {
//            System.out.print(new ArduinoGenerator().generate(prog.automata.get(0)));
//        } catch (ArduinoGeneratorException e) {
//            e.printStackTrace();
//        }
        try {
            System.out.println(Scheduler.Schedule(prog2.systems.get("testbench")));
            System.out.println(
                    new ArduinoGenerator().generate(
                            Scheduler.Schedule(prog2.systems.get("testbench"))
                    )
            );
        }
        catch (ValidationException e) {
            e.printStackTrace();
        }
        catch (ArduinoGeneratorException e) {
            e.printStackTrace();
        }
//        System.out.println(Scheduler.Canonicalize(prog.automata.get("Gyro")).toString());
    }
}
