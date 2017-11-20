package org.fmgroup.mediator.language.term;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.MediatorLangParser;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.type.Type;

import java.util.ArrayList;
import java.util.List;


public class TupleTerm implements Term {

    private RawElement parent;

    public Term left, right;

    @Override
    public RawElement fromContext(ParserRuleContext context) throws ValidationException {
        if (!(context instanceof MediatorLangParser.TupleTermContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "TupleTermContext", context.toString());
        }

        left = Term.parse(((MediatorLangParser.TupleTermContext) context).left, this);
        right = Term.parse(((MediatorLangParser.TupleTermContext) context).right, this);

        return this.validate();
    }

    public TupleTerm addTerm(Term t) throws ValidationException {
        if (left == null) left = (Term) t.clone(this);
        else if (right == null) right = (Term) t.clone(this);
        else {
            TupleTerm ntt = (TupleTerm) new TupleTerm().setParent(this.parent);
            ntt.left = this;
            ntt.right = (Term) t.clone(ntt);
            this.setParent(ntt);
            return ntt;
        }

        return this;
    }

    public List<Term> getTerms() {
        List<Term> lst;

        if (this.left instanceof TupleTerm) {
            lst = ((TupleTerm) this.left).getTerms();
        } else {
            lst = new ArrayList<>();
            lst.add(this.left);
        }

        lst.add(this.right);
        return lst;
    }

    @Override
    public String toString() {
        return String.format(
                "%s, %s",
                left.toString(),
                right.toString()
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
        TupleTerm ntt = new TupleTerm();
        ntt.setParent(parent);
        ntt.left = (Term) this.left.clone(ntt);
        ntt.right = (Term) this.right.clone(ntt);

        return ntt.validate();
    }

    @Override
    public Type getType() {
        return null;
    }

    @Override
    public int getPrecedence() {
        return 1;
    }

    @Override
    public RawElement validate() throws ValidationException {
        // TODO
        return this;
    }
}
