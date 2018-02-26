package org.fmgroup.mediator.language.type.termType;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.generated.MediatorLangParser;
import org.fmgroup.mediator.language.term.Term;
import org.fmgroup.mediator.language.type.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TupleType implements Type {

    private RawElement parent = null;

    public List<Type> getBaseTypes() {
        return baseTypes;
    }

    public TupleType setBaseTypes(List<Type> baseTypes) {
        this.baseTypes = baseTypes;
        return this;
    }

    public TupleType addBaseType(Type baseType) {
        baseTypes.add(baseType);
        baseType.setParent(this);

        return this;
    }

    private List<Type> baseTypes = new ArrayList<>();

    @Override
    public Type refactor(Map<String, Type> typeRewriteMap, Map<String, Term> termRewriteMap) throws ValidationException {
        for (int i = 0; i < baseTypes.size(); i ++) {
            baseTypes.set(i, baseTypes.get(i).refactor(typeRewriteMap, termRewriteMap));
        }
        return this;
    }

    @Override
    public TupleType fromContext(ParserRuleContext context, RawElement parent) throws ValidationException {
        setParent(parent);

        if (!(context instanceof MediatorLangParser.TupleTypeContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "TupleTypeContext", context.toString());
        }

        for (MediatorLangParser.TypeContext baseType : ((MediatorLangParser.TupleTypeContext) context).type()) {
            addBaseType(Type.parse(baseType, this));
        }

        return this;
    }

    @Override
    public String toString() {
        return String.format(
                "(%s)",
                baseTypes.stream().map(Type::toString).collect(Collectors.joining(", "))
        );
    }

    @Override
    public RawElement getParent() {
        return parent;
    }

    @Override
    public TupleType setParent(RawElement parent) {
        this.parent = parent;
        return this;
    }
}
