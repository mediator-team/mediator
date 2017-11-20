package org.fmgroup.mediator.language.type;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.MediatorLangParser;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.term.Term;

public class ListType implements Type {

    private RawElement parent = null;

    public Type baseType;
    public Term capacity = null;

    @Override
    public String getName() {
        return "list";
    }

    @Override
    public RawElement fromContext(ParserRuleContext context) throws ValidationException {
        if (!(context instanceof MediatorLangParser.ListTypeContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "ListTypeContext", context.toString());
        }

        baseType = Type.parse(((MediatorLangParser.ListTypeContext) context).type(), this);
        if (((MediatorLangParser.ListTypeContext) context).capacity == null) {
            this.capacity = null;
        } else {
            this.capacity = Term.parse(((MediatorLangParser.ListTypeContext) context).capacity, this);
        }

        return this.validate();
    }

    @Override
    public String toString() {
        return baseType.toString() + " [" + (capacity == null ? "" : capacity.toString()) + "]";
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
        ListType nlt = new ListType();
        nlt.setParent(parent);
        nlt.capacity = (Term) this.capacity.clone(nlt);
        nlt.baseType = (Type) this.baseType.clone(nlt);

        return nlt;
    }

    @Override
    public RawElement validate() throws ValidationException {
        // TODO
        return this;
    }
}
