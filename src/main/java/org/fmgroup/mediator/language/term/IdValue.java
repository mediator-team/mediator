package org.fmgroup.mediator.language.term;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.fmgroup.mediator.language.MediatorLangParser;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.scope.Scope;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.scope.VariableDeclaration;
import org.fmgroup.mediator.language.type.IdType;
import org.fmgroup.mediator.language.type.Type;

import java.util.ArrayList;
import java.util.List;

public class IdValue implements Term {

    public RawElement parent = null;
    public List<String> scopeIdentifiers = new ArrayList<>();
    public String identifier = null;
    public VariableDeclaration reference = null;

    @Override
    public Type getType() {
        return new IdType();
    }

    @Override
    public int getPrecedence() {
        return 14;
    }

    @Override
    public RawElement fromContext(ParserRuleContext context) throws ValidationException {
        if (context instanceof MediatorLangParser.IdValueContext) {
            context = ((MediatorLangParser.IdValueContext) context).scopedID();
        }

        if (!(context instanceof MediatorLangParser.ScopedIDContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "(Scope)IdValueContext", context.getClass().toString());
        }

        this.identifier = ((MediatorLangParser.ScopedIDContext) context).identifier.getText();
        for (Token t : ((MediatorLangParser.ScopedIDContext) context).scopes) {
            this.scopeIdentifiers.add(t.getText());
        }

        if (this.scopeIdentifiers.size() == 0) {
            List<Scope> scopes = this.getScopes();
            for (Scope scope : scopes) {
                this.reference = scope.getVariable(this);
                if (this.reference != null) break;
            }
        } else {
            // TODO
        }

        if (this.reference == null) throw ValidationException.UnknownIdentifier(this.toString(), "variable");

        return this.validate();
    }

    @Override
    public String toString() {
        return String.join(".", scopeIdentifiers) +
                (scopeIdentifiers.size() > 0 ? "." : "") +
                identifier;
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

    public IdValue setIdentifier(String identifier) {
        this.identifier = identifier;
        return this;
    }

    @Override
    public RawElement clone(RawElement parent) throws ValidationException {
        IdValue niv = new IdValue();
        niv.setParent(parent);
        niv.identifier = this.identifier;
        niv.scopeIdentifiers = new ArrayList<>(this.scopeIdentifiers);

        return niv.validate();
    }

    @Override
    public RawElement validate() throws ValidationException {
        // TODO
        return this;
    }
}
