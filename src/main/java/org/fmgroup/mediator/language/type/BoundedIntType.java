package org.fmgroup.mediator.language.type;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.MediatorLangParser;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.term.Term;

public class BoundedIntType implements Type {

    private RawElement parent = null;
    public Term lowerBound, upperBound;

    @Override
    public String getName() {
        return "bounded int";
    }

    @Override
    public RawElement fromContext(ParserRuleContext context) throws ValidationException {
        if (!(context instanceof MediatorLangParser.BoundedIntTypeContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "BoundedIntTypeContext", context.toString());
        }

        lowerBound = Term.parse(((MediatorLangParser.BoundedIntTypeContext) context).lbound, this);
        upperBound = Term.parse(((MediatorLangParser.BoundedIntTypeContext) context).ubound, this);
        return this.validate();
    }

    @Override
    public String toString() {
        return String.format("int %s .. %s", lowerBound.toString(), upperBound.toString());
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
        BoundedIntType nbit = new BoundedIntType();
        nbit.setParent(nbit);
        nbit.lowerBound = (Term) this.lowerBound.clone(nbit);
        nbit.upperBound = (Term) this.upperBound.clone(nbit);

        return nbit.validate();
    }

    @Override
    public RawElement validate() throws ValidationException {
        // TODO
        return this;
    }

}
