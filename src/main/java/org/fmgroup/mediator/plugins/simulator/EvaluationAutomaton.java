package org.fmgroup.mediator.plugins.simulator;

import org.fmgroup.mediator.environment.operators.*;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.term.*;

import java.util.HashMap;
import java.util.Map;

public class EvaluationAutomaton implements Evaluation {

    private Map<String, Term> valueMap = new HashMap<>();

    public void set(String identifier, Term val) {
        valueMap.put(identifier, val);
    }

    public Term get(String identifier) {
        return valueMap.get(identifier);
    }

    public EvaluationAutomaton copy() throws ValidationException {
        EvaluationAutomaton result = new EvaluationAutomaton();

        for (String var: valueMap.keySet()) {
            result.set(var, (Term) this.get(var).copy());
        }

        return result;
    }

    public EvaluationAutomaton update(Term target, Term value) throws ValidationException {
        EvaluationAutomaton newev = this.copy();
        if (target instanceof IdValue) {
            if (((IdValue) target).getScopeIdentifiers().size() == 0) {
                newev.set(((IdValue) target).getIdentifier(), value);
            } else {

            }
        } else {

        }
        return newev;
    }

    public Term eval(Term raw) throws SimulatorException {

        if (raw instanceof IdValue) {
            // fixme
            return valueMap.get(((IdValue) raw).getIdentifier());
        }
        if (raw instanceof Value) return raw;
        if (raw instanceof BinaryOperatorTerm) {
            Term left = eval(((BinaryOperatorTerm) raw).getLeft());
            Term right = eval(((BinaryOperatorTerm) raw).getRight());

            if (((BinaryOperatorTerm) raw).getOpr() == EnumBinaryOperator.LAND) {
                return BinaryOperatorLAND.compute(left, right);
            }

            if (((BinaryOperatorTerm) raw).getOpr() == EnumBinaryOperator.LOR) {
                return BinaryOperatorLOR.compute(left, right);
            }

            if (((BinaryOperatorTerm) raw).getOpr() == EnumBinaryOperator.NEQ) {
                return SingleOperatorLNOT.compute(
                        BinaryOperatorEQ.compute(left, right)
                );
            }

            if (((BinaryOperatorTerm) raw).getOpr() == EnumBinaryOperator.EQ) {
                return BinaryOperatorEQ.compute(left, right);
            }
        }
        if (raw instanceof SingleOperatorTerm) {
            Term t = eval(((SingleOperatorTerm) raw).getTerm());

            if (((SingleOperatorTerm) raw).getOpr() == EnumSingleOperator.LNOT) {
                return SingleOperatorLNOT.compute(t);
            }
        }


        throw SimulatorException.UnderDevelopment();
    }

}
