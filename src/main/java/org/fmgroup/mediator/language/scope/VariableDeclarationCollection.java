package org.fmgroup.mediator.language.scope;

import org.fmgroup.mediator.common.UtilCode;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VariableDeclarationCollection implements DeclarationCollection<VariableDeclaration> {

    private RawElement parent = null;
    private List<VariableDeclaration> declarationList = new ArrayList<>();

    public VariableDeclarationCollection() {
    }

    @Override
    public RawElement getParent() {
        return parent;
    }

    @Override
    public VariableDeclarationCollection setParent(RawElement parent) {
        this.parent = parent;
        return this;
    }

    @Override
    public VariableDeclarationCollection copy(RawElement parent) throws ValidationException {
        VariableDeclarationCollection newCollection = new VariableDeclarationCollection();

        newCollection.setParent(parent);
        for (VariableDeclaration vardecl : getDeclarationList()) {
            newCollection.addDeclaration(vardecl.copy(newCollection));
        }

        return newCollection;
    }

    @Override
    public List<VariableDeclaration> getDeclarationList() {
        return declarationList;
    }

    @Override
    public VariableDeclarationCollection setDeclarationList(List<VariableDeclaration> declarationList) {
        declarationList = new ArrayList<>();
        declarationList.forEach(this::addDeclaration);
        return this;
    }

    public VariableDeclarationCollection addDeclaration(VariableDeclaration declaration) {
        this.declarationList.add(declaration);
        declaration.setParent(this);
        return this;
    }

    @Override
    public String toString() {
        if (declarationList.size() > 0) {
            return String.format(
                    "variables {\n %s}\n",
                    UtilCode.addIndent(
                            declarationList.stream().map(
                                    vardecl -> vardecl.toString() + ";\n"
                            ).collect(Collectors.joining("")),
                            1
                    )
            );
        } else
            return "";
    }
}
