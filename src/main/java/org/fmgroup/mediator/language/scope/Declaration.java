package org.fmgroup.mediator.language.scope;

import org.fmgroup.mediator.language.RawElement;

public interface Declaration extends RawElement {
    int size();

    String getIdentifier(int index);

    default boolean containsIdentifier(String identifier) {
        for (int i = 0; i < size(); i ++) {
            if (getIdentifier(i).equals(identifier)) return true;
        }

        return false;
    }
}
