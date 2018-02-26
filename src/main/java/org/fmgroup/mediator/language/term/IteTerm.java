package org.fmgroup.mediator.language.term;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.generated.MediatorLangParser;
import org.fmgroup.mediator.language.type.Type;

import java.util.Map;

public class IteTerm implements Term {

    private RawElement parent = null;
    private Term condition = null;
    private Term thenTerm = null;
    private Term elseTerm = null;

    public Term getCondition() {
        return condition;
    }

    public IteTerm setCondition(Term cond) throws ValidationException {
        this.condition = cond;
        cond.setParent(this);
        return this;
    }

    public Term getThenTerm() {
        return thenTerm;
    }

    public IteTerm setThenTerm(Term thenTerm) throws ValidationException {
        this.thenTerm = thenTerm;
        thenTerm.setParent(this);
        return this;
    }

    public Term getElseTerm() {
        return elseTerm;
    }

    public IteTerm setElseTerm(Term elseTerm) throws ValidationException {
        this.elseTerm = elseTerm;
        elseTerm.setParent(this);
        return this;
    }

    @Override
    public Type getType() {
        return null;
    }

    @Override
    public int getPrecedence() {
        return 2;
    }

    @Override
    public IteTerm fromContext(ParserRuleContext context, RawElement parent) throws ValidationException {
        if (!(context instanceof MediatorLangParser.IteTermContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "IteTermContext", context.toString());
        }

        setParent(parent);
        setCondition(Term.parse(((MediatorLangParser.IteTermContext) context).condition, this));
        setCondition(Term.parse(((MediatorLangParser.IteTermContext) context).ifTrue, this));
        setElseTerm(Term.parse(((MediatorLangParser.IteTermContext) context).ifFalse, this));

        return this;
    }

    @Override
    public String toString() {
        return
                String.format(
                        ((condition.getPrecedence() < this.getPrecedence()) ? "(%s)" : "%s") +
                                " ? %s : " +
                                ((elseTerm.getPrecedence() < this.getPrecedence()) ? "(%s)" : "%s"),
                        condition.toString(),
                        thenTerm.toString(),
                        elseTerm.toString()
                );
    }

    @Override
    public RawElement getParent() {
        return this.parent;
    }

    @Override
    public IteTerm setParent(RawElement parent) {
        this.parent = parent;
        return this;
    }

    @Override
    public IteTerm copy(RawElement parent) throws ValidationException {
        return new IteTerm().setParent(parent)
                .setCondition(this.condition)
                .setThenTerm(this.thenTerm)
                .setElseTerm(this.elseTerm);
    }

    @Override
    public Term refactor(Map<String, Type> typeRewriteMap, Map<String, Term> termRewriteMap) throws ValidationException {
        setCondition(getCondition().refactor(typeRewriteMap, termRewriteMap));
        setThenTerm(getThenTerm().refactor(typeRewriteMap, termRewriteMap));
        setElseTerm(getElseTerm().refactor(typeRewriteMap, termRewriteMap));

        return this;
    }
}
