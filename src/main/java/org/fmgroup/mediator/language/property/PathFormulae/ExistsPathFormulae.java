package org.fmgroup.mediator.language.property.PathFormulae;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.generated.MediatorLangParser;
import org.fmgroup.mediator.language.property.StateFormulae.StateFormulae;
import org.fmgroup.mediator.language.term.Term;
import org.fmgroup.mediator.language.type.Type;

import java.util.Map;

public class ExistsPathFormulae implements PathFormulae {
    private RawElement parent;
    private StateFormulae formula;

    public StateFormulae getFormula() {
        return formula;
    }

    public ExistsPathFormulae setFormula(StateFormulae formula) {
        this.formula = formula;
        formula.setParent(this);
        return this;
    }

    @Override
    public ExistsPathFormulae fromContext(ParserRuleContext context, RawElement parent) throws ValidationException {
        if (!(context instanceof MediatorLangParser.ExistsPathFormulaeContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "ExistsPathFormulaeContext", context.toString());
        }

        setParent(parent);
        setFormula(
                StateFormulae.parse(
                        ((MediatorLangParser.ExistsPathFormulaeContext) context).stateFormulae(),
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
    public RawElement setParent(RawElement parent) {
        this.parent = parent;
        return this;
    }

    @Override
    public String toString() {
        return "E " + formula.toString();
    }
}
