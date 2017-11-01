package org.fmgroup.mediator.language.type;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.generator.framework.UtilCode;
import org.fmgroup.mediator.language.MediatorLangParser;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;

import java.util.HashMap;
import java.util.Map;

public class StructType implements Type {

    private RawElement parent;

    public Map<String, Type> fields = new HashMap<>();

    @Override
    public RawElement fromContext(ParserRuleContext context) throws ValidationException {
        if (!(context instanceof MediatorLangParser.StructTypeContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "StructTypeContext", context.toString());
        }

        for (int i = 0; i < ((MediatorLangParser.StructTypeContext) context).ID().size(); i ++) {
            fields.put(
                    ((MediatorLangParser.StructTypeContext) context).ID(i).getText(),
                    UtilType.parse(((MediatorLangParser.StructTypeContext) context).type(i), this)
            );
        }

        return this.validate();
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
    public RawElement setParent(RawElement parent)  {
        this.parent = parent;
        return this;
    }

    @Override
    public RawElement clone(RawElement parent) throws ValidationException {
        StructType nst = new StructType();
        nst.setParent(parent);
        for (String key : this.fields.keySet()) {
            nst.fields.put(key, (Type) this.fields.get(key).clone(nst));
        }

        return nst;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public RawElement validate() throws ValidationException {
        // TODO
        return this;
    }
}
