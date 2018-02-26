package org.fmgroup.mediator.core;

import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;
import org.fmgroup.mediator.common.ToolInfo;
import org.fmgroup.mediator.common.UtilClass;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.plugin.command.Command;
import org.fmgroup.mediator.plugin.Plugin;
import org.fmgroup.mediator.plugins.simulator.SimulatorException;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

public class Core {
    public static void main (String args[]) throws ValidationException, SimulatorException {

        if (args.length == 0) {
            /**
             * if no command is provided, we show the default help to users
             */
            System.out.println("Mediator Backend ver. 0.0.1");
            System.out.print("Loading plugins ... ");
            List<Class<Plugin>> plugins = UtilClass.getPlugins();
            System.out.println("loaded.");

            String str_plugins = "", str_commands = "";
            for (Class plugin: plugins) {
                try {
                    Plugin inst = (Plugin) plugin.newInstance();
                    if (!inst.isBuiltIn()) {
                        str_plugins += String.format(
                                "> %s ver. %s (%s)\n",
                                inst.getName(),
                                inst.getVersion(),
                                inst.getDescription()
                        );
                    }

                    if (inst instanceof Command) {
                        str_commands += String.format(
                                "- %10s (from plugin %s)\n",
                                ((Command) inst).getCommandName(),
                                inst.isBuiltIn() ? "<built-in>" : inst.getName()
                        );
                    }
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("==================== Plugins list ====================\n");
            System.out.println(str_plugins);
            System.out.println("================= Supported Commands =================\n");
            System.out.println(str_commands);

            System.out.println("please use `<mediator> <command> -h` for further details about commands.");
        } else {
            /**
             * if commands are provided, we execute the corresponding command according to the parameters
             * given by users
             *
             * TODO how to formalize the parameters in the plugins?
             */
            List<Class<Command>> commands = UtilClass.getCommands();
            for (Class command : commands) {
                ArgumentParser parser = null;
                try {
                    Command cmdinst = (Command) command.newInstance();
                    if (cmdinst.getCommandName().equals(args[0])) {
                        // command found
                        parser = cmdinst.getParamsParser();

                        // remove the command name in args
                        String [] subArgs = new String[args.length - 1];
                        Arrays.asList(args).subList(1, args.length).toArray(subArgs);

                        // parse args from subargs
                        Namespace parsedArgs = parser.parseArgs(subArgs);
                        cmdinst.run(parsedArgs);
                    }
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (ArgumentParserException e) {
                    parser.handleError(e);
                } catch (java.io.IOException e) {
                    if (ToolInfo.DEBUG) {
                        e.printStackTrace();
                    } else
                        System.err.println(e.getMessage());
                }
            }
        }

    }
}
