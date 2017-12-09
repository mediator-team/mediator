package org.fmgroup.mediator.plugins.commands;

import net.sourceforge.argparse4j.inf.Namespace;
import org.fmgroup.mediator.plugin.command.Command;

import java.io.FileNotFoundException;

public class CommandSelfCheck implements Command{
    @Override
    public String getCommandName() {
        return "selfcheck";
    }

    @Override
    public void run(Namespace args) throws FileNotFoundException {
        // TODO
    }

    @Override
    public boolean isBuiltIn() {
        return true;
    }

    @Override
    public String getName() {
        return "CommandSelfCheck";
    }

    @Override
    public String getVersion() {
        return "0.0.1";
    }

    @Override
    public String getDescription() {
        return "check whether there are files or libraries missing.";
    }
}
