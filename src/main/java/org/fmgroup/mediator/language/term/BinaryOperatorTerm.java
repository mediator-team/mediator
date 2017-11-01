package org.fmgroup.mediator.language.term;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.MediatorLangParser;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.type.BoolType;
import org.fmgroup.mediator.language.type.Type;

public class BinaryOperatorTerm implements Term {

    private RawElement parent = null;

    public Term left, right;
    public EnumBinaryOperator opr;

    @Override
    public Type getType() {
        return null;
    }

    @Override
    public int getPrecedence() {
        return opr.oprLevel;
    }

    @Override
    public RawElement fromContext(ParserRuleContext context) throws ValidationException {
        if (!(context instanceof MediatorLangParser.BinaryOprTermContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "BinaryOprTermContext", context.toString());
        }

        left = UtilTerm.parse(((MediatorLangParser.BinaryOprTermContext) context).left, this);
        right = UtilTerm.parse(((MediatorLangParser.BinaryOprTermContext) context).right, this);
        opr = EnumBinaryOperator.fromString(((MediatorLangParser.BinaryOprTermContext) context).opr.getText());

        return this.validate();
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
    public RawElement setParent(RawElement parent) {
        this.parent = parent;
        return this;
    }

    @Override
    public RawElement clone(RawElement parent) throws ValidationException {
        BinaryOperatorTerm nbot = new BinaryOperatorTerm();
        nbot.setParent(parent);
        nbot.left = (Term) this.left.clone(nbot);
        nbot.right = (Term) this.right.clone(nbot);
        nbot.opr = this.opr;

        return nbot.validate();
    }

    @Override
    public RawElement validate() throws ValidationException {
        // TODO
        return this;
    }

    public BinaryOperatorTerm setOpr(EnumBinaryOperator opr) {
        this.opr = opr;
        return this;
    }

    public BinaryOperatorTerm setLeft(Term left) throws ValidationException {
        this.left = (Term) left.clone(this);
        return this;
    }

    public BinaryOperatorTerm setRight(Term right) throws ValidationException {
        this.right = (Term) right.clone(this);
        return this;
    }
}
