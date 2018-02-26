package org.fmgroup.mediator.language.term;

import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.generated.MediatorLangParser;
import org.fmgroup.mediator.language.type.Type;

import java.util.Map;

public interface Term extends RawElement {

    static Term parse(MediatorLangParser.TermContext term, RawElement parent) throws ValidationException {

        if (term instanceof MediatorLangParser.ValueTermContext) {
            return Term.parseValue(((MediatorLangParser.ValueTermContext) term).value(), parent);
        }


        if (term instanceof MediatorLangParser.BracketTermContext) {
            return parse(((MediatorLangParser.BracketTermContext) term).term(), parent);
        }
        if (term instanceof MediatorLangParser.BinaryOprTermContext) {
            return new BinaryOperatorTerm().fromContext(term, parent);
        }
        if (term instanceof MediatorLangParser.FieldTermContext) {
            return new FieldTerm().fromContext(term, parent);
        }
        if (term instanceof MediatorLangParser.ElementTermContext) {
            return new ElementTerm().fromContext(term, parent);
        }
        if (term instanceof MediatorLangParser.CallTermContext) {
            return new CallTerm().fromContext(term, parent);
        }
        if (term instanceof MediatorLangParser.SingleOprTermContext) {
            return new SingleOperatorTerm().fromContext(term, parent);
        }
        if (term instanceof MediatorLangParser.ListTermContext) {
            return new ListTerm().fromContext(term, parent);
        }
        if (term instanceof MediatorLangParser.TupleTermContext) {
            return new TupleTerm().fromContext(term, parent);
        }
        if (term instanceof MediatorLangParser.StructTermContext) {
            return new StructTerm().fromContext(term, parent);
        }
        if (term instanceof MediatorLangParser.IteTermContext) return new IteTerm().fromContext(term, parent);


        throw ValidationException.UnregisteredTerm(term.getClass().toString()).At(term);
    }

    static Term parseValue(MediatorLangParser.ValueContext value, RawElement parent) throws ValidationException {
        if (value instanceof MediatorLangParser.NullValueContext) {
            return new NullValue().fromContext(value, parent);
        }
        if (value instanceof MediatorLangParser.IntValueContext) {
            return new IntValue().fromContext(value, parent);
        }
        if (value instanceof MediatorLangParser.IdValueContext) {
            return new IdValue().fromContext(value, parent);
        }
        if (value instanceof MediatorLangParser.BoolValueContext) {
            return new BoolValue().fromContext(value, parent);
        }
        if (value instanceof MediatorLangParser.PortVarValueContext) {
            return new PortVariableValue().fromContext(value, parent);
        }

        throw ValidationException.UnregisteredTerm(value.getClass().toString());
    }

    int getPrecedence();

    default Type getType() throws ValidationException {
        assert false;
        return null;
    }

    default Term refactor(Map<String, Type> typeRewriteMap, Map<String, Term> termRewriteMap) throws ValidationException {
        return this;
    }

    @Override
    default Term copy(RawElement parent) throws ValidationException {
        throw ValidationException.UnderDevelopment();
    }

    @Override
    default Term copy() throws ValidationException {
        return this.copy(this.getParent());
    }

    default boolean isValue() {
        return false;
    }
}
