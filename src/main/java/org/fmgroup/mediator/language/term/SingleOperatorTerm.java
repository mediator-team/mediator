package org.fmgroup.mediator.language.term;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.MediatorLangParser;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.type.Type;

public class SingleOperatorTerm implements Term {

    private RawElement parent;

    public SingleOperatorTerm setOpr(EnumSingleOperator opr) {
        this.opr = opr;
        return this;
    }

    public EnumSingleOperator opr;

    public SingleOperatorTerm setTerm(Term term) throws ValidationException {
        this.term = (Term) term.clone(this);
        return this;
    }

    public Term term;

    @Override
    public RawElement fromContext(ParserRuleContext context) throws ValidationException {
        if (!(context instanceof MediatorLangParser.SingleOprTermContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "SingleOprContext", context.toString());
        }

        this.opr = EnumSingleOperator.fromString(((MediatorLangParser.SingleOprTermContext) context).opr.getText());
        this.term = UtilTerm.parse(((MediatorLangParser.SingleOprTermContext) context).term(), this);

        return this.validate();
    }

    @Override
    public String toString() {
        return String.format(
                term.getPrecedence() < this.getPrecedence() ? "%s(%s)" : "%s%s",
                opr.toString(),
                term.toString()
        );
    }

    @Override
    public RawElement getParent() {
        return parent;
    }

    @Override
    public RawElement setParent(RawElement parent)  {
        this.parent = parent;
        return this;
    }

    @Override
    public RawElement clone(RawElement parent) throws ValidationException {
        SingleOperatorTerm nsot = new SingleOperatorTerm();
        nsot.setParent(parent);
        nsot.opr = this.opr;
        nsot.term = (Term) this.term.clone(nsot);

        return nsot.validate();
    }

    @Override
    public Type getType() {
        return null;
    }

    @Override
    public int getPrecedence() {
        return opr.oprLevel;
    }

    @Override
    public RawElement validate() throws ValidationException {
        // TODO
        return this;
    }
}
