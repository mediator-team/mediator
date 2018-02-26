package org.fmgroup.mediator.language.term;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.generated.MediatorLangParser;
import org.fmgroup.mediator.language.type.Type;

import java.util.Map;

public class SingleOperatorTerm implements Term {

    private RawElement parent;
    private EnumSingleOperator opr;
    private Term term;

    public EnumSingleOperator getOpr() {
        return opr;
    }

    public SingleOperatorTerm setOpr(EnumSingleOperator opr) {
        this.opr = opr;
        return this;
    }

    public Term getTerm() {
        return term;
    }

    public SingleOperatorTerm setTerm(Term term) throws ValidationException {
        this.term = term;
        term.setParent(this);
        return this;
    }

    @Override
    public SingleOperatorTerm fromContext(ParserRuleContext context, RawElement parent) throws ValidationException {
        if (!(context instanceof MediatorLangParser.SingleOprTermContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "SingleOprContext", context.toString());
        }

        setParent(parent);
        setOpr(EnumSingleOperator.fromString(
                ((MediatorLangParser.SingleOprTermContext) context).opr.getText()
        ));
        setTerm(Term.parse(((MediatorLangParser.SingleOprTermContext) context).term(), this));

        return this;
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
    public RawElement setParent(RawElement parent) {
        this.parent = parent;
        return this;
    }

    @Override
    public SingleOperatorTerm copy(RawElement parent) throws ValidationException {

        SingleOperatorTerm nsot = new SingleOperatorTerm();
        nsot.setParent(parent);
        nsot.setOpr(opr);
        nsot.setTerm(getTerm().copy(nsot));

        return nsot;
    }

    @Override
    public Term refactor(Map<String, Type> typeRewriteMap, Map<String, Term> termRewriteMap) throws ValidationException {
        setTerm(getTerm().refactor(typeRewriteMap, termRewriteMap));
        return this;
    }

    @Override
    public Type getType() {
        return null;
    }

    @Override
    public int getPrecedence() {
        return opr.oprLevel;
    }
}
