package org.fmgroup.mediator.language.type.termType;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.generated.MediatorLangParser;
import org.fmgroup.mediator.language.scope.Scope;
import org.fmgroup.mediator.language.scope.TypeDeclaration;
import org.fmgroup.mediator.language.term.Term;
import org.fmgroup.mediator.language.type.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class IdType implements Type {

    private RawElement parent = null;
    private List<String> scopeIdentifiers = new ArrayList<>();
    private String identifier;
    private TypeDeclaration reference = null;

    public List<String> getScopeIdentifiers() {
        return scopeIdentifiers;
    }

    public IdType setScopeIdentifiers(List<String> scopeIdentifiers) {
        this.scopeIdentifiers = scopeIdentifiers;
        return this;
    }

    public String getIdentifier() {
        return identifier;
    }

    public IdType setIdentifier(String identifier) throws ValidationException {
        this.identifier = identifier;

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

        return this;
    }

    public TypeDeclaration getReference() {
        return reference;
    }

    public IdType setReference(TypeDeclaration reference) {
        this.reference = reference;
        return this;
    }

    @Override
    public IdType fromContext(ParserRuleContext context, RawElement parent) throws ValidationException {
        if (!(context instanceof MediatorLangParser.IdTypeContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "IdTypeContext", context.toString());
        }

        setParent(parent);
        setScopeIdentifiers(
                ((MediatorLangParser.IdTypeContext) context)
                        .scopedID()
                        .scopes
                        .stream().map(Token::getText).collect(Collectors.toList())
        );
        setIdentifier(((MediatorLangParser.IdTypeContext) context).scopedID().identifier.getText());

        return this;
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
    public Term getInitValue() throws ValidationException {
        return reference.getType().getInitValue();
    }

    @Override
    public Type refactor(Map<String, Type> typeRewriteMap, Map<String, Term> termRewriteMap) throws ValidationException {
        if (typeRewriteMap.containsKey(this.toString())) {
            return typeRewriteMap.get(this.toString()).copy(this.getParent());
        }

        return this;
    }

    @Override
    public RawElement getParent() {
        return parent;
    }

    @Override
    public IdType setParent(RawElement parent) {
        this.parent = parent;
        return this;
    }

    @Override
    public IdType copy(RawElement parent) throws ValidationException {
        return new IdType()
                .setParent(parent)
                .setScopeIdentifiers(getScopeIdentifiers())
                .setIdentifier(getIdentifier());
    }

    @Override
    public Type extractRawType() throws ValidationException {
        return reference.getType().extractRawType();
    }
}
