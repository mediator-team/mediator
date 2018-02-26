package org.fmgroup.mediator.language.entity.automaton;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.common.UtilCode;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.generated.MediatorLangParser;
import org.fmgroup.mediator.language.term.BinaryOperatorTerm;
import org.fmgroup.mediator.language.term.EnumBinaryOperator;
import org.fmgroup.mediator.language.term.Term;
import org.fmgroup.mediator.language.type.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TransitionGroup implements Transition, RawElement {

    private RawElement parent;
    private List<Transition> transitions = new ArrayList();

    public List<Transition> getTransitions() {
        return transitions;
    }

    public TransitionGroup setTransitions(List<Transition> transitions) throws ValidationException {
        this.transitions = new ArrayList();
        for (Transition t:transitions) {
            addTransition(t);
        }
        return this;
    }

    public TransitionGroup addTransition(Transition transition) throws ValidationException {
        if (transition instanceof TransitionGroup) {
            throw ValidationException.UnexpectedElement(
                    this.getClass(),
                    transition.getClass(),
                    "TransitionSingle",
                    "sub-transitions"
            );
        }

        this.transitions.add((TransitionSingle) transition);
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

    @Override
    public TransitionGroup refactor(Map<String, Type> typeRewriteMap, Map<String, Term> termRewriteMap, RawElement parent) throws ValidationException {
        setParent(parent);
        for (int i = 0; i < transitions.size(); i ++) {
            transitions.set(i, transitions.get(i).refactor(typeRewriteMap, termRewriteMap, this));
        }
        return this;
    }
}
