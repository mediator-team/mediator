package org.fmgroup.mediator.language.term;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.generated.MediatorLangParser;
import org.fmgroup.mediator.language.type.Type;

import java.util.Map;

/**
 * Formalization for all the binary terms like
 * - a + b
 * - a - c
 * ...
 */
public class BinaryOperatorTerm implements Term {

    private RawElement parent = null;

    private Term left, right;
    private EnumBinaryOperator opr;

    @Override
    public Type getType() {
        // TODO
        return null;
    }

    @Override
    public int getPrecedence() {
        return opr.oprLevel;
    }

    @Override
    public BinaryOperatorTerm refactor(Map<String, Type> typeRewriteMap, Map<String, Term> termRewriteMap) throws ValidationException {
        setLeft(getLeft().refactor(typeRewriteMap, termRewriteMap));
        setRight(getRight().refactor(typeRewriteMap, termRewriteMap));
        return this;
    }

    @Override
    public BinaryOperatorTerm fromContext(ParserRuleContext context, RawElement parent) throws ValidationException {
        if (!(context instanceof MediatorLangParser.BinaryOprTermContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "BinaryOprTermContext", context.toString());
        }

        setParent(parent);
        setLeft(Term.parse(((MediatorLangParser.BinaryOprTermContext) context).left, this));
        setRight(Term.parse(((MediatorLangParser.BinaryOprTermContext) context).right, this));
        setOpr(EnumBinaryOperator.fromString(((MediatorLangParser.BinaryOprTermContext) context).opr.getText()));

        return this;
    }

    @Override
    public String toString() {
        return
                String.format(
                        right.getPrecedence() < this.getPrecedence() ? "%s %s (%s)" : "%s %s %s",
                        left.toString(), opr.toString(), right.toString()
                );
    }

    @Override
    public RawElement getParent() {
        return parent;
    }

    @Override
    public BinaryOperatorTerm setParent(RawElement parent) {
        this.parent = parent;
        return this;
    }

    @Override
    public BinaryOperatorTerm copy(RawElement parent) throws ValidationException {
        BinaryOperatorTerm nbot = new BinaryOperatorTerm();

        nbot.setParent(parent);
        nbot.setLeft(this.left.copy(nbot));
        nbot.setRight(this.right.copy(nbot));
        nbot.setOpr(this.opr);

        return nbot;
    }

    public EnumBinaryOperator getOpr() {
        return opr;
    }

    public BinaryOperatorTerm setOpr(EnumBinaryOperator opr) {
        this.opr = opr;
        return this;
    }

    public Term getLeft() {
        return left;
    }

    public BinaryOperatorTerm setLeft(Term left) throws ValidationException {
        this.left = left;
        left.setParent(this);
        return this;
    }

    public Term getRight() {
        return right;
    }

    public BinaryOperatorTerm setRight(Term right) throws ValidationException {
        this.right = right;
        right.setParent(this);
        return this;
    }
}
