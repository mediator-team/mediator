package org.fmgroup.mediator.plugins.commands;

import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.MutuallyExclusiveGroup;
import net.sourceforge.argparse4j.inf.Namespace;
import org.fmgroup.mediator.common.UtilClass;
import org.fmgroup.mediator.language.Program;
import org.fmgroup.mediator.plugin.Generator;
import org.fmgroup.mediator.plugin.command.Command;
import org.fmgroup.mediator.plugins.generators.arduino.ArduinoGeneratorException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


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
    public ArgumentParser getParamsParser() {
        ArgumentParser parser = ArgumentParsers.newFor("generate").build()
                .description("generate Mediator entities into platform-dependent codes.");

        List<Class<Generator>> generators = UtilClass.getGenerators();
        List<String> supportedTargetPlatforms = generators.stream().map(
                generatorClass -> {
                    try {
                        return generatorClass.newInstance().getSupportedPlatform();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    return null;
                }
        ).collect(Collectors.toList());

        parser.addArgument("FILE")
                .type(File.class)
                .required(true)
                .help("file that contains the entity you want to generate");

        parser.addArgument("-e", "--entity")
                .type(String.class)
                .required(true)
                .help("name of the entity (i.e. systems, automata) that you want to generate");

        MutuallyExclusiveGroup dependency = parser.addMutuallyExclusiveGroup();
        dependency.addArgument("-I", "--include")
                .type(File.class)
                .required(false)
                .nargs("+")
                .help("paths where Mediator will load external libraries");
        dependency.addArgument("-p", "--project")
                .type(File.class)
                .required(false)
                .help("project file where this model belongs");

        parser.addArgument("-t", "--target-platform")
                .type(String.class)
                .choices(supportedTargetPlatforms)
                .required(true)
                .help("target platform where you want to build the generate codes");

        parser.addArgument("-o", "--output-dir")
                .type(File.class)
                .required(false)
                .help("directory to store the generate codes and runtime libraries");


        return parser;
    }

    @Override
    public void run(Namespace args) throws FileNotFoundException {
        File medSource = args.get("FILE");
        if (!medSource.exists()) {
            System.err.println(String.format("file %s not exists", medSource.getPath()));
        }

        Program prog = Program.parseFile(medSource.getPath());
        List<Class<Generator>> generators = UtilClass.getGenerators();
        String entityName = args.get("entity");

        for (Class generator : generators) {
            try {
                Generator g = (Generator) generator.newInstance();
                if (g.getSupportedPlatform().equals(args.get("target_platform"))) {
                    System.out.println(g.generate(prog.getEntity(null, entityName)));
                    break;
                }
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ArduinoGeneratorException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean isBuiltIn() {
        return true;
    }
}
