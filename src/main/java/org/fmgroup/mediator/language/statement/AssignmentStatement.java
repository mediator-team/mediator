package org.fmgroup.mediator.language.statement;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.*;
import org.fmgroup.mediator.language.term.Term;
import org.fmgroup.mediator.language.term.UtilTerm;
import org.fmgroup.mediator.language.transition.Transition;


public class AssignmentStatement implements Statement {

    public Term expr;
    public Term target;
    private RawElement parent;

    @Override
    public RawElement fromContext(ParserRuleContext context) throws ValidationException {
        if (!(context instanceof MediatorLangParser.AssignmentStatementContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "AssignmentStatementContext", context.toString());
        }

        expr = UtilTerm.parse(
                ((MediatorLangParser.AssignmentStatementContext) context).expr,
                this
        );

        if (((MediatorLangParser.AssignmentStatementContext) context).target != null)
            target = UtilTerm.parse(
                    ((MediatorLangParser.AssignmentStatementContext) context).target,
                    this
            );

        return this.validate();
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
    public RawElement setParent(RawElement parent)  {
        this.parent = parent;
        return this;
    }

    @Override
    public RawElement clone(RawElement parent) throws ValidationException {
        AssignmentStatement nas = new AssignmentStatement();
        nas.setParent(parent);
        nas.expr = (Term) this.expr.clone(nas);
        nas.target = this.target == null ? null : (Term) this.target.clone(nas);
        return nas.validate();
    }

    @Override
    public RawElement validate() throws ValidationException {

        /*
        An assignment statement is valid iff.
        TODO 1. its target is assignable
        2. it belongs to an automaton or another statement (e.g. an ite statement)
        3. both term is valid (assured by their own validate function
        */

        if (
                !(parent instanceof Automaton) &&
                        !(parent instanceof Statement) &&
                        !(parent instanceof Transition)
                ) {
            throw ValidationException.UnexpectedElement(this.getClass(), parent.getClass(),"Automaton/Statement", "parent");
        }
        return this;
    }
}
