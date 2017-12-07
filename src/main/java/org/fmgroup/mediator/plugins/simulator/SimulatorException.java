package org.fmgroup.mediator.plugins.simulator;

public class SimulatorException extends Exception{

    public SimulatorException(String msg) {
        super(msg);
    }

    public static SimulatorException UnderDevelopment() {
        return new SimulatorException("the feature is still not implemented yet.");
    }
}
