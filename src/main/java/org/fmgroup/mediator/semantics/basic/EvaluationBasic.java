package org.fmgroup.mediator.semantics.basic;

import org.fmgroup.mediator.language.entity.automaton.Automaton;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.scope.VariableDeclaration;
import org.fmgroup.mediator.language.term.Term;
import org.fmgroup.mediator.language.type.UtilType;

import java.util.HashMap;
import java.util.Map;

public class EvaluationBasic {

    private Map<String, Term> ev = new HashMap<>();

    public static EvaluationBasic getInitEvaluation(Automaton a) throws ValidationException {
        EvaluationBasic eb = new EvaluationBasic();

        for (VariableDeclaration var : a.localVars.vardecls) {
            Term initVal = UtilType.getInitValue(var.type);
            for (String varname : var.identifiers) {
                eb.put(varname, initVal);
            }
        }
        return eb;
    }

    public void put(String key, Term value) {
        ev.put(key, value);
    }

    public Term get(String key) {
        return ev.get(key);
    }

    @Override
    public String toString() {
        String evstr = "";
        for (String key : ev.keySet()) {
            evstr += String.format("%s (%s) ", key, ev.get(key));
        }
        return evstr;
    }
}
