package org.fmgroup.mediator.language.entity.automaton;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.common.UtilCode;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.generated.MediatorLangParser;
import org.fmgroup.mediator.language.statement.Statement;
import org.fmgroup.mediator.language.statement.Statements;
import org.fmgroup.mediator.language.statement.SynchronizingStatement;
import org.fmgroup.mediator.language.term.Term;
import org.fmgroup.mediator.language.type.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TransitionSingle implements Transition, Statements {

    private RawElement parent;
    private Term guard;
    private List<Statement> statements = new ArrayList<>();
    private boolean isInternal = true;

    public List<Statement> getStatements() {
        return statements;
    }

    public TransitionSingle setStatements(List<Statement> statements) {
        this.statements = new ArrayList<>();
        statements.forEach(this::addStatement);
        return this;
    }

    public int size() {
        return statements.size();
    }

    public Statement getStatement(int i) {
        return statements.get(i);
    }

    public TransitionSingle addStatement(Statement statement) {
        this.statements.add(statement);
        statement.setParent(this);
        if (statement instanceof SynchronizingStatement) isInternal = false;

        return this;
    }

    public boolean isInternal() {
        return isInternal;
    }

    @Override
    public TransitionSingle fromContext(ParserRuleContext context, RawElement parent) throws ValidationException {
        if (!(context instanceof MediatorLangParser.TransitionSingleContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "TransitionSingleContext", context.toString());
        }

        setParent(parent);
        setGuard(Term.parse(((MediatorLangParser.TransitionSingleContext) context).term(), this));

        /**
         * a single transition may have two form:
         * 1. guard -> stmt;
         * 2. guard -> {
         *        stmt1;
         *        stmt2;
         *        ...
         *    }
         *
         * in these different cases, the assigned fields in the context are different, plz refer to the antlr source file
         */
        if (((MediatorLangParser.TransitionSingleContext) context).statement() != null) {
            addStatement(Statement.parse(((MediatorLangParser.TransitionSingleContext) context).statement(), this));
        } else {
            for (MediatorLangParser.StatementContext sc : ((MediatorLangParser.TransitionSingleContext) context).statements().statement()) {
                addStatement(Statement.parse(sc, this));
            }
        }

        return this;
    }

    @Override
    public String toString() {
        String rel = guard.toString() + " -> ";
        if (statements.size() == 1) {
            return rel + statements.get(0).toString();
        } else {
            rel += "{\n";
            for (Statement statement : statements) {
                rel += UtilCode.addIndent(statement.toString(), 1) + "\n";
            }
            rel += "}";
            return rel;
        }
    }

    @Override
    public RawElement getParent() {
        return parent;
    }

    @Override
    public TransitionSingle setParent(RawElement parent) {
        this.parent = parent;
        return this;
    }

    @Override
    public TransitionSingle copy(RawElement parent) throws ValidationException {
        TransitionSingle nt = new TransitionSingle();
        nt.setParent(parent);
        nt.setGuard(this.guard.copy(nt));
        for (Statement st : this.statements) {
            nt.addStatement((Statement) st.copy(nt));
        }
        return nt;
    }

    @Override
    public Term getGuard() {
        return this.guard;
    }

    public TransitionSingle setGuard(Term guard) throws ValidationException {
        this.guard = guard;
        guard.setParent(this);
        return this;
    }

    @Override
    public TransitionSingle refactor(Map<String, Type> typeRewriteMap, Map<String, Term> termRewriteMap, RawElement parent) throws ValidationException {
        this.parent = parent;
        setGuard(getGuard().refactor(termRewriteMap));
        List<Statement> newStatements = new ArrayList<>();
        for (Statement s : getStatements()) {
            newStatements.add(s.refactor(termRewriteMap));
        }

        setStatements(newStatements);
        return this;
    }

    @Override
    public Statement nextStatement(Statement s) {
        if (statements.contains(s)) {
            if (statements.indexOf(s) + 1 < statements.size()) return statements.get(statements.indexOf(s) + 1);
        }

        return null;
    }
}
