package org.fmgroup.mediator.language.entity;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.generated.MediatorLangParser;
import org.fmgroup.mediator.language.scope.DeclarationCollection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EntityInterface implements RawElement, DeclarationCollection<PortDeclaration> {

    private RawElement parent;

    private List<PortDeclaration> declarationList = new ArrayList<>();

    public EntityInterface() {
    }

    @Override
    public EntityInterface fromContext(ParserRuleContext context, RawElement parent) throws ValidationException {
        if (!(context instanceof MediatorLangParser.EntityInterfaceContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "CompInterfaceContext", context.toString());
        }

        setParent(parent);
        for (MediatorLangParser.PortsDeclContext pdc : ((MediatorLangParser.EntityInterfaceContext) context).portsDecl()) {
            addDeclaration(new PortDeclaration().fromContext(pdc, this));
        }

        return this;
    }

    @Override
    public String toString() {
        return declarationList.stream().map(
                PortDeclaration::toString
        ).collect(Collectors.joining(", "));
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
    public EntityInterface copy(RawElement parent) throws ValidationException {
        EntityInterface newif = new EntityInterface();
        newif.setParent(parent);
        for (PortDeclaration p : declarationList) {
            newif.addDeclaration(p.copy(newif));
        }

        return newif;
    }

    @Override
    public List<PortDeclaration> getDeclarationList() {
        return declarationList;
    }

    @Override
    public DeclarationCollection<PortDeclaration> addDeclaration(PortDeclaration declaration) {
        declarationList.add(declaration);
        declaration.setParent(this);
        return this;
    }

    @Override
    public DeclarationCollection<PortDeclaration> setDeclarationList(List<PortDeclaration> declarationList) {
        this.declarationList = new ArrayList<>();
        declarationList.forEach(this::addDeclaration);
        return this;
    }
}
