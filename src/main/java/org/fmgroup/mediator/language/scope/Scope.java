package org.fmgroup.mediator.language.scope;

import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.entity.PortDeclaration;
import org.fmgroup.mediator.language.entity.system.ComponentDeclaration;
import org.fmgroup.mediator.language.term.IdValue;
import org.fmgroup.mediator.language.type.termType.EnumType;
import org.fmgroup.mediator.language.type.termType.IdType;

import java.util.ArrayList;
import java.util.List;

public interface Scope extends RawElement{

    List<DeclarationCollection> getDeclarations();

    default boolean existsDeclaration(String identifier) {
        return getDeclaration(null, identifier) != null;
    }

    default Declaration getDeclaration(List<String> scopeIdentifiers, String identifier) {
        if (scopeIdentifiers == null || scopeIdentifiers.size() == 0) {
            // no scope identifiers are specified
            for (DeclarationCollection declarationCollection : getDeclarations()) {
                if (declarationCollection.getDeclaration(identifier) != null)
                    return declarationCollection.getDeclaration(identifier);
            }
        } else {
            // TODO
        }
        return null;
    }

    default TypeDeclaration getType(IdType typeIdentifier) {
        Declaration decl = getDeclaration(typeIdentifier.getScopeIdentifiers(), typeIdentifier.getIdentifier());
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
        Declaration decl = getDeclaration(variableIdentifier.getScopeIdentifiers(), variableIdentifier.getIdentifier());
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

    default PortDeclaration getPort(String identifier) throws ValidationException {
        Declaration decl = getDeclaration(null, identifier);
        if (decl instanceof PortDeclaration) {
            return (PortDeclaration) decl;
        }

        throw ValidationException.UnknownIdentifier(identifier, "port");
    }

    default ComponentDeclaration getComponent(String identifier) {
        Declaration decl = getDeclaration(null, identifier);
        if (decl instanceof ComponentDeclaration) {
            return (ComponentDeclaration) decl;
        }
        return null;
    }

    default List<TypeDeclaration> getEnumTypes() {
        List<TypeDeclaration> result = new ArrayList<>();
        for (DeclarationCollection coll : getDeclarations()) {
            for (Object decl: coll.getDeclarationList()) {
                if (decl instanceof TypeDeclaration && ((TypeDeclaration) decl).getType() instanceof EnumType) {
                    result.add((TypeDeclaration) decl);
                }
            }
        }

        return result;
    }

    default TypeDeclaration getEnumFromIdentifier(String identifier) {
        for (TypeDeclaration typedecl: getEnumTypes()) {
            if (typedecl.getType() instanceof EnumType) {
                if (((EnumType) typedecl.getType()).getItems().contains(identifier)) {
                    return typedecl;
                }
            }
        }

        return null;
    }
}
