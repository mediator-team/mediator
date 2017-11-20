package org.fmgroup.mediator.language.entity.system;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.fmgroup.mediator.language.MediatorLangParser;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.scope.Declaration;
import org.fmgroup.mediator.language.scope.Scope;
import org.fmgroup.mediator.language.type.TemplateType;

import java.util.ArrayList;
import java.util.List;

public class ComponentDeclaration implements RawElement, Declaration {

    public RawElement parent = null;
    public List<String> identifiers = new ArrayList<>();
    public TemplateType type = null;

    @Override
    public int size() {
        return identifiers.size();
    }

    @Override
    public String getIdentifier(int index) {
        return identifiers.get(index);
    }

    @Override
    public RawElement fromContext(ParserRuleContext context) throws ValidationException {
        if (!(context instanceof MediatorLangParser.ComponentDeclContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "ComponentDeclContext", context.toString());
        }

        type = (TemplateType) new TemplateType().parse(((MediatorLangParser.ComponentDeclContext) context).type(), this);
        Scope currScope = getCurrentScope();

        for (TerminalNode name : ((MediatorLangParser.ComponentDeclContext) context).ID()) {
            if (identifiers.contains(name.getText()) || currScope.existsDeclaration(name.getText())) {
                throw ValidationException.DumplicatedIdentifier(name.getText(), "symbol");
            }
            identifiers.add(name.getText());
        }

        return this;
    }

    @Override
    public String toString() {
        return String.join(", ", identifiers) + ": " + type.toString();
    }

    @Override
    public RawElement getParent() {
        return this.parent;
    }

    @Override
    public RawElement setParent(RawElement parent) {
        this.parent = parent;
        return this;
    }
}
