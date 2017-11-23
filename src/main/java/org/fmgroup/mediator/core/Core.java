package org.fmgroup.mediator.core;

import org.fmgroup.mediator.core.project.Project;
import org.fmgroup.mediator.core.project.ProjectException;
import org.fmgroup.mediator.core.scheduler.Scheduler;
import org.fmgroup.mediator.language.Program;
import org.fmgroup.mediator.language.*;
import org.fmgroup.mediator.plugins.generators.arduino.ArduinoGenerator;
import org.fmgroup.mediator.plugins.generators.arduino.ArduinoGeneratorException;

import java.lang.System;

public class Core {
    public static void main (String args[]) throws ProjectException {
        System.out.println("Mediator Tool Alpha.");
        Project proj = new Project("resources/models/smallcar");
        Program prog = proj.parseFile("drivers/motor.med");

//        System.out.println(prog.toString());

        try {
            System.out.println(
                    new ArduinoGenerator().generate(
                            Scheduler.Schedule(prog.systems.get("testbench"))
                    )
            );
        }
        catch (ArduinoGeneratorException e) {
            e.printStackTrace();
        } catch (ValidationException e) {
            e.printStackTrace();
        }

    }
}
