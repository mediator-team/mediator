package org.fmgroup.mediator.language.entity;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.*;
import org.fmgroup.mediator.language.scope.Declaration;
import org.fmgroup.mediator.language.scope.DeclarationCollection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EntityInterface implements RawElement, DeclarationCollection {

    private RawElement parent;

    public List<PortDeclaration> portDeclarations = new ArrayList<>();

    public EntityInterface() {}

    @Override
    public RawElement fromContext(ParserRuleContext context) throws ValidationException {
        if (!(context instanceof MediatorLangParser.EntityInterfaceContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "CompInterfaceContext", context.toString());
        }

        for (MediatorLangParser.PortsDeclContext pdc : ((MediatorLangParser.EntityInterfaceContext) context).portsDecl()) {
            portDeclarations.add(
                    (PortDeclaration) new PortDeclaration().parse(pdc, this)
            );
        }

        return this;
    }

    @Override
    public String toString() {
        return portDeclarations.stream().map(
                PortDeclaration::toString
        ).collect(Collectors.joining(", "));
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
        EntityInterface newif = new EntityInterface();
        newif.parent = parent;
        for (PortDeclaration p : portDeclarations) {
            newif.portDeclarations.add((PortDeclaration) p.clone(this));
        }

        return newif;
    }

    @Override
    public RawElement validate() throws ValidationException {
        // TODO
        return this;
    }

    @Override
    public List<Declaration> getDeclarationList() {
        return new ArrayList<>(portDeclarations);
    }
}
