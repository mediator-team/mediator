package org.fmgroup.mediator.language.scope;

import org.fmgroup.mediator.language.term.IdValue;
import org.fmgroup.mediator.language.type.IdType;

import java.util.List;

public interface Scope {

    List<Declarations> getDeclarations();

    default boolean existsDeclaration(String identifier) {
        return getDeclaration(null, identifier) != null;
    }

    default Declaration getDeclaration(List<String> scopeIdentifiers, String identifier) {
        if (scopeIdentifiers == null || scopeIdentifiers.size() == 0) {
            // no scope identifiers are specified
            for (Declarations declarations : getDeclarations()) {
                if (declarations.getDeclaration(identifier) != null)
                    return declarations.getDeclaration(identifier);
            }
        } else {
            // TODO
        }
        return null;
    }

    default TypeDeclaration getType(IdType typeIdentifier) {
        Declaration decl = getDeclaration(typeIdentifier.scopeIdentifiers, typeIdentifier.identifier);
        if (decl instanceof TypeDeclaration) {
            return (TypeDeclaration) decl;
        }
        return null;
    }

    default TypeDeclaration getType(String identifier) {
        Declaration decl = getDeclaration(null, identifier);
        if (decl instanceof TypeDeclaration) {
            return (TypeDeclaration) decl;
        }
        return null;
    }

    default VariableDeclaration getVariable(IdValue variableIdentifier) {
        Declaration decl = getDeclaration(variableIdentifier.scopeIdentifiers, variableIdentifier.identifier);
        if (decl instanceof VariableDeclaration) {
            return (VariableDeclaration) decl;
        }
        return null;
    }

    default VariableDeclaration getVariable(String identifier) {
        Declaration decl = getDeclaration(null, identifier);
        if (decl instanceof VariableDeclaration) {
            return (VariableDeclaration) decl;
        }
        return null;
    }
}
