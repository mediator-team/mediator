package org.fmgroup.mediator.language.entity.automaton;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.generator.framework.UtilCode;
import org.fmgroup.mediator.language.*;
import org.fmgroup.mediator.language.entity.EntityInterface;
import org.fmgroup.mediator.language.entity.Entity;
import org.fmgroup.mediator.language.scope.DeclarationCollection;
import org.fmgroup.mediator.language.scope.Scope;
import org.fmgroup.mediator.language.scope.VariableDeclaration;
import org.fmgroup.mediator.language.scope.VariableDeclarationCollection;

import java.util.ArrayList;
import java.util.List;

public class Automaton implements Entity, Scope, Templated {
    private RawElement parent = null;

    public Template template = null;
    public EntityInterface entityInterface = null;
    public VariableDeclarationCollection localVars = new VariableDeclarationCollection();
    public List<Transition> transitions = new ArrayList<>();
    public String name;

    @Override
    public RawElement fromContext(ParserRuleContext context) throws ValidationException{
        if (!(context instanceof MediatorLangParser.AutomatonContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "AutomatonContext", context.toString());
        }

        MediatorLangParser.AutomatonContext automaton = (MediatorLangParser.AutomatonContext) context;

        name = ((MediatorLangParser.AutomatonContext) context).name.getText();

        if (((MediatorLangParser.AutomatonContext) context).template() != null) {
            template = new Template();
            template.parse(((MediatorLangParser.AutomatonContext) context).template(), this);
        }

        entityInterface = new EntityInterface();
        entityInterface.parse(((MediatorLangParser.AutomatonContext) context).entityInterface(), this);

        // TODO rewrite it using localVars.parse(...)
        // step 1. analyze local variables
        for (MediatorLangParser.VariableSegmentContext vsc : automaton.variableSegment()) {
            for (MediatorLangParser.LocalVariableDefContext lvc : vsc.localVariableDef()) {
                this.localVars.vardecls.add((VariableDeclaration) new VariableDeclaration().parse(lvc, this));
            }
        }

        // step 2. analyze transitions
        for (MediatorLangParser.TransitionSegmentContext tsc : automaton.transitionSegment()) {
            for (MediatorLangParser.TransitionContext tc : tsc.transition()) {
                transitions.add(Transition.parse(tc, this));
            }
        }

        return this;
    }

    @Override
    public String toString() {
        String template = this.template == null? "" : this.template.toString();
        if (template.length() > 0) template = "<" + template + "> ";
        String rel = String.format("automaton %s%s (%s) {\n", template, name, entityInterface.toString());

        rel += UtilCode.addIndent(localVars.toString(), 1);

        if (transitions.size() > 0) {
            rel += UtilCode.addIndent("transitions {\n", 1);
            for (Transition t : transitions) {
                rel += UtilCode.addIndent(t.toString(), 2) + "\n";
            }
            rel += UtilCode.addIndent("}\n", 1);
        }
        rel += "}";
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
    public EntityInterface getInterface() {
        return entityInterface;
    }

    @Override
    public Template getTemplate() {
        return template;
    }

    @Override
    public List<DeclarationCollection> getDeclarations() {
        List<DeclarationCollection> result = new ArrayList<>();

        if (template != null) result.add(template);
        if (entityInterface != null) result.add(entityInterface);
        if (localVars != null) result.add(localVars);

        return result;
    }

}
