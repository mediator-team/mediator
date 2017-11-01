package org.fmgroup.mediator.language;

import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Program implements RawElement {

    public List<Program> dependencies = new ArrayList<>();
    public Map<String, Typedef> typedefs = new HashMap<>();
    public Map<String, Function> functions = new HashMap<>();
    public Map<String, Automaton> automata = new HashMap<>();
    public Map<String, Automaton> compiledAutomata = new HashMap<>();
    public Map<String, System> systems = new HashMap<>();


    @Override
    public RawElement fromContext(ParserRuleContext context) throws ValidationException {
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
            Typedef typedef = (Typedef) new Typedef().setParent(this).fromContext(tc);
            typedefs.put(typedef.name, typedef);
        }

        // step 3. analyze functions
        for (MediatorLangParser.FunctionContext fc : prog.function()) {
            Function func = (Function) new Function().setParent(this).fromContext(fc);
            functions.put(func.name, func);
        }
        // step 4. analyze automata
        for (MediatorLangParser.AutomatonContext ac : prog.automaton()) {
            Automaton automaton = (Automaton) new Automaton().setParent(this).fromContext(ac);
            automata.put(automaton.name, automaton);
        }
        // step 5. analyze systems
        for (MediatorLangParser.SystemContext sc : prog.system()) {
            System sys = (System) new System().setParent(this).fromContext(sc);
            systems.put(sys.name, sys);
        }

        return this.validate();
    }

    @Override
    public String toString() {
        String prog = "";

        for (String name : typedefs.keySet()) {
            prog += typedefs.get(name).toString() + "\n";
        }
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
    public RawElement getParent() {
        return null;
    }

    @Override
    public RawElement setParent(RawElement parent)  {
        // TODO this method is not supposed to use
        return this;
    }

    @Override
    public RawElement clone(RawElement parent) {
        return null;
    }

    @Override
    public RawElement validate() throws ValidationException {
        // TODO
        return this;
    }
}
