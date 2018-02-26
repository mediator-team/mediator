package org.fmgroup.mediator.language;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.generated.MediatorLangParser;
import org.fmgroup.mediator.language.scope.Declaration;
import org.fmgroup.mediator.language.scope.DeclarationCollection;
import org.fmgroup.mediator.language.scope.TypeDeclaration;
import org.fmgroup.mediator.language.scope.VariableDeclaration;
import org.fmgroup.mediator.language.type.paramType.AbstractType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Template implements RawElement, DeclarationCollection<Declaration> {

    private RawElement parent;

    private List<Declaration> params = new ArrayList<>();

    public Template() {
    }

    @Override
    public Template fromContext(ParserRuleContext context, RawElement parent) throws ValidationException {
        if (context == null) return null;

        if (!(context instanceof MediatorLangParser.TemplateContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "CompTemplateContext", context.toString());
        }

        setParent(parent);

        for (MediatorLangParser.LocalVariableDefContext paramContext : ((MediatorLangParser.TemplateContext) context).localVariableDef()) {
            VariableDeclaration vardecl = new VariableDeclaration().fromContext(paramContext, this);
            if (vardecl.getType() instanceof AbstractType) {
                TypeDeclaration typedecl = new TypeDeclaration();

                typedecl.setParent(this);
                typedecl.setType(new AbstractType());
                typedecl.setIdentifiers(vardecl.getIdentifiers());
                typedecl.setTypedef(false);

                addDeclaration(typedecl);
            } else {
                addDeclaration(vardecl);
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
    public Template setParent(RawElement parent) {
        this.parent = parent;
        return this;
    }

    @Override
    public Template copy(RawElement parent) throws ValidationException {
        return new Template().setParent(parent).setDeclarationList(params);
    }

    @Override
    public List<Declaration> getDeclarationList() {
        return this.params;
    }

    @Override
    public Template setDeclarationList(List<Declaration> declarationList) {
        this.params = new ArrayList<>();
        declarationList.forEach(this::addDeclaration);
        return this;
    }

    @Override
    public Template addDeclaration(Declaration declaration) {
        this.params.add(declaration);
        declaration.setParent(this);
        return this;
    }

    public int size() {
        return getDeclarationList().stream().map(
                declaration -> declaration.getIdentifiers().size()
        ).mapToInt(Integer::valueOf).sum();
    }

}
