package org.fmgroup.mediator.language.term;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.generated.MediatorLangParser;
import org.fmgroup.mediator.language.scope.Declaration;
import org.fmgroup.mediator.language.scope.Scope;
import org.fmgroup.mediator.language.scope.TypeDeclaration;
import org.fmgroup.mediator.language.scope.VariableDeclaration;
import org.fmgroup.mediator.language.type.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class IdValue implements Value {

    private RawElement parent = null;
    private List<String> scopeIdentifiers = new ArrayList<>();
    private String identifier = null;
    private Declaration reference = null;

    @Override
    public Type getType() throws ValidationException {
        if (reference instanceof VariableDeclaration) {
            return ((VariableDeclaration) reference).getType().extractRawType();
        }

        throw ValidationException.UnderDevelopment();
    }

    @Override
    public int getPrecedence() {
        return 14;
    }

    @Override
    public IdValue fromContext(ParserRuleContext context, RawElement parent) throws ValidationException {
        if (context instanceof MediatorLangParser.IdValueContext) {
            context = ((MediatorLangParser.IdValueContext) context).scopedID();
        }

        if (!(context instanceof MediatorLangParser.ScopedIDContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "(Scope)IdValueContext", context.getClass().toString());
        }

        setParent(parent);
        setScopeIdentifiers(
                ((MediatorLangParser.ScopedIDContext) context).scopes.stream().map(
                        Token::getText
                ).collect(Collectors.toList())
        );

        setIdentifier(
                ((MediatorLangParser.ScopedIDContext) context).identifier.getText()
        );

        return this;
    }

    public List<String> getScopeIdentifiers() {
        return scopeIdentifiers;
    }

    public IdValue setScopeIdentifiers(List<String> scopeIdentifiers) {
        this.scopeIdentifiers = scopeIdentifiers;
        return this;
    }

    public String getIdentifier() {
        return identifier;
    }


    /**
     * set identifier and locate the reference from its context
     * setParent() method must be invoked before setIdentifier()
     *
     * @param identifier
     * @return
     * @throws ValidationException
     */
    public IdValue setIdentifier(String identifier) throws ValidationException {
        this.identifier = identifier;

        if (this.scopeIdentifiers.size() == 0) {
            List<Scope> scopes = this.getScopes();
            for (Scope scope : scopes) {
                if (scope.getVariable(this) != null) {
                    this.reference = scope.getVariable(this);
                    break;
                }
                if (scope.getEnumFromIdentifier(this.identifier) != null) {
                    this.reference = scope.getEnumFromIdentifier(this.identifier);
                    break;
                }

            }
        }

        if (this.reference == null) {
            throw ValidationException.UnknownIdentifier(this.toString(), "variable");
        }

        return this;
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
    public IdValue setParent(RawElement parent) {
        this.parent = parent;
        return this;
    }

    @Override
    public IdValue copy(RawElement parent) throws ValidationException {
        IdValue niv = new IdValue();
        niv.setParent(parent);
        niv.setScopeIdentifiers(new ArrayList<>(this.scopeIdentifiers));
        niv.setIdentifier(this.identifier);

        return niv;
    }
}
