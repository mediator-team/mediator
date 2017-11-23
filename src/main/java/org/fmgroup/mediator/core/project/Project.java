package org.fmgroup.mediator.core.project;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.fmgroup.mediator.core.antlr.VerboseListener;
import org.fmgroup.mediator.language.MediatorLangLexer;
import org.fmgroup.mediator.language.MediatorLangParser;
import org.fmgroup.mediator.language.Program;
import org.fmgroup.mediator.language.ValidationException;
import org.ini4j.Ini;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Project {
    /**
     * project file that is formatted in INI style
     */
    public Ini configFile = new Ini();
    public File projectFile = null;

    public List<String> builtinPaths = new ArrayList<>();

    /**
     * load a project from given path, the path directs to either a .project file or a folder that contains
     * a .project file
     * @param path
     */
    public Project(String path) {

        if (path.endsWith(".project")) {
            projectFile = new File(path);
        } else {
            projectFile = Paths.get(path, ".project").toFile();
        }

        try {
            configFile.load(new FileReader(projectFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getExternalPaths() {
        String paths = configFile.get("library", "externala");
        if (paths == null) return new ArrayList<>();
        else
            return Arrays.asList(paths.split(":"));
    }

    public String getProjectPath() {
        return projectFile.getParent();
    }

    public List<String> getBuiltinPaths() {
        return builtinPaths;
    }

    public List<String> getPaths() {
        List<String> result = new ArrayList<>(getExternalPaths());
        result.addAll(getBuiltinPaths());
        result.add(getProjectPath());
        return result;
    }

    public Program parseFile(String filename) throws ProjectException {
        File file = null;

        for (String path : getPaths()) {
            if (Files.exists(Paths.get(path, filename))) {
                file = Paths.get(path, filename).toFile();
            }
        }

        if (file == null) {
            throw ProjectException.ProjectNotFound(filename);
        }

        try {
            InputStream is = new FileInputStream(file);
            MediatorLangLexer lexer = new MediatorLangLexer(CharStreams.fromStream(is));
            CommonTokenStream ts = new CommonTokenStream(lexer);
            MediatorLangParser parser = new MediatorLangParser(ts);

            // register exception listener
            parser.removeErrorListeners();
            parser.addErrorListener(new VerboseListener());

            return new Program().fromContext(parser.prog(), null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ValidationException e) {
            e.printStackTrace();
        }

        return null;
    }
}
