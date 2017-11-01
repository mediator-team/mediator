package org.fmgroup.mediator.language;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.type.Type;
import org.fmgroup.mediator.language.type.UtilType;

public class Typedef implements RawElement {

    public RawElement parent;

    public String name;
    public Type type;

    @Override
    public RawElement fromContext(ParserRuleContext context) throws ValidationException {
        if (!(context instanceof MediatorLangParser.TypedefContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "TypedefContext", context.toString());
        }

        name = ((MediatorLangParser.TypedefContext) context).ID().toString();
        type = UtilType.parse(((MediatorLangParser.TypedefContext) context).type(), this);

        return this.validate();
    }

    @Override
    public String toString() {
        return String.format(
                "typedef %s as %s;",
                type.toString(),
                name
        );
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
    public RawElement clone(RawElement parent) {
        return null;
    }

    @Override
    public RawElement validate() throws ValidationException {
        // TODO
        return this;
    }
}
