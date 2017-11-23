package org.fmgroup.mediator.language;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.entity.Entity;
import org.fmgroup.mediator.language.entity.automaton.Automaton;
import org.fmgroup.mediator.language.entity.system.System;
import org.fmgroup.mediator.language.function.Function;
import org.fmgroup.mediator.language.scope.DeclarationCollection;
import org.fmgroup.mediator.language.scope.Scope;
import org.fmgroup.mediator.language.scope.TypeDeclaration;
import org.fmgroup.mediator.language.scope.TypeDeclarationCollection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Program implements RawElement, Scope {

    public List<Program> dependencies = new ArrayList<>();
    public TypeDeclarationCollection typedefs = new TypeDeclarationCollection();
    public Map<String, Function> functions = new HashMap<>();
    public Map<String, Automaton> automata = new HashMap<>();
    public Map<String, Automaton> compiledAutomata = new HashMap<>();
    public Map<String, System> systems = new HashMap<>();


    @Override
    public Program fromContext(ParserRuleContext context, RawElement parent) throws ValidationException {
        if (!(context instanceof MediatorLangParser.ProgContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "ProgContext", context.toString());
        }

        MediatorLangParser.ProgContext prog = (MediatorLangParser.ProgContext) context;
        // step 1. load dependencies
        for (MediatorLangParser.DependencyContext dc : prog.dependency()) {
            //
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
}
