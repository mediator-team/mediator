package org.fmgroup.mediator.language;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.MediatorLangParser;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.scope.Declaration;
import org.fmgroup.mediator.language.scope.Declarations;
import org.fmgroup.mediator.language.scope.TypeDeclaration;
import org.fmgroup.mediator.language.scope.VariableDeclaration;
import org.fmgroup.mediator.language.type.AbstractType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Template implements RawElement, Declarations {

    private RawElement parent;

    public List<Declaration> params = new ArrayList<>();

    public Template() {}

    @Override
    public RawElement fromContext(ParserRuleContext context) throws ValidationException {
        if (!(context instanceof MediatorLangParser.EntityTemplateContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "CompTemplateContext", context.toString());
        }

        for (MediatorLangParser.LocalVariableDefContext paramContext : ((MediatorLangParser.EntityTemplateContext) context).localVariableDef()) {
            VariableDeclaration vardecl = (VariableDeclaration) new VariableDeclaration().parse(paramContext, this);
            if (vardecl.type instanceof AbstractType) {
                TypeDeclaration typedecl = new TypeDeclaration();
                typedecl.identifiers = new ArrayList<>(vardecl.identifiers);
                typedecl.type = new AbstractType();
                typedecl.setParent(this);
                typedecl.isTypedef = false;
                typedecl.validate();

                params.add(typedecl);
            } else {
                params.add(vardecl);
            }
        }
        return this;
    }

    @Override
    public String toString() {
        return params.stream()
                .map(param -> param.toString())
                .collect(Collectors.joining(", "));
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
    public RawElement clone(RawElement parent) {
        return null;
    }

    @Override
    public RawElement validate() throws ValidationException {
        // TODO
        return this;
    }

    @Override
    public List<Declaration> getDeclarationList() { return this.params; }


}
