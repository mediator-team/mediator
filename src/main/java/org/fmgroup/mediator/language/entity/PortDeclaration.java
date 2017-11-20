package org.fmgroup.mediator.language.entity;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.fmgroup.mediator.language.MediatorLangParser;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.scope.Declaration;
import org.fmgroup.mediator.language.type.Type;
import org.fmgroup.mediator.language.type.UtilType;

import java.util.ArrayList;
import java.util.List;

enum PortDirection {
    IN("in"),
    OUT("out");

    private String value;

    PortDirection(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}

public class PortDeclaration implements RawElement, Declaration {

    public static String [] adjointVariables = {"value", "reqRead", "reqWrite"};

    public List<String> names = new ArrayList<>();
    public PortDirection direction;
    public Type type;

    public RawElement parent;

    public PortDeclaration() {}

    @Override
    public RawElement fromContext(ParserRuleContext context) throws ValidationException {
        if (!(context instanceof MediatorLangParser.PortsDeclContext)) {
            throw ValidationException.IncompatibleContextType(
                    this.getClass(),
                    "PortsDeclContext", context.toString()
            );
        }

        for (TerminalNode portName : ((MediatorLangParser.PortsDeclContext) context).ID()) {
            if (names.contains(portName.getText()) || this.getCurrentScope().existsDeclaration(portName.getText())) {
                throw ValidationException.DumplicatedIdentifier(portName.getText(), "symbol");
            }

            names.add(portName.getText());
        }

        if (((MediatorLangParser.PortsDeclContext) context).direction.getText().equals("IN")) {
            this.direction = PortDirection.IN;
        } else {
            this.direction = PortDirection.OUT;
        }

        this.type = UtilType.parse(((MediatorLangParser.PortsDeclContext) context).type(), this);

        return this;
    }

    @Override
    public String toString() {
        return String.format(
                "%s: %s %s",
                String.join(", ", names),
                direction.toString(),
                type.toString()
        );
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
    public RawElement clone(RawElement parent) throws ValidationException {
        PortDeclaration newdecl = new PortDeclaration();
        newdecl.names = new ArrayList<>(names);
        newdecl.direction = direction;
        newdecl.type = (Type) type.clone(newdecl);
        newdecl.validate();

        return newdecl;
    }

    @Override
    public RawElement validate() throws ValidationException {
        return this;
    }


    @Override
    public int size() {
        return names.size();
    }

    @Override
    public String getIdentifier(int index) {
        return names.get(index);
    }
}