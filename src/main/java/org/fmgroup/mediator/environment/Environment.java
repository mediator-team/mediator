package org.fmgroup.mediator.environment;

import org.fmgroup.mediator.language.ValidationException;

import java.util.HashMap;
import java.util.Map;

public class Environment {
    static Map<BinaryOperatorIndex, BinaryOperator> binaryOperators
            = new HashMap<>();

    private static void registerBinaryOperator(BinaryOperatorIndex key, BinaryOperator opr) throws ValidationException {
        if (!binaryOperators.containsKey(key)) {
            binaryOperators.put(key, opr);
        } else {
            // FIXME
            throw new ValidationException();
        }
    }
}
