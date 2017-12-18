package org.fmgroup.mediator.language.property;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.common.UtilCode;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.generated.MediatorLangParser;

import java.util.HashMap;
import java.util.Map;

public class PropertyCollection implements RawElement {
    private RawElement parent;
    private Map<String, Property> properties = new HashMap<>();

    @Override
    public RawElement getParent() {
        return this.parent;
    }

    @Override
    public PropertyCollection setParent(RawElement parent) {
        this.parent = parent;
        return this;
    }

    public PropertyCollection putProperty(String name, Property prop) throws ValidationException {
        prop.setParent(this);

        /*
         * since names of properties cannot be referred in other places,
         * we do not need to check whether the name has been used in other collections
         */
        if (this.properties.containsKey(name)) {
            throw ValidationException.DumplicatedIdentifier(name, "property name");
        }

        this.properties.put(name, prop);

        return this;
    }

    @Override
    public PropertyCollection fromContext(ParserRuleContext context, RawElement parent) throws ValidationException {
        if (!(context instanceof MediatorLangParser.PropertySegmentContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "PropertySegmentContext", context.toString());
        }

        for (int i = 0; i < ((MediatorLangParser.PropertySegmentContext) context).ID().size(); i ++) {
            putProperty(
                    ((MediatorLangParser.PropertySegmentContext) context).ID(i).getText(),
                    new Property().setParent(this).fromContext(((MediatorLangParser.PropertySegmentContext) context).property(i), this)
            );
        }

        return this;
    }

    @Override
    public PropertyCollection copy(RawElement parent) throws ValidationException {
        PropertyCollection props = new PropertyCollection();
        props.setParent(parent);
        throw ValidationException.UnderDevelopment();
    }

    @Override
    public String toString() {
        String props = "";
        for (String name : properties.keySet()) {
            props += String.format("%s: %s;\n", name, properties.get(name).toString());
        }
        return String.format(
                "properties {\n%s}\n",
                UtilCode.addIndent(props, 1)
        );
    }
}
