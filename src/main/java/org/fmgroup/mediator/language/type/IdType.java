package org.fmgroup.mediator.language.type;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.fmgroup.mediator.language.MediatorLangParser;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.scope.Scope;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.scope.TypeDeclaration;

import java.util.ArrayList;
import java.util.List;

public class IdType implements Type {

    public RawElement parent = null;
    public List<String> scopeIdentifiers = new ArrayList<>();
    public String identifier;
    public TypeDeclaration reference = null;

    @Override
    public String getName() {
        return "id";
    }

    @Override
    public RawElement fromContext(ParserRuleContext context) throws ValidationException {
        if (!(context instanceof MediatorLangParser.IdTypeContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "IdTypeContext", context.toString());
        }

        this.identifier = ((MediatorLangParser.IdTypeContext) context).scopedID().identifier.getText();
        for (Token scope : ((MediatorLangParser.IdTypeContext) context).scopedID().scopes) {
            scopeIdentifiers.add(scope.getText());
        }

        // if this id contains scopeIdentifiers
        if (scopeIdentifiers.size() > 0) {
            // TODO
        } else {
            List<Scope> scopes = this.getScopes();
            for (Scope scope : scopes) {
                this.reference = scope.getType(this);
                if (this.reference != null) break;
            }
        }

        if (this.reference == null) {
            throw ValidationException.UnknownIdentifier(this.toString(), "type");
        }

        return this.validate();
    }

    @Override
    public String toString() {
        if (scopeIdentifiers.size() > 0) {
            return String.join(".", scopeIdentifiers) + "." + identifier;
        } else {
            return identifier;
        }
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
        return new IdType().setIdentifier(this.identifier).setParent(parent).validate();
    }

    public IdType setIdentifier(String identifier) {
        this.identifier = identifier;
        return this;
    }

    @Override
    public RawElement validate() throws ValidationException {
        // TODO
        return this;
    }
}
