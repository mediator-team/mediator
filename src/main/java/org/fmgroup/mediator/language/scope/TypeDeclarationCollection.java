package org.fmgroup.mediator.language.scope;

import org.fmgroup.mediator.language.RawElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TypeDeclarationCollection implements DeclarationCollection<TypeDeclaration> {

    public List<TypeDeclaration> typeDeclarations = new ArrayList<>();
    private RawElement parent;

    public TypeDeclarationCollection() {
    }

    @Override
    public List<TypeDeclaration> getDeclarationList() {
        return typeDeclarations;
    }

    @Override
    public DeclarationCollection<TypeDeclaration> addDeclaration(TypeDeclaration declaration) {
        typeDeclarations.add(declaration);
        declaration.setParent(this);
        return this;
    }

    @Override
    public DeclarationCollection<TypeDeclaration> setDeclarationList(List<TypeDeclaration> declarationList) {
        typeDeclarations = new ArrayList<>();
        declarationList.forEach(this::addDeclaration);
        return this;
    }

    @Override
    public String toString() {
        return typeDeclarations.stream().map(
                typeDeclaration -> typeDeclaration.toString() + ";\n"
        ).collect(Collectors.joining(""));
    }

    @Override
    public RawElement getParent() {
        return parent;
    }

    @Override
    public TypeDeclarationCollection setParent(RawElement parent) {
        this.parent = parent;
        return this;
    }
}
