package org.fmgroup.mediator.language.entity.system;

import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.scope.Declaration;
import org.fmgroup.mediator.language.type.Type;
import org.fmgroup.mediator.language.type.paramType.AbstractType;

import java.util.ArrayList;
import java.util.List;

public class InternalDeclaration implements Declaration {

    private RawElement parent = null;
    private String identifier = null;
    private Type type = new AbstractType();

    /**
     * since there is no corresponding parser rule for an internal declaration, we don't overwrite
     * fromContext in this class, but use a constructor instead
     *
     * @param s
     * @param internalDeclarationCollection
     */
    public InternalDeclaration(String s, InternalDeclarationCollection internalDeclarationCollection) {
        setIdentifier(s);
        setParent(internalDeclarationCollection);
    }

    @Override
    public RawElement getParent() {
        return parent;
    }

    @Override
    public InternalDeclaration setParent(RawElement parent) {
        this.parent = parent;
        return this;
    }

    public String getIdentifier() {
        return identifier;
    }

    public InternalDeclaration setIdentifier(String identifier) {
        this.identifier = identifier;
        return this;
    }

    public Type getType() {
        return type;
    }

    public InternalDeclaration setType(Type type) {
        this.type = type;
        type.setParent(this);
        return this;
    }

    @Override
    public List<String> getIdentifiers() {
        List<String> result = new ArrayList<>();
        result.add(identifier);
        return result;
    }

    @Override
    public String toString() {
        return this.getIdentifier();
    }
}
