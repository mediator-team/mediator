package org.fmgroup.mediator.language.term;

import org.fmgroup.mediator.language.ValidationException;

public enum EnumSingleOperator {
    LNOT("!", 10),
    NEGATIVE("-", 10);

    public String oprString;
    public int oprLevel;


    EnumSingleOperator(String oprString, int oprLevel) {
        this.oprLevel = oprLevel;
        this.oprString = oprString;
    }

    public static EnumSingleOperator fromString(String str) throws ValidationException {
        for (EnumSingleOperator opr : EnumSingleOperator.values()) {
            if (opr.oprString.equals(str)) {
                return opr;
            }
        }

        throw ValidationException.UnregisteredOperator(str);
    }

    @Override
    public String toString() {
        return oprString;
    }
}
