package org.fmgroup.mediator.language.entity.automaton;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.generator.framework.UtilCode;
import org.fmgroup.mediator.language.MediatorLangParser;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.statement.Statement;
import org.fmgroup.mediator.language.statement.SynchronizingStatement;
import org.fmgroup.mediator.language.term.Term;

import java.util.ArrayList;
import java.util.List;

public class TransitionSingle implements Transition {

    private RawElement parent;

    public Term guard;
    public List<Statement> statements = new ArrayList<>();
    public boolean isInternal = true;

    @Override
    public RawElement fromContext(ParserRuleContext context) throws ValidationException {
        if (!(context instanceof MediatorLangParser.TransitionSingleContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "TransitionSingleContext", context.toString());
        }

        this.guard = Term.parse(((MediatorLangParser.TransitionSingleContext) context).term(), this);

        if (((MediatorLangParser.TransitionSingleContext) context).statement() != null) {
            this.statements.add(Statement.parse(((MediatorLangParser.TransitionSingleContext) context).statement(), this));
        } else {
            for (MediatorLangParser.StatementContext sc : ((MediatorLangParser.TransitionSingleContext) context).statements().statement()) {
                this.statements.add(Statement.parse(sc, this));
            }
        }
        return this.validate();
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
    public RawElement setParent(RawElement parent)  {
        this.parent = parent;
        return this;
    }

    @Override
    public RawElement clone(RawElement parent) throws ValidationException {
        TransitionSingle nt = new TransitionSingle();
        nt.setParent(parent);
        nt.isInternal = this.isInternal;
        nt.guard = (Term) this.guard.clone(nt);
        for (Statement st : this.statements) {
            nt.statements.add((Statement) st.clone(nt));
        }
        return nt;
    }

    @Override
    public RawElement validate() throws ValidationException {
        // TODO finish it

        for (Statement st : statements) {
            if (st instanceof SynchronizingStatement) this.isInternal = false;
        }
        return this;
    }

    @Override
    public Term getGuard() {
        return this.guard;
    }
}
