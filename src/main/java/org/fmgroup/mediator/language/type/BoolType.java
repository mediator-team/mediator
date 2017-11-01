package org.fmgroup.mediator.language.type;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;

public class BoolType implements Type, RawElement {

    private RawElement parent = null;

    @Override
    public String getName() {
        return "bool";
    }

    @Override
    public RawElement fromContext(ParserRuleContext context) throws ValidationException {
        return this.validate();
    }

    @Override
    public String toString() {
        return "bool";
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
    public RawElement clone(RawElement parent) throws ValidationException {
        return new BoolType().setParent(parent).validate();
    }

    @Override
    public RawElement validate() throws ValidationException {
        // TODO
        return this;
    }
}
