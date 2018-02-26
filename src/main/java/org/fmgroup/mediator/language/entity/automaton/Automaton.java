package org.fmgroup.mediator.language.entity.automaton;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.common.UtilCode;
import org.fmgroup.mediator.language.*;
import org.fmgroup.mediator.language.entity.Entity;
import org.fmgroup.mediator.language.entity.EntityInterface;
import org.fmgroup.mediator.language.entity.PortDeclaration;
import org.fmgroup.mediator.language.generated.MediatorLangParser;
import org.fmgroup.mediator.language.property.PropertyCollection;
import org.fmgroup.mediator.language.scope.DeclarationCollection;
import org.fmgroup.mediator.language.scope.Scope;
import org.fmgroup.mediator.language.scope.VariableDeclaration;
import org.fmgroup.mediator.language.scope.VariableDeclarationCollection;
import org.fmgroup.mediator.language.term.Term;
import org.fmgroup.mediator.language.type.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Automaton implements Entity, Scope, Templated {

    private RawElement parent = null;
    private Template template = null;
    private EntityInterface entityInterface = null;
    private VariableDeclarationCollection localVars = new VariableDeclarationCollection().setParent(this);
    private List<Transition> transitions = new ArrayList<>();

    public PropertyCollection getProperties() {
        return properties;
    }

    public Automaton setProperties(PropertyCollection properties) {
        this.properties = properties;
        properties.setParent(this);
        return this;
    }

    private PropertyCollection properties = null;
    private String name;

    public Meta getMeta() {
        return meta;
    }

    public Automaton setMeta(Meta meta) {
        this.meta = meta;
        meta.setParent(this);
        return this;
    }

    private Meta meta = null;

    public EntityInterface getEntityInterface() {
        return entityInterface;
    }

    public Automaton setEntityInterface(EntityInterface entityInterface) {
        this.entityInterface = entityInterface;
        entityInterface.setParent(this);
        return this;
    }

    public VariableDeclarationCollection getLocalVars() {
        return localVars;
    }

    public Automaton setLocalVars(VariableDeclarationCollection localVars) {
        this.localVars = localVars;
        localVars.setParent(this);
        return this;
    }

    public List<Transition> getTransitions() {
        return transitions;
    }

    public Automaton addTransition(Transition transition) {
        this.transitions.add(transition);
        transition.setParent(this);
        return this;
    }

    public Automaton setTransitions(List<Transition> transitions) {
        this.transitions = new ArrayList<>();
        transitions.forEach(this::addTransition);
        return this;
    }

    public Transition getTransition(int i) {
        return transitions.get(i);
    }

    @Override
    public String getName() {
        return name;
    }

    public Automaton setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public Automaton fromContext(ParserRuleContext context, RawElement parent) throws ValidationException {
        if (!(context instanceof MediatorLangParser.AutomatonContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "AutomatonContext", context.toString());
        }

        MediatorLangParser.AutomatonContext automaton = (MediatorLangParser.AutomatonContext) context;

        setParent(parent);
        setName(((MediatorLangParser.AutomatonContext) context).name.getText());

        if (((MediatorLangParser.AutomatonContext) context).template() != null) {
            setTemplate(
                    new Template().fromContext(((MediatorLangParser.AutomatonContext) context).template(), this)
            );
        }

        setEntityInterface(
                new EntityInterface()
                        .fromContext(((MediatorLangParser.AutomatonContext) context).entityInterface(), this)
        );

        // TODO rewrite it using localVars.parse(...)
        // step 1. analyze local variables
        for (MediatorLangParser.VariableSegmentContext vsc : automaton.variableSegment()) {
            for (MediatorLangParser.LocalVariableDefContext lvc : vsc.localVariableDef()) {
                this.localVars.addDeclaration(new VariableDeclaration().fromContext(lvc, this));
            }
        }

        // step 2. analyze transitions
        for (MediatorLangParser.TransitionSegmentContext tsc : automaton.transitionSegment()) {
            for (MediatorLangParser.TransitionContext tc : tsc.transition()) {
                transitions.add(Transition.parse(tc, this));
            }
        }

        if (((MediatorLangParser.AutomatonContext) context).meta() != null)
            setMeta(new Meta().fromContext(((MediatorLangParser.AutomatonContext) context).meta(), this));

        // step 3. analyze properties
        if (((MediatorLangParser.AutomatonContext) context).propertySegment().size() > 0) {
            this.setProperties(new PropertyCollection());
            for (MediatorLangParser.PropertySegmentContext pseg : ((MediatorLangParser.AutomatonContext) context).propertySegment()) {
                this.getProperties().fromContext(pseg, this);
            }
        }

        return this;
    }

    @Override
    public Automaton copy(RawElement parent) throws ValidationException {
        Automaton a = new Automaton();
        a.setParent(parent);

        a.setName(getName());
        if (getTemplate() != null)
            a.setTemplate(getTemplate().copy(a));

        a.setEntityInterface(getEntityInterface().copy(a));
        a.setLocalVars(getLocalVars().copy(a));

        List<Transition> transitions = new ArrayList<>();
        for (Transition t : getTransitions()) {
            transitions.add((Transition) t.copy(a));
        }

        a.setTransitions(transitions);
        if (getProperties() != null) a.setProperties(getProperties().copy(a));

        return a;
    }

    @Override
    public String toString() {
        String template = this.template == null ? "" : this.template.toString();
        if (template.length() > 0) template = "<" + template + "> ";
        String rel = String.format("automaton %s%s (%s) {\n", template, name, entityInterface.toString());

        rel += UtilCode.addIndent(localVars.toString(), 1);

        if (transitions.size() > 0) {
            rel += UtilCode.addIndent(
                    String.format(
                            "transitions {\n%s}\n",
                            UtilCode.addIndent(
                                    getTransitions().stream().map(
                                            transition -> transition.toString() + "\n"
                                    ).collect(Collectors.joining("")),
                                    1
                            )
                    ),
                    1
            );
        }

        if (this.properties != null)
            rel += UtilCode.addIndent(properties.toString(), 1);
        rel += "}";

        if (getMeta() != null) rel += " " + getMeta().toString();

        return rel;
    }

    @Override
    public RawElement getParent() {
        return this.parent;
    }

    @Override
    public Automaton setParent(RawElement parent) {
        this.parent = parent;
        return this;
    }

    @Override
    public EntityInterface getInterface() {
        return entityInterface;
    }

    @Override
    public Template getTemplate() {
        if (this.template == null) return new Template().setParent(this);
        return template;
    }

    @Override
    public Automaton refactor(Map<String, Type> typeRewriteMap, Map<String, Term> termRewriteMap) throws ValidationException {
        for (PortDeclaration portdecl : getEntityInterface().getDeclarationList()) {
            portdecl.setType(
                    portdecl.getType().refactor(typeRewriteMap, termRewriteMap)
            );
        }

        for (VariableDeclaration vardecl : getLocalVars().getDeclarationList()) {
            vardecl.setType(
                    vardecl.getType().refactor(typeRewriteMap, termRewriteMap)
            );
        }

        for (Transition t : getTransitions()) {
            t.refactor(typeRewriteMap, termRewriteMap, this);
        }

        return this;
    }

    @Override
    public Automaton setTemplate(Template template) {
        this.template = template;
        if (template != null) template.setParent(this);
        return this;
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
