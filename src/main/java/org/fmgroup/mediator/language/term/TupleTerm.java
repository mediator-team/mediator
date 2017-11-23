package org.fmgroup.mediator.language.term;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.MediatorLangParser;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.type.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class TupleTerm implements Term {

    private RawElement parent;
    private Term left, right;

    public Term getLeft() {
        return left;
    }

    public TupleTerm setLeft(Term left) {
        this.left = left;
        left.setParent(this);
        return this;
    }

    public Term getRight() {
        return right;
    }

    public TupleTerm setRight(Term right) {
        this.right = right;
        right.setParent(this);
        return this;
    }

    @Override
    public TupleTerm fromContext(ParserRuleContext context, RawElement parent) throws ValidationException {
        if (!(context instanceof MediatorLangParser.TupleTermContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "TupleTermContext", context.toString());
        }

        setParent(parent);
        setLeft(Term.parse(((MediatorLangParser.TupleTermContext) context).left, this));
        setRight(Term.parse(((MediatorLangParser.TupleTermContext) context).right, this));

        return this;
    }

//    todo need to rewrite if it is still used
//    public TupleTerm addTerm(Term t) throws ValidationException {
//        if (left == null) left = t.copy(this);
//        else if (right == null) right = t.copy(this);
//        else {
//            TupleTerm ntt = (TupleTerm) new TupleTerm().setParent(this.parent);
//            ntt.left = this;
//            ntt.right = t.copy(ntt);
//            this.setParent(ntt);
//            return ntt;
//        }
//
//        return this;
//    }

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
    public RawElement setParent(RawElement parent) {
        this.parent = parent;
        return this;
    }

    @Override
    public TupleTerm copy(RawElement parent) throws ValidationException {
        TupleTerm ntt = new TupleTerm();
        ntt.setParent(parent);
        ntt.setLeft(this.left.copy(ntt));
        ntt.setRight(this.right.copy(ntt));

        return ntt;
    }

    @Override
    public Type getType() {
        return null;
    }

    @Override
    public TupleTerm refactor(Map<String, Term> rewriteMap) throws ValidationException {
        setLeft(getLeft().refactor(rewriteMap));
        setRight(getRight().refactor(rewriteMap));
        return this;
    }

    @Override
    public int getPrecedence() {
        return 1;
    }
}
