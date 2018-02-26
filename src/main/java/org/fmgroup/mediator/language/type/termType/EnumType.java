package org.fmgroup.mediator.language.type.termType;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.generated.MediatorLangParser;
import org.fmgroup.mediator.language.term.EnumValue;
import org.fmgroup.mediator.language.term.Term;
import org.fmgroup.mediator.language.type.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EnumType implements Type {

    private RawElement parent;
    private List<String> items = new ArrayList<>();

    public List<String> getItems() {
        return items;
    }

    public EnumType setItems(List<String> items) throws ValidationException {
        this.items = new ArrayList<>();
        for (String item : items) addItem(item);
        return this;
    }

    public EnumType addItem(String item) throws ValidationException {
        if (getItems().contains(item)) {
            throw ValidationException.DumplicatedIdentifier(item, "enum item");
        }

        items.add(item);
        return this;
    }

    @Override
    public Term getInitValue() throws ValidationException {
        return new EnumValue().setParent(this)
                .setReference(this)
                .setIdentifier(getItems().get(0));
    }

    @Override
    public EnumType fromContext(ParserRuleContext context, RawElement parent) throws ValidationException {
        if (!(context instanceof MediatorLangParser.EnumTypeContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "EnumTypeContext", context.toString());
        }

        setItems(((MediatorLangParser.EnumTypeContext) context).ID().stream().map(
                TerminalNode::getText
        ).collect(Collectors.toList()));

        return this;
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
    public EnumType setParent(RawElement parent) {
        this.parent = parent;
        return this;
    }

    @Override
    public EnumType copy(RawElement parent) throws ValidationException {
        EnumType net = new EnumType();
        net.setParent(parent);
        net.setItems(getItems());

        return net;
    }

    @Override
    public Type refactor(Map<String, Type> typeRewriteMap, Map<String, Term> termRewriteMap) throws ValidationException {
        return this;
    }
}
