package org.fmgroup.mediator.core;

import org.fmgroup.mediator.core.project.Project;
import org.fmgroup.mediator.core.project.ProjectException;
import org.fmgroup.mediator.core.scheduler.Scheduler;
import org.fmgroup.mediator.language.Program;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.plugins.generators.arduino.ArduinoGenerator;
import org.fmgroup.mediator.plugins.generators.arduino.ArduinoGeneratorException;
import org.fmgroup.mediator.plugins.simulator.Simulator;
import org.fmgroup.mediator.plugins.simulator.SimulatorException;

public class Core {
    public static void main (String args[]) throws ProjectException, ValidationException, SimulatorException {
        System.out.println("Mediator Tool Alpha.");
        Project proj = new Project("resources/models/smallcar");
        Program prog = proj.parseFile("drivers/motor.med");

//        System.out.println(prog.toString());
//        Simulator sim = new Simulator(Scheduler.Schedule(prog.systems.get("testbench")));
//        while (true)
//            sim.stepForward();

        try {
            System.out.println(
                    new ArduinoGenerator().generate(
                            Scheduler.Schedule(prog.getSystems().get("testbench"))
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
