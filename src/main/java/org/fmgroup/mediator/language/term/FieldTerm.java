package org.fmgroup.mediator.language.term;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.MediatorLangParser;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.type.Type;

public class FieldTerm implements Term {

    private RawElement parent;

    public Term owner;
    public String field;

    @Override
    public RawElement fromContext(ParserRuleContext context) throws ValidationException {
        if (!(context instanceof MediatorLangParser.FieldTermContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "FieldTermContext", context.toString());
        }

        this.owner = Term.parse(((MediatorLangParser.FieldTermContext) context).structure, this);
        this.field = ((MediatorLangParser.FieldTermContext) context).key.getText();
        return this.validate();
    }

    @Override
    public String toString() {
        return String.format(
                owner.getPrecedence() < this.getPrecedence() ? "(%s).%s" : "%s.%s",
                owner.toString(),
                field
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
        FieldTerm nft = new FieldTerm();
        nft.setParent(parent);
        nft.field = this.field;
        nft.owner = (Term) this.owner.clone(nft);

        return nft.validate();
    }

    @Override
    public Type getType() {
        return null;
    }

    @Override
    public int getPrecedence() {
        return 12;
    }

    @Override
    public RawElement validate() throws ValidationException {
        // TODO
        return this;
    }
}
