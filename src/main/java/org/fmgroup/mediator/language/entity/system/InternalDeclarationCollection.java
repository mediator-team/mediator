package org.fmgroup.mediator.language.entity.system;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.generated.MediatorLangParser;
import org.fmgroup.mediator.language.scope.DeclarationCollection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InternalDeclarationCollection implements DeclarationCollection<InternalDeclaration> {

    private RawElement parent;
    private List<InternalDeclaration> declarationList = new ArrayList<>();

    @Override
    public InternalDeclarationCollection fromContext(ParserRuleContext context, RawElement parent) throws ValidationException {
        if (!(context instanceof MediatorLangParser.InternalSegmentContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "InternalSegmentContext", context.toString());
        }

        ((MediatorLangParser.InternalSegmentContext) context).ID().forEach(
                terminalNode -> addDeclaration(new InternalDeclaration(terminalNode.toString(), this))
        );
        return this;
    }

    @Override
    public String toString() {
        if (declarationList.size() == 0) return "";
        else {
            return String.format(
                    "internals %s;\n",
                    declarationList.stream().map(Object::toString).collect(Collectors.joining(", "))
            );
        }
    }

    @Override
    public RawElement getParent() {
        return parent;
    }

    @Override
    public InternalDeclarationCollection setParent(RawElement parent) {
        this.parent = parent;
        return this;
    }

    @Override
    public List<InternalDeclaration> getDeclarationList() {
        return declarationList;
    }

    @Override
    public DeclarationCollection<InternalDeclaration> addDeclaration(InternalDeclaration declaration) {
        this.declarationList.add(declaration);
        declaration.setParent(this);
        return this;
    }

    @Override
    public DeclarationCollection<InternalDeclaration> setDeclarationList(List<InternalDeclaration> declarationList) {
        this.declarationList = new ArrayList<>();
        declarationList.forEach(this::addDeclaration);
        return this;
    }
}
