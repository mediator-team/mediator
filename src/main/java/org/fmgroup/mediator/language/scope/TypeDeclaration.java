package org.fmgroup.mediator.language.scope;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.generated.MediatorLangParser;
import org.fmgroup.mediator.language.type.Type;

import java.util.ArrayList;
import java.util.List;


public class TypeDeclaration implements RawElement, Declaration {

    private RawElement parent;
    private List<String> identifiers = new ArrayList<>();
    private Type type;
    private boolean isTypedef = true;

    public Type getType() {
        return type;
    }

    public TypeDeclaration setType(Type type) {
        this.type = type;
        type.setParent(this);
        return this;
    }

    public boolean isTypedef() {
        return isTypedef;
    }

    public TypeDeclaration setTypedef(boolean typedef) {
        isTypedef = typedef;
        return this;
    }

    @Override
    public TypeDeclaration fromContext(ParserRuleContext context, RawElement parent) throws ValidationException {
        if (!(context instanceof MediatorLangParser.TypedefContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "TypedefContext", context.toString());
        }

        setParent(parent);
        for (TerminalNode tn : ((MediatorLangParser.TypedefContext) context).ID()) {
            addIdentifier(tn.getText());
        }

        setType(Type.parse(((MediatorLangParser.TypedefContext) context).type(), this));

        return this;
    }

    @Override
    public String toString() {
        if (isTypedef) {
            return String.format(
                    "typedef %s as %s",
                    type.toString(),
                    String.join(", ", identifiers)
            );
        } else {
            return String.format(
                    "%s : %s",
                    String.join(", ", identifiers),
                    type.toString()
            );
        }
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
    public int size() {
        return identifiers.size();
    }

    @Override
    public List<String> getIdentifiers() {
        return identifiers;
    }

    public TypeDeclaration setIdentifiers(List<String> identifiers) throws ValidationException {
        this.identifiers = new ArrayList<>();
        for (String identifier : identifiers) addIdentifier(identifier);
        return this;
    }
}
