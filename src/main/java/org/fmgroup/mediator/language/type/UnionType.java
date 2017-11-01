package org.fmgroup.mediator.language.type;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.MediatorLangParser;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;

import java.util.ArrayList;
import java.util.List;

public class UnionType implements Type {

    private RawElement parent = null;
    private List<Type> baseTypes = new ArrayList<>();

    @Override
    public String getName() {
        return "union";
    }

    @Override
    public RawElement fromContext(ParserRuleContext context) throws ValidationException {
        if (!(context instanceof MediatorLangParser.UnionTypeContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "UnionTypeContext", context.toString());
        }

        for (MediatorLangParser.TypeContext baseType : ((MediatorLangParser.UnionTypeContext) context).type()) {
            baseTypes.add(UtilType.parse(baseType, this));
        }
        return this.validate();
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < baseTypes.size(); i ++) {
            if (i > 0) str += "| ";
            str += baseTypes.get(i).toString();
        }
        return str;
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
        UnionType nut = new UnionType();
        nut.setParent(parent);
        for (Type t : this.baseTypes) {
            nut.baseTypes.add((Type) t.clone(nut));
        }

        return nut;
    }

    @Override
    public RawElement validate() throws ValidationException {
        // TODO
        return this;
    }
}
