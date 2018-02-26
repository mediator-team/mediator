package org.fmgroup.mediator.language.scope;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.generated.MediatorLangParser;
import org.fmgroup.mediator.language.type.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VariableDeclaration implements RawElement, Declaration {

    private RawElement parent = null;
    private List<String> identifiers = new ArrayList<>();
    private Type type = null;

    public Type getType() {
        return type;
    }

    public VariableDeclaration setType(Type type) {
        this.type = type;
        type.setParent(this);
        return this;
    }

    @Override
    public VariableDeclaration fromContext(ParserRuleContext context, RawElement parent) throws ValidationException {
        if (!(context instanceof MediatorLangParser.LocalVariableDefContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "LocalVariableDefContext", context.toString());
        }

        setParent(parent);
        for (TerminalNode tn : ((MediatorLangParser.LocalVariableDefContext) context).ID()) {
            addIdentifier(tn.getText());
        }

        setType(Type.parse(((MediatorLangParser.LocalVariableDefContext) context).type(), this));
        return this;
    }

    @Override
    public String toString() {
        if (identifiers.size() == 0) return "";
        else
            return
                    String.join(", ", getIdentifiers()) + ": " + type.toString();
    }

    @Override
    public RawElement getParent() {
        return parent;
    }

    @Override
    public VariableDeclaration setParent(RawElement parent) {
        this.parent = parent;
        return this;
    }

    @Override
    public VariableDeclaration copy(RawElement parent) throws ValidationException {
        VariableDeclaration nvd = new VariableDeclaration();

        nvd.setParent(parent);
        nvd.setIdentifiers(identifiers);
        nvd.setType(this.type.copy(nvd));

        return nvd;
    }

    @Override
    public int size() {
        return identifiers.size();
    }

    @Override
    public List<String> getIdentifiers() {
        return identifiers;
    }

    public VariableDeclaration setIdentifiers(List<String> identifiers) {
        this.identifiers = identifiers;
        return this;
    }

    public VariableDeclaration addPrefix(String prefix) {
        setIdentifiers(
                getIdentifiers().stream().map(
                        s -> prefix + s
                ).collect(Collectors.toList())
        );

        return this;
    }
}
