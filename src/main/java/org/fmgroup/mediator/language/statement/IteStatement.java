package org.fmgroup.mediator.language.statement;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.generator.framework.UtilCode;
import org.fmgroup.mediator.language.MediatorLangParser;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.term.Term;
import org.fmgroup.mediator.language.term.UtilTerm;


import java.util.ArrayList;
import java.util.List;

public class IteStatement implements Statement {

    private RawElement parent;

    public Term condition;
    public List<Statement> thenStmts = new ArrayList<>();
    public List<Statement> elseStmts = new ArrayList<>();

    @Override
    public RawElement fromContext(ParserRuleContext context) throws ValidationException {
        if (!(context instanceof MediatorLangParser.IteStatementContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "IteStatementContext", context.toString());
        }

        condition = UtilTerm.parse(((MediatorLangParser.IteStatementContext) context).condition, this);
        if (((MediatorLangParser.IteStatementContext) context).thenstmt != null) thenStmts.add(
                UtilStatement.parse(((MediatorLangParser.IteStatementContext) context).thenstmt, this)
        );
        if (((MediatorLangParser.IteStatementContext) context).thenstmts != null) {
            for (MediatorLangParser.StatementContext sc : ((MediatorLangParser.IteStatementContext) context).thenstmts.statement()) {
                thenStmts.add(UtilStatement.parse(sc, this));
            }
        }
        if (((MediatorLangParser.IteStatementContext) context).elsestmt != null) elseStmts.add(
                UtilStatement.parse(((MediatorLangParser.IteStatementContext) context).elsestmt, this)
        );
        if (((MediatorLangParser.IteStatementContext) context).elsestmts != null) {
            for (MediatorLangParser.StatementContext sc : ((MediatorLangParser.IteStatementContext) context).elsestmts.statement()) {
                elseStmts.add(UtilStatement.parse(sc, this));
            }
        }
        return this.validate();
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
                for (Statement s : elseStmts) rel +=  UtilCode.addIndent(s.toString(), 1) + "\n";
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
    public RawElement setParent(RawElement parent)  {
        this.parent = parent;
        return this;
    }

    @Override
    public RawElement clone(RawElement parent) throws ValidationException {
        IteStatement nis = new IteStatement();
        nis.setParent(parent);
        nis.condition = (Term) this.condition.clone(nis);
        for (Statement st : this.thenStmts) nis.thenStmts.add((Statement) st.clone(nis));
        for (Statement st : this.elseStmts) nis.elseStmts.add((Statement) st.clone(nis));
        return nis.validate();
    }

    @Override
    public RawElement validate() throws ValidationException {
        // TODO
        return this;
    }
}
