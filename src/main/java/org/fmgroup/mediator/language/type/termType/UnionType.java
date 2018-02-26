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

public class UnionType implements Type {

    private RawElement parent = null;
    private List<Type> baseTypes = new ArrayList<>();

    public List<Type> getBaseTypes() {
        return baseTypes;
    }

    public UnionType setBaseTypes(List<Type> baseTypes) {
        this.baseTypes = new ArrayList<>();
        baseTypes.forEach(this::addBaseType);
        return this;
    }

    public UnionType addBaseType(Type baseType) {
        this.baseTypes.add(baseType);
        baseType.setParent(this);
        return this;
    }

    @Override
    public UnionType fromContext(ParserRuleContext context, RawElement parent) throws ValidationException {
        if (!(context instanceof MediatorLangParser.UnionTypeContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "UnionTypeContext", context.toString());
        }

        setParent(parent);
        for (MediatorLangParser.TypeContext baseType : ((MediatorLangParser.UnionTypeContext) context).type()) {
            addBaseType(Type.parse(baseType, this));
        }

        return this;
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < baseTypes.size(); i++) {
            if (i > 0) str += " | ";
            str += baseTypes.get(i).toString();
        }
        return str;
    }

    @Override
    public RawElement getParent() {
        return parent;
    }

    @Override
    public UnionType setParent(RawElement parent) {
        this.parent = parent;
        return this;
    }

    @Override
    public UnionType copy(RawElement parent) throws ValidationException {
        UnionType nut = new UnionType();
        nut.setParent(parent);
        for (Type t : getBaseTypes()) {
            nut.addBaseType(t.copy(nut));
        }

        return nut;
    }

    @Override
    public Type refactor(Map<String, Type> typeRewriteMap, Map<String, Term> termRewriteMap) throws ValidationException {
        for (int i = 0; i < getBaseTypes().size(); i ++) {
            getBaseTypes().set(i, getBaseTypes().get(i).refactor(typeRewriteMap, termRewriteMap));
        }
        return this;
    }
}
