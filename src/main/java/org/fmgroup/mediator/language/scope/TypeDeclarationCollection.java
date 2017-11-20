package org.fmgroup.mediator.language.scope;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TypeDeclarationCollection implements DeclarationCollection {

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
