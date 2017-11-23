package org.fmgroup.mediator.language.scope;

import org.fmgroup.mediator.language.RawElement;

import java.util.List;
import java.util.stream.Collectors;

public interface DeclarationCollection<T extends Declaration> extends RawElement {
    List<T> getDeclarationList();

    DeclarationCollection<T> setDeclarationList(List<T> declarationList);

    DeclarationCollection<T> addDeclaration(T declaration);

    /**
     * getDeclaration(i) returns the declaration where ith argument belongs, e.g. in
     * <p>
     * ```
     * function f(a,b:int, c:bool) { ... }
     * ```
     * when you call getDeclaration(2) of the function interface, it returns `a,b:int` because it is
     * where the second argument `b` belongs, instead of the second declaration `c:bool`
     *
     * @param index
     * @return the declaration where ith argument belongs
     */
    default T getDeclaration(int index) {
        List<T> declarations = this.getDeclarationList();
        int offset = index;
        for (T declaration : declarations) {
            if (declaration.size() > index) return declaration;
            else index -= declaration.size();
        }
        return null;
    }

    default Declaration getDeclaration(String identifier) {
        List<Declaration> result = this.getDeclarationList()
                .stream()
                .filter(declaration -> declaration.containsIdentifier(identifier))
                .collect(Collectors.toList());

        assert result.size() <= 1;
        if (result.size() == 1) {
            return result.get(0);
        } else
            return null;
    }

    default String getDeclarationIdentifier(int index) {
        List<T> declarations = this.getDeclarationList();
        int offset = index;
        for (T declaration : declarations) {
            if (declaration.size() > index) return declaration.getIdentifier(index);
            else index -= declaration.size();
        }
        return null;
    }

    default int getDeclarationIndex(String identifier) {
        List<String> identifiers = getDeclarationList()
                .stream()
                .map(Declaration::getIdentifiers)
                .flatMap(List::stream).collect(Collectors.toList());

        for (int i = 0; i < identifiers.size(); i++) {
            if (identifiers.get(i).equals(identifier))
                return i;
        }
        return -1;
    }
}
