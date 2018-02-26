package org.fmgroup.mediator.language.type.termType;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.common.UtilCode;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.generated.MediatorLangParser;
import org.fmgroup.mediator.language.term.Term;
import org.fmgroup.mediator.language.type.Type;

import java.util.HashMap;
import java.util.Map;

public class StructType implements Type {

    private RawElement parent;
    private Map<String, Type> fields = new HashMap<>();

    public StructType addField(String name, Type type) throws ValidationException {
        if (fields.containsKey(name)) throw ValidationException.DumplicatedIdentifier(name, "field name");

        fields.put(name, type);
        type.setParent(this);
        return this;
    }

    @Override
    public StructType fromContext(ParserRuleContext context, RawElement parent) throws ValidationException {
        if (!(context instanceof MediatorLangParser.StructTypeContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "StructTypeContext", context.toString());
        }

        setParent(parent);
        for (int i = 0; i < ((MediatorLangParser.StructTypeContext) context).ID().size(); i++) {
            addField(
                    ((MediatorLangParser.StructTypeContext) context).ID(i).getText(),
                    Type.parse(((MediatorLangParser.StructTypeContext) context).type(i), this)
            );
        }

        return this;
    }

    @Override
    public String toString() {
        String rel = "struct {\n";
        for (String name : fields.keySet()) {
            rel += UtilCode.addIndent(name + ": " + fields.get(name).toString() + ";\n", 1);
        }
        rel += "}";
        return rel;
    }

    @Override
    public RawElement getParent() {
        return parent;
    }

    @Override
    public StructType setParent(RawElement parent) {
        this.parent = parent;
        return this;
    }

    @Override
    public StructType copy(RawElement parent) throws ValidationException {
        StructType nst = new StructType();
        nst.setParent(parent);
        for (String key : this.fields.keySet()) {
            nst.addField(key, this.fields.get(key).copy(nst));
        }

        return nst;
    }

    @Override
    public Type refactor(Map<String, Type> typeRewriteMap, Map<String, Term> termRewriteMap) throws ValidationException {
        return this;
    }
}
