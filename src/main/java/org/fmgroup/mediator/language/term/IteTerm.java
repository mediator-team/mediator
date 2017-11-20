package org.fmgroup.mediator.language.term;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.MediatorLangParser;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.type.Type;

public class IteTerm implements Term {

    public RawElement parent = null;
    public Term condition = null;
    public Term thenTerm = null;
    public Term elseTerm = null;

    @Override
    public Type getType() {
        return null;
    }

    @Override
    public int getPrecedence() {
        return 2;
    }

    @Override
    public RawElement fromContext(ParserRuleContext context) throws ValidationException {
        if (!(context instanceof MediatorLangParser.IteTermContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "IteTermContext", context.toString());
        }

        this.condition = Term.parse(((MediatorLangParser.IteTermContext) context).condition, this);
        this.thenTerm = Term.parse(((MediatorLangParser.IteTermContext) context).ifTrue, this);
        this.elseTerm = Term.parse(((MediatorLangParser.IteTermContext) context).ifFalse, this);

        return this.validate();
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
    public RawElement setParent(RawElement parent) {
        this.parent = parent;
        return this;
    }

    @Override
    public RawElement clone(RawElement parent) throws ValidationException {
        return ((IteTerm) new IteTerm().setParent(parent))
                .setCondition(this.condition)
                .setThenTerm(this.thenTerm)
                .setElseTerm(this.elseTerm);
    }

    @Override
    public RawElement validate() throws ValidationException {
        return this;
    }

    public IteTerm setCondition(Term cond) throws ValidationException {
        this.condition = (Term) cond.clone(this);
        return this;
    }

    public IteTerm setThenTerm(Term thenTerm) throws ValidationException {
        this.thenTerm = (Term) thenTerm.clone(this);
        return this;
    }

    public IteTerm setElseTerm(Term elseTerm) throws ValidationException {
        this.elseTerm = (Term) elseTerm.clone(this);
        return this;
    }
}
