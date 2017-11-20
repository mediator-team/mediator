package org.fmgroup.mediator.language.scope;

public interface Declaration {
    int size();

    String getIdentifier(int index);

    default boolean containsIdentifier(String identifier) {
        for (int i = 0; i < size(); i ++) {
            if (getIdentifier(i).equals(identifier)) return true;
        }

        return false;
    }
}
