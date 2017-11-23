package org.fmgroup.mediator.language.entity.automaton;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.common.UtilCode;
import org.fmgroup.mediator.language.MediatorLangParser;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.term.BinaryOperatorTerm;
import org.fmgroup.mediator.language.term.EnumBinaryOperator;
import org.fmgroup.mediator.language.term.Term;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TransitionGroup implements Transition, RawElement {

    private RawElement parent;
    private List<Transition> transitions = new ArrayList<>();

    public List<Transition> getTransitions() {
        return transitions;
    }

    public TransitionGroup setTransitions(List<Transition> transitions) {
        this.transitions = new ArrayList<>();
        transitions.forEach(this::addTransition);
        return this;
    }

    public TransitionGroup addTransition(Transition transition) {
        this.transitions.add(transition);
        transition.setParent(this);
        return this;
    }

    @Override
    public TransitionGroup fromContext(ParserRuleContext context, RawElement parent) throws ValidationException {
        if (!(context instanceof MediatorLangParser.TransitionGroupContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "TransitionGroupContext", context.toString());
        }

        setParent(parent);
        for (MediatorLangParser.TransitionContext tc : ((MediatorLangParser.TransitionGroupContext) context).transition()) {
            addTransition(Transition.parse(tc, this));
        }

        return this;
    }

    @Override
    public String toString() {
        return String.format(
                "group {\n%s\n}",
                UtilCode.addIndent(
                        getTransitions()
                            .stream()
                            .map(Object::toString)
                            .collect(Collectors.joining("\n")),
                        1
                )
        );
    }

    @Override
    public RawElement getParent() {
        return parent;
    }

    @Override
    public TransitionGroup setParent(RawElement parent) {
        this.parent = parent;
        return this;
    }

    @Override
    public TransitionGroup copy(RawElement parent) throws ValidationException {
        TransitionGroup transG = new TransitionGroup();
        transG.setParent(parent);
        for (Transition t : getTransitions()) {
            transG.addTransition((Transition) t.copy(transG));
        }

        return transG;
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
}
