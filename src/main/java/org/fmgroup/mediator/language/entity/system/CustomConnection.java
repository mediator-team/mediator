package org.fmgroup.mediator.language.entity.system;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.Templated;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.entity.PortIdentifier;
import org.fmgroup.mediator.language.generated.MediatorLangParser;
import org.fmgroup.mediator.language.type.paramType.TemplateType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomConnection extends Connection {

    private TemplateType type;

    public TemplateType getType() {
        return type;
    }

    public CustomConnection setType(TemplateType type) {
        this.type = type;
        type.setParent(this);
        return this;
    }

    @Override
    public CustomConnection fromContext(ParserRuleContext context, RawElement parent) throws ValidationException {
        if (!(context instanceof MediatorLangParser.ConnectionDeclContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "ConnectionDeclContext", context.getClass().toString());
        }

        setParent(parent);

        setType(
                new TemplateType().fromContext(((MediatorLangParser.CustomConnectionContext) context).type(), this)
        );

        for (MediatorLangParser.PortIdentifierContext portid : ((MediatorLangParser.CustomConnectionContext) context).portIdentifier()) {
            addPortIdentifier(new PortIdentifier().fromContext(portid, this));
        }

        return this;
    }

    @Override
    public String toString() {
        return String.format(
                "%s(%s)",
                type.toString(),
                portIdentifiers.stream().map(Object::toString).collect(Collectors.joining(", "))
        );
    }

    @Override
    public Templated getProvider() {
        return this.getType().getProvider();
    }

    @Override
    public List<RawElement> getParams() {
        return this.getType().getParams();
    }
}
