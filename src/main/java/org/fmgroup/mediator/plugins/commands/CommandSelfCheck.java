package org.fmgroup.mediator.plugins.commands;

import net.sourceforge.argparse4j.inf.Namespace;
import org.fmgroup.mediator.common.ToolInfo;
import org.fmgroup.mediator.common.UtilClass;
import org.fmgroup.mediator.plugin.generator.Generator;
import org.fmgroup.mediator.plugin.Plugin;
import org.fmgroup.mediator.plugin.command.Command;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;

public class CommandSelfCheck implements Command{
    @Override
    public String getCommandName() {
        return "selfcheck";
    }

    @Override
    public void run(Namespace args) throws FileNotFoundException {
        int counter = 0;

        for (Class plugin: UtilClass.getPlugins()) {
            try {
                Plugin p = (Plugin) plugin.newInstance();
                if (p instanceof Generator) {
                    for (String libraryname : p.requiredLibraries()) {
                        File libfolder = Paths.get(
                                ToolInfo.getSystemLibraryPath(),
                                libraryname
                        ).toFile();

                        if (!libfolder.exists()) {
                            System.err.println(String.format("Library not found: %s", libraryname));
                            counter ++;
                        }
                    }
                }
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        if (counter == 0) {
            System.out.println("Congratulation! Self-checing has succeeded.");
        } else {
            System.err.println(
                    String.format("Oops, %d errors found in self-checking.", counter)
            );
        }
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
