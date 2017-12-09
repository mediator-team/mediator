package org.fmgroup.mediator.language;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.fmgroup.mediator.common.ToolInfo;
import org.fmgroup.mediator.core.antlr.VerboseListener;
import org.fmgroup.mediator.language.entity.Entity;
import org.fmgroup.mediator.language.entity.automaton.Automaton;
import org.fmgroup.mediator.language.entity.system.System;
import org.fmgroup.mediator.language.function.Function;
import org.fmgroup.mediator.language.generated.MediatorLangLexer;
import org.fmgroup.mediator.language.generated.MediatorLangParser;
import org.fmgroup.mediator.language.scope.DeclarationCollection;
import org.fmgroup.mediator.language.scope.Scope;
import org.fmgroup.mediator.language.scope.TypeDeclaration;
import org.fmgroup.mediator.language.scope.TypeDeclarationCollection;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Program implements RawElement, Scope {

    private List<Program> dependencies = new ArrayList<>();
    private TypeDeclarationCollection typedefs = new TypeDeclarationCollection();
    private Map<String, Function> functions = new HashMap<>();
    private Map<String, Automaton> automata = new HashMap<>();
    private Map<String, Automaton> compiledAutomata = new HashMap<>();
    private Map<String, System> systems = new HashMap<>();

    public List<String> getExternalPaths() {
        return externalPaths;
    }

    public Program setExternalPaths(List<String> externalPaths) {
        this.externalPaths = new ArrayList<>(externalPaths);
        return this;
    }

    private List<String> externalPaths = null;

    public List<Program> getDependencies() {
        return dependencies;
    }

    public TypeDeclarationCollection getTypedefs() {
        return typedefs;
    }

    public Map<String, Function> getFunctions() {
        return functions;
    }

    public Program addFunction(String name, Function f) throws ValidationException {
        if (functions.containsKey(name)) {
            throw ValidationException.DumplicatedIdentifier(name, "function");
        }

        functions.put(name, f);
        return this;
    }

    public Map<String, Automaton> getAutomata() {
        return automata;
    }

    public Program addAutomaton(String name, Automaton a) throws ValidationException {
        if (automata.containsKey(name)) {
            throw ValidationException.DumplicatedIdentifier(name, "automaton");
        }

        automata.put(name, a);
        return this;
    }

    public Map<String, Automaton> getCompiledAutomata() {
        return compiledAutomata;
    }

    public Map<String, System> getSystems() {
        return systems;
    }

    public Program addSystem (String name, System s) throws ValidationException {
        if (systems.containsKey(name)) {
            throw ValidationException.DumplicatedIdentifier(name, "system");
        }

        systems.put(name, s);
        return this;
    }

    @Override
    public Program fromContext(ParserRuleContext context, RawElement parent) throws ValidationException {
        if (!(context instanceof MediatorLangParser.ProgContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "ProgContext", context.toString());
        }

        MediatorLangParser.ProgContext prog = (MediatorLangParser.ProgContext) context;
        // step 1. load dependencies
        for (MediatorLangParser.DependencyContext dc : prog.dependency()) {
            if (dc.importedlib != null) {
                String libpath = dc.importedlib.scopes.stream().map(
                        token -> token.getText() + "/"
                ).collect(Collectors.joining("")) + dc.importedlib.identifier.getText();

                // todo
            } else {
                String libpath = dc.fromlib.scopes.stream().map(
                        token -> token.getText() + "/"
                ).collect(Collectors.joining("")) + dc.fromlib.identifier.getText() + ".med";

                List<String> idTsoImport = dc.ID().stream().map(ParseTree::getText).collect(Collectors.toList());

                Program lib = null;
                try {
                    lib = Program.parseFile(libpath);
                } catch (FileNotFoundException e) {
                    throw ValidationException.UnknownIdentifier(libpath, "library");
                }
                for (TypeDeclaration typedef : lib.getTypedefs().getDeclarationList()) {
                    boolean flag = false;
                    for (String name: typedef.getIdentifiers()) {
                        if (idTsoImport.contains(name)) {
                            flag = true;
                            break;
                        }
                    }

                    if (flag || dc.importAll) this.getTypedefs().addDeclaration(typedef);
                }

                for (String funcname : lib.getFunctions().keySet()) {
                    if (idTsoImport.contains(funcname) || dc.importAll)
                        this.addFunction(funcname, lib.getFunctions().get(funcname));
                }

                for (String name : lib.getAutomata().keySet()) {
                    if (idTsoImport.contains(name) || dc.importAll)
                        this.addAutomaton(name, lib.getAutomata().get(name));
                }

                for (String name : lib.getSystems().keySet()) {
                    if (idTsoImport.contains(name) || dc.importAll)
                        this.addSystem(name, lib.getSystems().get(name));
                }
            }
        }

        // step 2. analyze typedefs
        for (MediatorLangParser.TypedefContext tc : prog.typedef()) {
            typedefs.addDeclaration(new TypeDeclaration().fromContext(tc, this));
        }

        // step 3. analyze functions
        for (MediatorLangParser.FunctionContext fc : prog.function()) {
            Function func = new Function().setParent(this).fromContext(fc, this);
            functions.put(func.getName(), func);
        }

        // step 4. analyze automata
        for (MediatorLangParser.AutomatonContext ac : prog.automaton()) {
            Automaton automaton = new Automaton().fromContext(ac, this);
            automata.put(automaton.getName(), automaton);
        }
        // step 5. analyze systems
        for (MediatorLangParser.SystemContext sc : prog.system()) {
            System sys = new System().fromContext(sc, this);
            systems.put(sys.getName(), sys);
        }

        return this;
    }

    @Override
    public RawElement getParent() {
        return null;
    }

    @Override
    public RawElement setParent(RawElement parent) {
        return null;
    }

    @Override
    public String toString() {
        String prog = "";

        prog += typedefs.toString();

        prog += "\n";

        for (String name : functions.keySet()) {
            prog += functions.get(name).toString() + "\n";
        }
        prog += "\n";

        for (String name : automata.keySet()) {
            prog += automata.get(name).toString() + "\n";
        }
        prog += "\n";

        for (String name : systems.keySet()) {
            prog += systems.get(name).toString() + "\n";
        }

        return prog;
    }

    @Override
    public List<DeclarationCollection> getDeclarations() {
        List<DeclarationCollection> result = new ArrayList<>();
        result.add(typedefs);
        return result;
    }

    public Function getFunction(List<String> libraryPath, String identifier) {
        if (libraryPath == null || libraryPath.size() == 0) {
            if (functions.containsKey(identifier)) return functions.get(identifier);
        } else {
            return null;
        }
        return null;
    }

    public Entity getEntity(List<String> libraryPath, String identifier) {
        if (libraryPath == null || libraryPath.size() == 0) {
            if (automata.containsKey(identifier)) return automata.get(identifier);
            if (systems.containsKey(identifier)) return systems.get(identifier);
        } else {
            return null;
        }
        return null;
    }

    public static Program parseFile(String filename) throws FileNotFoundException {
        return Program.parseFile(filename, new ArrayList<>());
    }

    public static Program parseFile(String filename, List<String> externalPaths) throws FileNotFoundException {
        File file = null;
        List<String> paths = new ArrayList<>();

        // obtain paths, both internal and external
        paths.addAll(externalPaths);
        paths.add(ToolInfo.getSystemLibraryPath());
        paths.add(java.lang.System.getProperty("user.dir").toString());

        for (String path : paths) {
            if (Files.exists(Paths.get(path, filename))) {
                file = Paths.get(path, filename).toFile();
            }
        }

        if (file == null) {
            throw new FileNotFoundException(String.format(
                    "cannot locate %s in all paths",
                    filename
            ));
        }

        try {
            InputStream is = new FileInputStream(file);
            MediatorLangLexer lexer = new MediatorLangLexer(CharStreams.fromStream(is));
            CommonTokenStream ts = new CommonTokenStream(lexer);
            MediatorLangParser parser = new MediatorLangParser(ts);

            // register exception listener
            parser.removeErrorListeners();
            VerboseListener listener = new VerboseListener();
            parser.addErrorListener(listener);

            MediatorLangParser.ProgContext prog = parser.prog();
            if (!listener.Succeed()) {
                for (ValidationException ex: listener.getExceptions()) {
                    java.lang.System.err.println(ex.toString());
                }
                return null;
            }
            return new Program().setExternalPaths(externalPaths).fromContext(prog, null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ValidationException e) {
            java.lang.System.err.println(e.toString());
            if (ToolInfo.DEBUG) e.printStackTrace();
        }

        return null;
    }
}
