package org.fmgroup.mediator.language.property.PathFormulae;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.generated.MediatorLangParser;
import org.fmgroup.mediator.language.term.Term;
import org.fmgroup.mediator.language.type.Type;

import java.util.Map;

public class AtomicPathFormulae implements PathFormulae{
    private RawElement parent;
    private Term term;

    public Term getTerm() {
        return term;
    }

    public AtomicPathFormulae setTerm(Term term) {
        this.term = term;
        term.setParent(this);
        return this;
    }

    @Override
    public AtomicPathFormulae fromContext(ParserRuleContext context, RawElement parent) throws ValidationException {
        if (!(context instanceof MediatorLangParser.AtomicPathFormulaeContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "AtomicPathFormulaeContext", context.toString());
        }

        setParent(parent);
        setTerm(Term.parse(((MediatorLangParser.AtomicPathFormulaeContext) context).term(), this));

        return this;
    }

    @Override
    public Term refactor(Map<String, Type> typeRewriteMap, Map<String, Term> termRewriteMap) throws ValidationException {
        return null;
    }

    @Override
    public int getPrecedence() {
        return term.getPrecedence();
    }

    @Override
    public RawElement getParent() {
        return this.parent;
    }

    @Override
    public AtomicPathFormulae setParent(RawElement parent) {
        this.parent = parent;
        return this;
    }

    @Override
    public String toString() {
        return term.toString();
    }
}
