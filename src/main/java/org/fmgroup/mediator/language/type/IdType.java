package org.fmgroup.mediator.language.type;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.MediatorLangParser;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.term.IdValue;

public class IdType implements Type {

    private RawElement parent = null;
    public String identifier;

    @Override
    public String getName() {
        return "id";
    }

    @Override
    public RawElement fromContext(ParserRuleContext context) throws ValidationException {
        if (!(context instanceof MediatorLangParser.IdTypeContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "IdTypeContext", context.toString());
        }

        this.identifier = context.getText();
        return this.validate();
    }

    @Override
    public String toString() {
        return identifier;
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
        return new IdType().setIdentifier(this.identifier).setParent(parent).validate();
    }

    public IdType setIdentifier(String identifier) {
        this.identifier = identifier;
        return this;
    }

    @Override
    public RawElement validate() throws ValidationException {
        // TODO
        return this;
    }
}
