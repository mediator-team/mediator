package org.fmgroup.mediator.language.term;

import org.fmgroup.mediator.language.MediatorLangParser;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.term.Term;

import java.util.Map;

public class UtilTerm {
    public static Term refactor (Term t, Map<String, Term> rewriteMap) throws ValidationException {

        if (rewriteMap.containsKey(t.toString())) {
            return (Term) rewriteMap.get(t.toString()).clone(t.getParent());
        }

        if (t instanceof BinaryOperatorTerm) {
            ((BinaryOperatorTerm) t).left = refactor(((BinaryOperatorTerm) t).left, rewriteMap);
            ((BinaryOperatorTerm) t).right = refactor(((BinaryOperatorTerm) t).right, rewriteMap);
        }
        if (t instanceof CallTerm) {
            ((CallTerm) t).callee = refactor(((CallTerm) t).callee, rewriteMap);
            for (int i = 0; i < ((CallTerm) t).args.size(); i ++) {
                ((CallTerm) t).args.set(i, refactor(((CallTerm) t).args.get(i), rewriteMap));
            }
        }
        if (t instanceof ElementTerm) {
            ((ElementTerm) t).container = refactor(((ElementTerm) t).container, rewriteMap);
            ((ElementTerm) t).key = refactor(((ElementTerm) t).key, rewriteMap);
        }
        if (t instanceof FieldTerm) {
            ((FieldTerm) t).owner = refactor(((FieldTerm) t).owner, rewriteMap);
        }
        if (t instanceof IteTerm) {
            ((IteTerm) t).condition = refactor(((IteTerm) t).condition, rewriteMap);
            ((IteTerm) t).thenTerm = refactor(((IteTerm) t).thenTerm, rewriteMap);
            ((IteTerm) t).elseTerm = refactor(((IteTerm) t).elseTerm, rewriteMap);
        }
        if (t instanceof SingleOperatorTerm) {
            ((SingleOperatorTerm) t).term = refactor(((SingleOperatorTerm) t).term, rewriteMap);
        }
        if (t instanceof TupleTerm) {
            ((TupleTerm) t).left = refactor(((TupleTerm) t).left, rewriteMap);
            ((TupleTerm) t).right = refactor(((TupleTerm) t).right, rewriteMap);
        }

        return t;
    }

    public static Term parse(MediatorLangParser.TermContext term, RawElement parent) throws ValidationException {

        if (term instanceof MediatorLangParser.ValueTermContext) {
            return UtilTerm.parseValue(((MediatorLangParser.ValueTermContext) term).value(), parent);
        }


        if (term instanceof MediatorLangParser.BracketTermContext) {
            return parse(((MediatorLangParser.BracketTermContext) term).term(), parent);
        }
        if (term instanceof MediatorLangParser.BinaryOprTermContext) {
            return (Term) new BinaryOperatorTerm()
                    .setParent(parent)
                    .fromContext(term);
        }
        if (term instanceof MediatorLangParser.FieldTermContext) {
            return (Term) new FieldTerm()
                    .setParent(parent)
                    .fromContext(term);
        }
        if (term instanceof MediatorLangParser.ElementTermContext) {
            return (Term) new ElementTerm()
                    .setParent(parent)
                    .fromContext(term);
        }
        if (term instanceof MediatorLangParser.CallTermContext) {
            return (Term) new CallTerm()
                    .setParent(parent)
                    .fromContext(term);
        }
        if (term instanceof MediatorLangParser.SingleOprTermContext) {
            return (Term) new SingleOperatorTerm()
                    .setParent(parent)
                    .fromContext(term);
        }
        if (term instanceof MediatorLangParser.TupleTermContext) {
            return (Term) new TupleTerm()
                    .setParent(parent)
                    .fromContext(term);
        }
        if (term instanceof MediatorLangParser.ListTermContext) {
            return (Term) new ListTerm()
                    .setParent(parent)
                    .fromContext(term);
        }
        if (term instanceof MediatorLangParser.IteTermContext) return (Term) new IteTerm().setParent(parent).fromContext(term);


        throw ValidationException.UnregisteredTerm(term.getClass().toString());
    }

    public static Term parseValue(MediatorLangParser.ValueContext value, RawElement parent) throws ValidationException {
        if (value instanceof MediatorLangParser.NullValueContext) {
            return (Term) new NullValue()
                    .setParent(parent)
                    .fromContext(value);
        }
        if (value instanceof MediatorLangParser.IntValueContext) {
            return (Term) new IntValue()
                    .setParent(parent)
                    .fromContext(value);
        }
        if (value instanceof MediatorLangParser.IdValueContext) {
            return (Term) new IdValue()
                    .setParent(parent)
                    .fromContext(value);
        }
        if (value instanceof MediatorLangParser.BoolValueContext) {
            return (Term) new BoolValue()
                    .setParent(parent)
                    .fromContext(value);
        }

        throw ValidationException.UnregisteredTerm(value.getClass().toString());
    }
}
