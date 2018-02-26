package org.fmgroup.mediator.language.type.termType;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.generated.MediatorLangParser;
import org.fmgroup.mediator.language.term.Term;
import org.fmgroup.mediator.language.type.Type;

import java.util.Map;

public class ListType implements Type {

    private RawElement parent = null;
    private Type baseType;
    private Term capacity = null;

    public Type getBaseType() {
        return baseType;
    }

    public ListType setBaseType(Type baseType) {
        this.baseType = baseType;
        baseType.setParent(this);
        return this;
    }

    public Term getCapacity() {
        return capacity;
    }

    public ListType setCapacity(Term capacity) {
        this.capacity = capacity;
        if (capacity != null)
            capacity.setParent(this);
        return this;
    }

    @Override
    public ListType fromContext(ParserRuleContext context, RawElement parent) throws ValidationException {
        if (!(context instanceof MediatorLangParser.ListTypeContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "ListTypeContext", context.toString());
        }

        setParent(parent);
        setBaseType(Type.parse(((MediatorLangParser.ListTypeContext) context).type(), this));

        if (((MediatorLangParser.ListTypeContext) context).capacity == null) {
            setCapacity(null);
        } else {
            setCapacity(Term.parse(((MediatorLangParser.ListTypeContext) context).capacity, this));
        }

        return this;
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
    public ListType setParent(RawElement parent) {
        this.parent = parent;
        return this;
    }

    @Override
    public ListType copy(RawElement parent) throws ValidationException {
        ListType nlt = new ListType();
        nlt.setParent(parent);
        nlt.setCapacity(getCapacity().copy(nlt));
        nlt.setBaseType(getBaseType().copy(nlt));

        return nlt;
    }

    @Override
    public Type refactor(Map<String, Type> typeRewriteMap, Map<String, Term> termRewriteMap) throws ValidationException {
        setBaseType(getBaseType().refactor(typeRewriteMap, termRewriteMap));
        setCapacity(getCapacity().refactor(typeRewriteMap, termRewriteMap));

        return this;
    }
}
