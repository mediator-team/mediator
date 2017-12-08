package org.fmgroup.mediator.plugins.commands;

import org.fmgroup.mediator.plugin.command.Command;

import java.util.List;

public class CommandHelp implements Command {
    @Override
    public String getName() {
        return "CommandHelp";
    }

    @Override
    public String getVersion() {
        return "0.0.1";
    }

    @Override
    public String getDescription() {
        return "generate help docs based on existing plugins";
    }

    @Override
    public String getCommandName() {
        return "help";
    }

    @Override
    public boolean isBuiltIn() {
        return true;
    }

    @Override
    public void run(List<String> args) {
        // todo
    }
}
