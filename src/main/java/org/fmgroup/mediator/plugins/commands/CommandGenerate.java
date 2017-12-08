package org.fmgroup.mediator.plugins.commands;

import net.sourceforge.argparse4j.inf.ArgumentParser;
import org.fmgroup.mediator.plugin.command.Command;

import java.util.List;

public class CommandGenerate implements Command {
    @Override
    public String getName() {
        return "CommandGenerate";
    }

    @Override
    public String getVersion() {
        return "0.0.1";
    }

    @Override
    public String getDescription() {
        return "generating codes for different target platforms";
    }

    @Override
    public String getCommandName() {
        return "generate";
    }

    @Override
    public boolean isBuiltIn() {
        return true;
    }

    @Override
    public void run(List<String> args) {
        System.out.println("what the fuck!");
    }
}
