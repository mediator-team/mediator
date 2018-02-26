package org.fmgroup.mediator.plugins.commands;

import net.sourceforge.argparse4j.inf.Namespace;
import org.fmgroup.mediator.core.antlr.Parser;
import org.fmgroup.mediator.language.Program;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.entity.system.System;
import org.fmgroup.mediator.language.generated.MediatorLangParser;
import org.fmgroup.mediator.plugin.command.Command;
import org.fmgroup.mediator.plugins.scheduler.Scheduler;

import java.io.IOException;

public class CommandDebug implements Command {
    @Override
    public String getCommandName() {
        return "debug";
    }

    @Override
    public void run(Namespace args) throws IOException {
        MediatorLangParser parser = Parser.getParserFromFile("resources/models/test/newconn.med");
        try {
            Program prog = new Program().fromContext(parser.prog(), null);
            java.lang.System.out.println(prog.toString());

            System t = prog.getSystems().get("t");

            java.lang.System.out.println(Scheduler.Schedule(t).toString());
        } catch (ValidationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getName() {
        return "debug";
    }

    @Override
    public String getVersion() {
        return "0.1";
    }

    @Override
    public String getDescription() {
        return "debug";
    }

    @Override
    public boolean isBuiltIn() {
        return true;
    }
}
