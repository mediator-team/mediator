package org.fmgroup.mediator.language.transition;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.generator.framework.UtilCode;
import org.fmgroup.mediator.language.Automaton;
import org.fmgroup.mediator.language.MediatorLangParser;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.term.BinaryOperatorTerm;
import org.fmgroup.mediator.language.term.EnumBinaryOperator;
import org.fmgroup.mediator.language.term.Term;

import java.util.ArrayList;
import java.util.List;

public class TransitionGroup implements Transition {

    private RawElement parent;
    public List<Transition> transitions = new ArrayList<>();

    @Override
    public RawElement fromContext(ParserRuleContext context) throws ValidationException {
        if (!(context instanceof MediatorLangParser.TransitionGroupContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "TransitionGroupContext", context.toString());
        }

        for (MediatorLangParser.TransitionContext tc : ((MediatorLangParser.TransitionGroupContext) context).transition()) {
            this.transitions.add(UtilTransition.parse(tc, this));
        }

        return this.validate();
    }

    @Override
    public String toString() {
        String rel = "group {\n";
        for (Transition t : transitions) {
            rel += UtilCode.addIndent(t.toString(), 1) + "\n";
        }
        rel += "}";
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
    public RawElement clone(RawElement parent) {
        return null;
    }

    @Override
    public RawElement validate() throws ValidationException {
        // TODO
        return this;
    }

    @Override
    public Term getGuard() throws ValidationException {
        Term guard = null;
        for (Transition t : this.transitions) {
            if (guard == null) guard = t.getGuard();
            else {
                guard = new BinaryOperatorTerm()
                        .setOpr(EnumBinaryOperator.LOR)
                        .setLeft(guard)
                        .setRight(t.getGuard());
            }
        }
        return guard;
    }

    @Override
    public Automaton getAutomaton() {
        RawElement pointer = this;
        while (pointer != null && !(pointer instanceof Automaton)) {
            pointer = pointer.getParent();
        }

        return (Automaton) pointer;
    }
}
