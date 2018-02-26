package org.fmgroup.mediator.language.statement;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.generated.MediatorLangParser;
import org.fmgroup.mediator.language.term.Term;
import org.fmgroup.mediator.language.type.Type;

import java.util.Map;

public class ReturnStatement implements Statement {

    private RawElement parent;
    private Term returnedValue;

    public Term getReturnedValue() {
        return returnedValue;
    }

    public ReturnStatement setReturnedValue(Term returnedValue) {
        this.returnedValue = returnedValue;
        returnedValue.setParent(this);
        return this;
    }

    @Override
    public ReturnStatement fromContext(ParserRuleContext context, RawElement parent) throws ValidationException {
        if (!(context instanceof MediatorLangParser.ReturnStatementContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "ReturnStatementContext", context.toString());
        }

        setParent(parent);
        setReturnedValue(Term.parse(((MediatorLangParser.ReturnStatementContext) context).term(), this));

        return this;
    }

    @Override
    public boolean equals(Object obj) {
        return
                this.toString().equals(obj.toString()) &&
                        obj instanceof Statement;
    }

    @Override
    public String toString() {
        return "return " + returnedValue.toString() + ";";
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
    public RawElement copy(RawElement parent) throws ValidationException {
        ReturnStatement nrs = new ReturnStatement();
        nrs.setParent(parent);
        nrs.setReturnedValue(getReturnedValue().copy(nrs));

        return nrs;
    }

    @Override
    public Statement refactor(Map<String, Type> typeRewriteMap, Map<String, Term> termRewriteMap) throws ValidationException {
        setReturnedValue(getReturnedValue().refactor(typeRewriteMap, termRewriteMap));
        return this;
    }
}
