package org.fmgroup.mediator.language.statement;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.generated.MediatorLangParser;
import org.fmgroup.mediator.language.term.Term;
import org.fmgroup.mediator.language.type.Type;

import java.util.Map;


public class AssignmentStatement implements Statement {

    private Term expr;
    private Term target;
    private RawElement parent;

    public Term getTarget() {
        return target;
    }

    public AssignmentStatement setTarget(Term target) throws ValidationException {
        this.target = target;
        target.setParent(this);
        return this;
    }

    public Term getExpr() {
        return expr;
    }

    public AssignmentStatement setExpr(Term expr) throws ValidationException {
        this.expr = expr;
        expr.setParent(this);
        return this;
    }

    @Override
    public AssignmentStatement fromContext(ParserRuleContext context, RawElement parent) throws ValidationException {
        if (!(context instanceof MediatorLangParser.AssignmentStatementContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "AssignmentStatementContext", context.toString());
        }

        setParent(parent);
        setExpr(
                Term.parse(
                        ((MediatorLangParser.AssignmentStatementContext) context).expr,
                        this
                )
        );

        if (((MediatorLangParser.AssignmentStatementContext) context).target != null)
            setTarget(
                    Term.parse(
                            ((MediatorLangParser.AssignmentStatementContext) context).target,
                            this
                    )
            );

        return this;
    }

    @Override
    public String toString() {
        if (target != null)
            return target.toString() + " = " + expr.toString() + ";";
        else return expr.toString() + ";";
    }

    @Override
    public boolean equals(Object obj) {
        return
                this.toString().equals(obj.toString()) &&
                        obj instanceof Statement;
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
        AssignmentStatement nas = new AssignmentStatement();
        nas.setParent(parent);

        nas.setExpr(getExpr().copy(nas));
        if (target != null)
            nas.setTarget(this.getTarget().copy(nas));

        return nas;
    }

    @Override
    public Statement refactor(Map<String, Type> typeRewriteMap, Map<String, Term> termRewriteMap) throws ValidationException {
        setExpr(getExpr().refactor(typeRewriteMap, termRewriteMap));
        if (getTarget() != null)
            setTarget(getTarget().refactor(typeRewriteMap, termRewriteMap));

        return this;
    }
}
