package org.fmgroup.mediator.language.statement;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.MediatorLangParser;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.term.Term;

public class ReturnStatement implements Statement {

    private RawElement parent;
    public Term returnedValue;

    @Override
    public RawElement fromContext(ParserRuleContext context) throws ValidationException {
        if (!(context instanceof MediatorLangParser.ReturnStatementContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "ReturnStatementContext", context.toString());
        }

        returnedValue = Term.parse(((MediatorLangParser.ReturnStatementContext) context).term(), this);
        return this.validate();
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
    public RawElement setParent(RawElement parent)  {
        this.parent = parent;
        return this;
    }

    @Override
    public RawElement clone(RawElement parent) throws ValidationException {
        ReturnStatement nrs = new ReturnStatement();
        nrs.setParent(parent);
        nrs.returnedValue = (Term) this.returnedValue.clone(nrs);
        return nrs.validate();
    }

    @Override
    public RawElement validate() throws ValidationException {
        // TODO
        return this;
    }
}
