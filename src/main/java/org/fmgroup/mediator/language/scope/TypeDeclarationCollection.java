package org.fmgroup.mediator.language.scope;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TypeDeclarationCollection implements Declarations {

    public List<TypeDeclaration> typedefs = new ArrayList<>();

    public TypeDeclarationCollection() { }

    @Override
    public List<Declaration> getDeclarationList() {
        return new ArrayList<>(typedefs);
    }

    @Override
    public String toString() {
        return  typedefs.stream().map(
                typedef -> typedef.toString() + ";\n"
        ).collect(Collectors.joining(""));
    }
}
