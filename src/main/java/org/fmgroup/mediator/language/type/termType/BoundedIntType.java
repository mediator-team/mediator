package org.fmgroup.mediator.language.type.termType;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.generated.MediatorLangParser;
import org.fmgroup.mediator.language.term.Term;
import org.fmgroup.mediator.language.type.Type;

import java.util.Map;

public class BoundedIntType implements Type {

    private RawElement parent = null;
    private Term lowerBound;
    private Term upperBound;

    public Term getLowerBound() {
        return lowerBound;
    }

    public BoundedIntType setLowerBound(Term lowerBound) {
        this.lowerBound = lowerBound;
        lowerBound.setParent(this);
        return this;
    }

    public Term getUpperBound() {
        return upperBound;
    }

    public BoundedIntType setUpperBound(Term upperBound) {
        this.upperBound = upperBound;
        upperBound.setParent(this);
        return this;
    }

    @Override
    public BoundedIntType fromContext(ParserRuleContext context, RawElement parent) throws ValidationException {
        if (!(context instanceof MediatorLangParser.BoundedIntTypeContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "BoundedIntTypeContext", context.toString());
        }

        setParent(parent);
        setLowerBound(Term.parse(((MediatorLangParser.BoundedIntTypeContext) context).lbound, this));
        setUpperBound(Term.parse(((MediatorLangParser.BoundedIntTypeContext) context).ubound, this));

        return this;
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
    public BoundedIntType setParent(RawElement parent) {
        this.parent = parent;
        return this;
    }

    @Override
    public BoundedIntType copy(RawElement parent) throws ValidationException {
        BoundedIntType nbit = new BoundedIntType();

        nbit.setParent(parent);
        nbit.setLowerBound(getLowerBound().copy(nbit));
        nbit.setUpperBound(getUpperBound().copy(nbit));

        return nbit;
    }

    @Override
    public BoundedIntType refactor(Map<String, Type> typeRewriteMap, Map<String, Term> termRewriteMap) throws ValidationException {
        setLowerBound(getLowerBound().refactor(typeRewriteMap, termRewriteMap));
        setUpperBound(getUpperBound().refactor(typeRewriteMap, termRewriteMap));

        return this;
    }
}
