package org.fmgroup.mediator.language.term;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.fmgroup.mediator.language.MediatorLangParser;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.type.IdType;
import org.fmgroup.mediator.language.type.IntType;
import org.fmgroup.mediator.language.type.Type;

import java.util.ArrayList;
import java.util.List;

public class IdValue implements Term {

    private RawElement parent = null;
    public List<String> scopes = new ArrayList<>();
    public String identifier = null;

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
            context = ((MediatorLangParser.IdValueContext) context).scopeID();
        }

        if (!(context instanceof MediatorLangParser.ScopeIDContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "(Scope)IdValueContext", context.getClass().toString());
        }

        this.identifier = ((MediatorLangParser.ScopeIDContext) context).identifier.getText();
        for (Token t : ((MediatorLangParser.ScopeIDContext) context).scopes) {
            this.scopes.add(t.getText());
        }

        return this.validate();
    }

    @Override
    public String toString() {
        return String.join(".", scopes) +
                (scopes.size() > 0 ? "." : "") +
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
        niv.scopes = new ArrayList<>(this.scopes);

        return niv.validate();
    }

    @Override
    public RawElement validate() throws ValidationException {
        // TODO
        return this;
    }
}
