package org.fmgroup.mediator.language.type;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.fmgroup.mediator.language.MediatorLangParser;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;

import java.util.ArrayList;
import java.util.List;

public class EnumType implements Type {

    private RawElement parent;

    public List<String> items = new ArrayList<>();

    @Override
    public RawElement fromContext(ParserRuleContext context) throws ValidationException {
        if (!(context instanceof MediatorLangParser.EnumTypeContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "EnumTypeContext", context.toString());
        }

        for (TerminalNode id : ((MediatorLangParser.EnumTypeContext) context).ID()) {
            items.add(id.getText());
        }
        return this.validate();
    }

    @Override
    public String toString() {
        return "enum { " + String.join(", ", items) + " }";
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
        EnumType net = new EnumType();
        net.setParent(parent);
        net.items = new ArrayList<>(this.items);

        return net.validate();
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public RawElement validate() throws ValidationException {
        // TODO
        return this;
    }
}
