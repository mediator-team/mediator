package org.fmgroup.mediator.language.entity.system;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.generator.framework.UtilCode;
import org.fmgroup.mediator.language.MediatorLangParser;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.scope.Declaration;
import org.fmgroup.mediator.language.scope.DeclarationCollection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ComponentDeclarationCollection implements RawElement, DeclarationCollection {

    public RawElement parent = null;
    public List<ComponentDeclaration> components = new ArrayList<>();

    @Override
    public RawElement fromContext(ParserRuleContext context) throws ValidationException {
        if (!(context instanceof MediatorLangParser.ComponentSegmentContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "ComponentSegmentContext", context.toString());
        }

        for (MediatorLangParser.ComponentDeclContext comp : ((MediatorLangParser.ComponentSegmentContext) context).componentDecl()) {
            components.add((ComponentDeclaration) new ComponentDeclaration().parse(comp, this));
        }

        return this;
    }

    @Override
    public String toString() {
        if (components.size() == 0) return "";
        else {
            return String.format(
                    "components {\n%s}\n",
                    UtilCode.addIndent(
                            components.stream().map(
                                componentDeclaration -> componentDeclaration.toString() + ";\n"
                            ).collect(Collectors.joining()),
                            1
                    )
            );
        }
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
    public List<Declaration> getDeclarationList() {
        return new ArrayList<>(components);
    }
}
