package org.fmgroup.mediator.language.scope;

import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;

import java.util.List;

public interface Declaration extends RawElement {

    default int size() {
        return getIdentifiers().size();
    }

    default String getIdentifier(int index) {
        return getIdentifiers().get(index);
    }

    default Declaration addIdentifier(String identifier) throws ValidationException {
        Scope currScope = getCurrentScope();
        if (currScope.existsDeclaration(identifier) || containsIdentifier(identifier)) {
            throw ValidationException.DumplicatedIdentifier(identifier, "symbol");
        }

        getIdentifiers().add(identifier);
        return this;
    }

    List<String> getIdentifiers();

    default boolean containsIdentifier(String identifier) {
        for (int i = 0; i < size(); i++) {
            if (getIdentifier(i).equals(identifier)) return true;
        }

        return false;
    }
}
