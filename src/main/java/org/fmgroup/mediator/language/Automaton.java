package org.fmgroup.mediator.language;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.generator.framework.UtilCode;
import org.fmgroup.mediator.language.transition.Transition;
import org.fmgroup.mediator.language.transition.TransitionGroup;
import org.fmgroup.mediator.language.transition.TransitionSingle;
import org.fmgroup.mediator.language.transition.UtilTransition;

import java.util.ArrayList;
import java.util.List;

public class Automaton implements InterfacedElement {
    private RawElement parent = null;

    public CompTemplate compTemplate = null;
    public CompInterface compInterface = null;
    public List<VariableDeclaration> localVars = new ArrayList<>();
    public List<Transition> transitions = new ArrayList<>();
    public String name;

    @Override
    public RawElement fromContext(ParserRuleContext context) throws ValidationException{
        if (!(context instanceof MediatorLangParser.AutomatonContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "AutomatonContext", context.toString());
        }

        MediatorLangParser.AutomatonContext automaton = (MediatorLangParser.AutomatonContext) context;

        name = ((MediatorLangParser.AutomatonContext) context).name.getText();
        compInterface = (CompInterface) new CompInterface()
                .setParent(this)
                .fromContext(
                        ((MediatorLangParser.AutomatonContext) context).compInterface()
                );

        if (((MediatorLangParser.AutomatonContext) context).compTemplate() != null) {
            compTemplate = (CompTemplate) new CompTemplate()
                    .setParent(this)
                    .fromContext(((MediatorLangParser.AutomatonContext) context).compTemplate());
        }

        // step 1. analyze local variables
        for (MediatorLangParser.VariableSegmentContext vsc : automaton.variableSegment()) {
            for (MediatorLangParser.LocalVariableDefContext lvc : vsc.localVariableDef()) {
                this.localVars.add((VariableDeclaration) new VariableDeclaration().setParent(this).fromContext(lvc));
            }
        }

        // step 2. analyze transitions
        for (MediatorLangParser.TransitionSegmentContext tsc : automaton.transitionSegment()) {
            for (MediatorLangParser.TransitionContext tc : tsc.transition()) {
                transitions.add(UtilTransition.parse(tc, this));
            }
        }

        return this.validate();
    }

    @Override
    public String toString() {
        String template = compTemplate == null? "" : compTemplate.toString();
        if (template.length() > 0) template = "<" + template + "> ";
        String rel = String.format("automaton %s%s (%s) {\n", template, name, compInterface.toString());
        if (localVars.size() > 0) {
            rel += UtilCode.addIndent("variables {\n", 1);
            for (VariableDeclaration var : localVars) {
                rel += UtilCode.addIndent(var.toString(), 2) + "\n";
            }
            rel += UtilCode.addIndent("}\n", 1);
        }
        if (transitions.size() > 0) {
            rel += UtilCode.addIndent("transitions {\n", 1);
            for (Transition t : transitions) {
                rel += UtilCode.addIndent(t.toString(), 2) + "\n";
            }
            rel += UtilCode.addIndent("}\n", 1);
        }
        rel += "}\n";
        return rel;
    }

    @Override
    public RawElement getParent() {
        return this.parent;
    }

    @Override
    public RawElement setParent(RawElement parent) {
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
    public CompInterface getInterface() {
        return compInterface;
    }

    @Override
    public CompTemplate getTemplate() {
        return compTemplate;
    }

}
