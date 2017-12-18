package org.fmgroup.mediator.language.property;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.generated.MediatorLangParser;
import org.fmgroup.mediator.language.property.PathFormulae.PathFormulae;


public class Property implements RawElement {
    private RawElement parent;
    private PathFormulae formulae;

    @Override
    public RawElement getParent() {
        return this.parent;
    }

    @Override
    public Property setParent(RawElement parent) {
        this.parent = parent;
        return this;
    }

    @Override
    public Property fromContext(ParserRuleContext context, RawElement parent) throws ValidationException {
        if (!(context instanceof MediatorLangParser.PropertyContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "PropertyContext", context.toString());
        }

        formulae = PathFormulae.parse(((MediatorLangParser.PropertyContext) context).pathFormulae(), this);
        return this;
    }

    @Override
    public String toString() {
        return formulae.toString();
    }
}
