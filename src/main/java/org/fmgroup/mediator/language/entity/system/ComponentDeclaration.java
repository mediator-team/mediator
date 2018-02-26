package org.fmgroup.mediator.language.entity.system;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.generated.MediatorLangParser;
import org.fmgroup.mediator.language.scope.Declaration;
import org.fmgroup.mediator.language.type.paramType.TemplateType;

import java.util.ArrayList;
import java.util.List;

public class ComponentDeclaration implements RawElement, Declaration {

    private RawElement parent = null;
    private List<String> identifiers = new ArrayList<>();
    private TemplateType type = null;

    public TemplateType getType() {
        return type;
    }

    public ComponentDeclaration setType(TemplateType type) {
        this.type = type;
        type.setParent(this);
        return this;
    }

    @Override
    public List<String> getIdentifiers() {
        return identifiers;
    }

    public ComponentDeclaration setIdentifiers(List<String> identifiers) {
        this.identifiers = identifiers;
        return this;
    }

    @Override
    public ComponentDeclaration fromContext(ParserRuleContext context, RawElement parent) throws ValidationException {
        if (!(context instanceof MediatorLangParser.ComponentDeclContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "ComponentDeclContext", context.toString());
        }

        setParent(parent);
        setType(
                new TemplateType()
                        .fromContext(((MediatorLangParser.ComponentDeclContext) context).type(), this)
        );

        for (TerminalNode name : ((MediatorLangParser.ComponentDeclContext) context).ID()) {
            addIdentifier(name.getText());
        }

        return this;
    }

    @Override
    public String toString() {
        return String.join(", ", getIdentifiers()) + ": " + getType().toString();
    }

    @Override
    public RawElement getParent() {
        return this.parent;
    }

    @Override
    public ComponentDeclaration setParent(RawElement parent) {
        this.parent = parent;
        return this;
    }
}
