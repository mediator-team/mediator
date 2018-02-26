package org.fmgroup.mediator.plugin.command;

import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.Namespace;
import org.fmgroup.mediator.plugin.Plugin;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Command extends Plugin {
    String getCommandName();

    /**
     * The function returns an argparse4j param parser to parse args.
     *
     * Each command accepts a set of parameters. It is very hard to write a parser for this (and why do we have to?)
     * So I decided to use ArgParse4j to provide params-parsing service in Mediator. Documents of this library can be
     * found in https://argparse4j.github.io/
     *
     * Not all command args are provided to the parser. For example, if you type the following command in terminal,
     *
     *     mediator help -a -b
     *
     * Then only the `-a -b` part will be parsed.
     * @return
     */
    default ArgumentParser getParamsParser() {
        ArgumentParser parser = ArgumentParsers.newFor("command").build()
                .description("you need to override getParamsParser in Command to customize this line.");
        return parser;
    }

    void run (Namespace args) throws IOException;
}
