package org.fmgroup.mediator.language.term;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.generated.MediatorLangParser;
import org.fmgroup.mediator.language.type.Type;

import java.util.Map;

public class ElementTerm implements Term {

    private RawElement parent;

    private Term container;
    private Term key;

    @Override
    public ElementTerm fromContext(ParserRuleContext context, RawElement parent) throws ValidationException {
        if (!(context instanceof MediatorLangParser.ElementTermContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "ElementTermContext", context.toString());
        }

        setParent(parent);
        setContainer(Term.parse(((MediatorLangParser.ElementTermContext) context).container, this));
        setKey(Term.parse(((MediatorLangParser.ElementTermContext) context).key, this));

        return this;
    }

    @Override
    public String toString() {
        return String.format(
                container.getPrecedence() < this.getPrecedence() ? "(%s)[%s]" : "%s[%s]",
                container.toString(),
                key.toString()
        );
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

    public Term getContainer() {
        return container;
    }

    public ElementTerm setContainer(Term container) {
        this.container = container;
        container.setParent(this);
        return this;
    }

    public Term getKey() {
        return key;
    }

    public ElementTerm setKey(Term key) {
        this.key = key;
        key.setParent(this);
        return this;
    }

    @Override
    public ElementTerm copy(RawElement parent) throws ValidationException {
        ElementTerm net = new ElementTerm();
        net.setParent(parent);
        net.setContainer(this.container.copy(net));
        net.setKey(this.key.copy(net));

        return net;
    }

    @Override
    public ElementTerm refactor(Map<String, Type> typeRewriteMap, Map<String, Term> termRewriteMap) throws ValidationException {
        setContainer(getContainer().refactor(typeRewriteMap, termRewriteMap));
        setKey(getKey().refactor(typeRewriteMap, termRewriteMap));
        return this;
    }

    @Override
    public Type getType() {
        return null;
    }

    @Override
    public int getPrecedence() {
        return 13;
    }
}
