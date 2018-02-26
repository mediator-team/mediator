package org.fmgroup.mediator.language.statement;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.common.UtilCode;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.generated.MediatorLangParser;
import org.fmgroup.mediator.language.term.Term;
import org.fmgroup.mediator.language.type.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class IteStatement implements Statement, Statements {

    private RawElement parent;
    private Term condition;
    private List<Statement> thenStmts = new ArrayList<>();
    private List<Statement> elseStmts = new ArrayList<>();

    public Term getCondition() {
        return condition;
    }

    public IteStatement setCondition(Term condition) {
        this.condition = condition;
        condition.setParent(this);
        return this;
    }

    public List<Statement> getThenStmts() {
        return thenStmts;
    }

    public IteStatement setThenStmts(List<Statement> thenStmts) {
        this.thenStmts = new ArrayList<>();
        thenStmts.forEach(this::addThenStmt);
        return this;
    }

    public IteStatement addThenStmt(Statement statement) {
        thenStmts.add(statement);
        statement.setParent(this);
        return this;
    }

    public List<Statement> getElseStmts() {
        return elseStmts;
    }

    public IteStatement setElseStmts(List<Statement> elseStmts) {
        this.elseStmts = new ArrayList<>();
        elseStmts.forEach(this::addElseStmt);
        return this;
    }

    public IteStatement addElseStmt(Statement statement) {
        elseStmts.add(statement);
        statement.setParent(this);
        return this;
    }

    @Override
    public IteStatement fromContext(ParserRuleContext context, RawElement parent) throws ValidationException {
        if (!(context instanceof MediatorLangParser.IteStatementContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "IteStatementContext", context.toString());
        }

        setParent(parent);
        setCondition(
                Term.parse(((MediatorLangParser.IteStatementContext) context).condition, this)
        );

        if (((MediatorLangParser.IteStatementContext) context).thenstmt != null) addThenStmt(
                Statement.parse(((MediatorLangParser.IteStatementContext) context).thenstmt, this)
        );
        if (((MediatorLangParser.IteStatementContext) context).thenstmts != null) {
            for (MediatorLangParser.StatementContext sc : ((MediatorLangParser.IteStatementContext) context).thenstmts.statement()) {
                addThenStmt(Statement.parse(sc, this));
            }
        }
        if (((MediatorLangParser.IteStatementContext) context).elsestmt != null) addElseStmt(
                Statement.parse(((MediatorLangParser.IteStatementContext) context).elsestmt, this)
        );
        if (((MediatorLangParser.IteStatementContext) context).elsestmts != null) {
            for (MediatorLangParser.StatementContext sc : ((MediatorLangParser.IteStatementContext) context).elsestmts.statement()) {
                addElseStmt(Statement.parse(sc, this));
            }
        }

        return this;
    }

    @Override
    public boolean equals(Object obj) {
        return
                this.toString().equals(obj.toString()) &&
                        obj instanceof Statement;
    }

    @Override
    public String toString() {
        String rel = String.format("if (%s) ", condition.toString());
        if (thenStmts.size() == 1) rel += thenStmts.get(0).toString();
        else {
            rel += "{\n";
            for (Statement s : thenStmts) rel += UtilCode.addIndent(s.toString(), 1) + "\n";
            rel += "}";
        }

        if (elseStmts.size() > 0) {
            rel += "\nelse ";
            if (elseStmts.size() == 1) rel += elseStmts.get(0).toString() + "\n";
            else {
                rel += "{\n";
                for (Statement s : elseStmts) rel += UtilCode.addIndent(s.toString(), 1) + "\n";
                rel += "}";
            }
        }
        return rel;
    }

    @Override
    public RawElement getParent() {
        return parent;
    }

    @Override
    public RawElement setParent(RawElement parent) {
        this.parent = parent;
        return this;
    }

    @Override
    public RawElement copy(RawElement parent) throws ValidationException {
        IteStatement nis = new IteStatement();
        nis.setParent(parent);
        nis.setCondition(this.condition.copy(nis));
        for (Statement st : this.thenStmts) nis.addThenStmt((Statement) st.copy(nis));
        for (Statement st : this.elseStmts) nis.addElseStmt((Statement) st.copy(nis));

        return nis;
    }

    @Override
    public Statement refactor(Map<String, Type> typeRewriteMap, Map<String, Term> termRewriteMap) throws ValidationException {
        setCondition(getCondition().refactor(typeRewriteMap, termRewriteMap));
        for (Statement s : getThenStmts()) {
            s.refactor(typeRewriteMap, termRewriteMap);
        }
        for (Statement s : getElseStmts()) {
            s.refactor(typeRewriteMap, termRewriteMap);
        }
        return this;
    }

    @Override
    public Statement nextStatement(Statement s) {
        if (thenStmts.contains(s)) {
            if (thenStmts.indexOf(s) + 1 < thenStmts.size()) return thenStmts.get(thenStmts.indexOf(s) + 1);
            else return null;
        }
        if (elseStmts.contains(s)) {
            if (elseStmts.indexOf(s) + 1 < elseStmts.size()) return elseStmts.get(elseStmts.indexOf(s) + 1);
            else return null;
        }
        return null;
    }
}
