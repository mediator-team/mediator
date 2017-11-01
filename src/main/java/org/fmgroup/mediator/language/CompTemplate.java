package org.fmgroup.mediator.language;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.type.Type;
import org.fmgroup.mediator.language.type.UtilType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompTemplate implements RawElement {

    private RawElement parent;

    public Map<String, Type> params = new HashMap<>();
    public List<String> keyIndexes = new ArrayList<>();

    public CompTemplate () {}

    public CompTemplate(CompTemplate compTemplate, InterfacedElement newParent) {
        parent = newParent;
        for (String name : compTemplate.keyIndexes) {
            // TODO use copy constructor instead
            params.put(name, compTemplate.params.get(name));
            keyIndexes.add(name);
        }
    }

    @Override
    public RawElement fromContext(ParserRuleContext context) throws ValidationException {
        if (!(context instanceof MediatorLangParser.CompTemplateContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "CompTemplateContext", context.toString());
        }

        for (MediatorLangParser.ParamContext pc : ((MediatorLangParser.CompTemplateContext) context).param()) {
            keyIndexes.add(pc.ID().getText());
            params.put(pc.ID().getText(), UtilType.parse(pc.type(), this));
        }
        return this.validate();
    }

    @Override
    public String toString() {
        String rel = "";
        for (String name : keyIndexes) {
            if (rel.length() > 0) rel += ", ";
            rel += name + ": " + params.get(name).toString();
        }
        return rel;
    }

    @Override
    public RawElement getParent() {
        return parent;
    }

    @Override
    public RawElement setParent(RawElement parent) {
        this.parent = parent;
        return this;
    }

    @Override
    public RawElement clone(RawElement parent) {
        return null;
    }

    @Override
    public RawElement validate() throws ValidationException {
        // TODO
        return this;
    }
}
