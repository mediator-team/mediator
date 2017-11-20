package org.fmgroup.mediator.language.term;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.MediatorLangParser;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.type.Type;

public class ElementTerm implements Term {

    private RawElement parent;

    public Term container;
    public Term key;

    @Override
    public RawElement fromContext(ParserRuleContext context) throws ValidationException {
        if (!(context instanceof MediatorLangParser.ElementTermContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "ElementTermContext", context.toString());
        }

        this.container = Term.parse(((MediatorLangParser.ElementTermContext) context).container, this);
        this.key = Term.parse(((MediatorLangParser.ElementTermContext) context).key, this);

        return this.validate();
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
    public RawElement setParent(RawElement parent)  {
        this.parent = parent;
        return this;
    }

    @Override
    public RawElement clone(RawElement parent) throws ValidationException {
        ElementTerm net = new ElementTerm();
        net.setParent(parent);
        net.container = (Term) this.container.clone(net);
        net.key = (Term) this.key.clone(net);

        return net.validate();
    }

    @Override
    public Type getType() {
        return null;
    }

    @Override
    public int getPrecedence() {
        return 13;
    }

    @Override
    public RawElement validate() throws ValidationException {
        // TODO
        return this;
    }
}
