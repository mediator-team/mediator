package org.fmgroup.mediator.language.property.StateFormulae;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.generated.MediatorLangParser;
import org.fmgroup.mediator.language.term.Term;
import org.fmgroup.mediator.language.type.Type;

import java.util.Map;

public class GloballyStateFormulae implements StateFormulae {
    private RawElement parent;
    private StateFormulae formula;

    public StateFormulae getFormula() {
        return formula;
    }

    public GloballyStateFormulae setFormula(StateFormulae formula) {
        this.formula = formula;
        formula.setParent(this);
        return this;
    }

    @Override
    public GloballyStateFormulae fromContext(ParserRuleContext context, RawElement parent) throws ValidationException {
        if (!(context instanceof MediatorLangParser.GloballyStateFormulaeContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "GloballyStateFormulaeContext", context.toString());
        }

        setParent(parent);
        setFormula(
                StateFormulae.parse(
                        ((MediatorLangParser.GloballyStateFormulaeContext) context).stateFormulae(),
                        this
                )
        );

        return this;
    }

    @Override
    public Term refactor(Map<String, Type> typeRewriteMap, Map<String, Term> termRewriteMap) throws ValidationException {
        return null;
    }

    @Override
    public RawElement getParent() {
        return this.parent;
    }

    @Override
    public GloballyStateFormulae setParent(RawElement parent) {
        this.parent = parent;
        return this;
    }

    @Override
    public String toString() {
        return "G " + formula.toString();
    }
}
