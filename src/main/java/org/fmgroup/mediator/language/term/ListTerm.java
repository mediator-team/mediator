package org.fmgroup.mediator.language.term;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.MediatorLangParser;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.type.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListTerm implements Term {

    public List<Term> values = new ArrayList<>();
    public RawElement parent = null;

    @Override
    public Type getType() {
        return null;
    }

    @Override
    public int getPrecedence() {
        return 13;
    }

    @Override
    public RawElement fromContext(ParserRuleContext context) throws ValidationException {
        if (!(context instanceof MediatorLangParser.ListTermContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "ListTermContext", context.toString());
        }

        Term t = Term.parse(((MediatorLangParser.ListTermContext) context).term(), this);
        while (t instanceof TupleTerm) {
            values.add(0, ((TupleTerm) t).right);
            t = ((TupleTerm) t).left;
        }
        values.add(0, t);

        return this.validate();
    }

    @Override
    public String toString() {
        return
                "[" +
                this.values.stream().map(Object::toString).collect(Collectors.joining(", "))
                + "]";
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
        ListTerm nlt = (ListTerm) new ListTerm().setParent(parent);
        nlt.values = new ArrayList<>(this.values);
        return nlt.validate();
    }

    @Override
    public RawElement validate() throws ValidationException {
        return this;
    }
}
