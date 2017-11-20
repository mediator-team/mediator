package org.fmgroup.mediator.language.statement;

import org.fmgroup.mediator.language.MediatorLangParser;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.term.Term;

import java.util.Map;

public interface Statement extends RawElement{
    static Statement parse (MediatorLangParser.StatementContext sc, RawElement parent) throws ValidationException {

        if (sc instanceof MediatorLangParser.AssignmentStatementContext) {
            return (Statement) new AssignmentStatement()
                    .setParent(parent)
                    .fromContext(sc);
        }
        if (sc instanceof MediatorLangParser.SynchronizingStatementContext) {
            return (Statement) new SynchronizingStatement()
                    .setParent(parent)
                    .fromContext(sc);
        }
        if (sc instanceof MediatorLangParser.IteStatementContext) {
            return (Statement) new IteStatement()
                    .setParent(parent)
                    .fromContext(sc);
        }
        if (sc instanceof MediatorLangParser.ReturnStatementContext) {
            return (Statement) new ReturnStatement()
                    .setParent(parent)
                    .fromContext(sc);
        }

        throw ValidationException.UnregisteredStatement(sc.getClass().toString());
    }

    static Statement refactor (Statement st, Map<String, Term> rewriteMap) throws ValidationException {
        if (st instanceof AssignmentStatement) {
            ((AssignmentStatement) st).expr = Term.refactor(((AssignmentStatement) st).expr, rewriteMap);
            if (((AssignmentStatement) st).target != null)
                ((AssignmentStatement) st).target = Term.refactor(((AssignmentStatement) st).target, rewriteMap);
        }
        if (st instanceof IteStatement) {
            ((IteStatement) st).condition = Term.refactor(((IteStatement) st).condition, rewriteMap);
            for (int i = 0; i < ((IteStatement) st).thenStmts.size(); i ++) {
                ((IteStatement) st).thenStmts.set(
                        i,
                        refactor(((IteStatement) st).thenStmts.get(i), rewriteMap)
                );
                ((IteStatement) st).elseStmts.set(
                        i,
                        refactor(((IteStatement) st).elseStmts.get(i), rewriteMap)
                );
            }
        }
        if (st instanceof ReturnStatement) {
            ((ReturnStatement) st).returnedValue = Term.refactor(((ReturnStatement) st).returnedValue, rewriteMap);
        }
        if (st instanceof SynchronizingStatement) {
//            List<PortIdentifier> newPorts = new ArrayList<>();
//
//            for (PortIdentifier port : ((SynchronizingStatement) st).synchronizedPorts) {
//                if (rewriteMap.containsKey(port + ".value")) {
//                    newPorts.add(rewriteMap.get(port + ".value").toString().replace("_value", ""));
//                } else {
//                    newPorts.add(port);
//                }
//            }
//
//            ((SynchronizingStatement) st).synchronizedPorts = newPorts;
        }
        return st;
    }
}
