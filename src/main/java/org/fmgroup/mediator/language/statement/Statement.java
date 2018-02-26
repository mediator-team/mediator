package org.fmgroup.mediator.language.statement;

import org.fmgroup.mediator.language.generated.MediatorLangParser;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.term.Term;
import org.fmgroup.mediator.language.type.Type;

import java.util.Map;

public interface Statement extends RawElement {

    static Statement parse(MediatorLangParser.StatementContext sc, RawElement parent) throws ValidationException {

        if (sc instanceof MediatorLangParser.AssignmentStatementContext) {
            return new AssignmentStatement().fromContext(sc, parent);
        }
        if (sc instanceof MediatorLangParser.SynchronizingStatementContext) {
            return new SynchronizingStatement().fromContext(sc, parent);
        }
        if (sc instanceof MediatorLangParser.IteStatementContext) {
            return new IteStatement().fromContext(sc, parent);
        }
        if (sc instanceof MediatorLangParser.ReturnStatementContext) {
            return new ReturnStatement().fromContext(sc, parent);
        }

        throw ValidationException.UnregisteredStatement(sc.getClass().toString());
    }

    Statement refactor(Map<String, Type> typeRewriteMap, Map<String, Term> termRewriteMap) throws ValidationException;
}
