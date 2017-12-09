package org.fmgroup.mediator.language.function;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.generated.MediatorLangParser;
import org.fmgroup.mediator.language.scope.DeclarationCollection;
import org.fmgroup.mediator.language.scope.VariableDeclaration;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FuncInterface implements RawElement, DeclarationCollection<VariableDeclaration> {

    private RawElement parent;
    private List<VariableDeclaration> args = new ArrayList<>();

    public List<VariableDeclaration> getArgs() {
        return args;
    }

    public FuncInterface setArgs(List<VariableDeclaration> args) {
        setDeclarationList(args);
        return this;
    }

    @Override
    public FuncInterface fromContext(ParserRuleContext context, RawElement parent) throws ValidationException {
        if (!(context instanceof MediatorLangParser.FunctionInterfaceContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "FuncInterfaceContext", context.toString());
        }

        setParent(parent);
        for (MediatorLangParser.LocalVariableDefContext arg : ((MediatorLangParser.FunctionInterfaceContext) context).localVariableDef()) {
            addDeclaration(
                    new VariableDeclaration().fromContext(arg, this)
            );
        }

        return this;
    }

    @Override
    public String toString() {
        return args.stream().map(Object::toString).collect(Collectors.joining(", "));
    }

    @Override
    public RawElement getParent() {
        return parent;
    }

    @Override
    public FuncInterface setParent(RawElement parent) {
        this.parent = parent;
        return this;
    }

    @Override
    public FuncInterface copy(RawElement parent) throws ValidationException {
        FuncInterface funcInterface = new FuncInterface()
                .setParent(parent);

        for (VariableDeclaration vardecl : getDeclarationList()) {
            funcInterface.addDeclaration(vardecl.copy(funcInterface));
        }

        return funcInterface;
    }

    @Override
    public List<VariableDeclaration> getDeclarationList() {
        return this.args;
    }

    @Override
    public DeclarationCollection<VariableDeclaration> addDeclaration(VariableDeclaration declaration) {
        this.args.add(declaration);
        declaration.setParent(this);
        return this;
    }

    @Override
    public DeclarationCollection<VariableDeclaration> setDeclarationList(List<VariableDeclaration> declarationList) {
        args = new ArrayList<>();
        declarationList.forEach(this::addDeclaration);
        return this;
    }
}
