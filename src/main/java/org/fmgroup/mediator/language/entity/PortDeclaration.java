package org.fmgroup.mediator.language.entity;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.generated.MediatorLangParser;
import org.fmgroup.mediator.language.scope.Declaration;
import org.fmgroup.mediator.language.type.Type;

import java.util.ArrayList;
import java.util.List;

public class PortDeclaration implements RawElement, Declaration {

    private List<String> identifiers = new ArrayList<>();
    private PortDirection direction;
    private Type type;
    private RawElement parent;

    public PortDeclaration() {
    }

    public PortDirection getDirection() {
        return direction;
    }

    public PortDeclaration setDirection(PortDirection direction) {
        this.direction = direction;
        return this;
    }

    public Type getType() {
        return type;
    }

    public PortDeclaration setType(Type type) {
        this.type = type;
        type.setParent(this);
        return this;
    }

    @Override
    public PortDeclaration fromContext(ParserRuleContext context, RawElement parent) throws ValidationException {
        if (!(context instanceof MediatorLangParser.PortsDeclContext)) {
            throw ValidationException.IncompatibleContextType(
                    this.getClass(),
                    "PortsDeclContext", context.toString()
            );
        }

        setParent(parent);
        for (TerminalNode portName : ((MediatorLangParser.PortsDeclContext) context).ID()) {
            if (identifiers.contains(portName.getText()) || this.getCurrentScope().existsDeclaration(portName.getText())) {
                throw ValidationException.DumplicatedIdentifier(portName.getText(), "symbol");
            }

            addIdentifier(portName.getText());
        }

        if (((MediatorLangParser.PortsDeclContext) context).direction.getText().equals("IN")) {
            setDirection(PortDirection.IN);
        } else {
            setDirection(PortDirection.OUT);
        }

        setType(Type.parse(((MediatorLangParser.PortsDeclContext) context).type(), this));

        return this;
    }

    @Override
    public String toString() {
        return String.format(
                "%s: %s %s",
                String.join(", ", identifiers),
                direction.toString(),
                type.toString()
        );
    }

    @Override
    public RawElement getParent() {
        return this.parent;
    }

    @Override
    public PortDeclaration setParent(RawElement parent) {
        this.parent = parent;
        return this;
    }

    @Override
    public PortDeclaration copy(RawElement parent) throws ValidationException {
        PortDeclaration newdecl = new PortDeclaration();
        newdecl.setParent(parent);

        newdecl.setIdentifiers(identifiers);
        newdecl.setType(type.copy(newdecl));
        newdecl.setDirection(getDirection());

        return newdecl;
    }


    @Override
    public int size() {
        return identifiers.size();
    }

    @Override
    public List<String> getIdentifiers() {
        return identifiers;
    }

    public PortDeclaration setIdentifiers(List<String> identifiers) throws ValidationException {
        this.identifiers = new ArrayList<>();

        for (String identifier : identifiers) {
            addIdentifier(identifier);
        }
        return this;
    }
}