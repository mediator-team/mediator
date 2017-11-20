package org.fmgroup.mediator.language.function;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.MediatorLangParser;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.scope.Declaration;
import org.fmgroup.mediator.language.scope.DeclarationCollection;
import org.fmgroup.mediator.language.scope.VariableDeclaration;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FuncInterface implements RawElement, DeclarationCollection {

    private RawElement parent;

    public List<VariableDeclaration> args = new ArrayList<>();

    @Override
    public RawElement fromContext(ParserRuleContext context) throws ValidationException {
        if (!(context instanceof MediatorLangParser.FunctionInterfaceContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "FuncInterfaceContext", context.toString());
        }

        for (MediatorLangParser.LocalVariableDefContext arg : ((MediatorLangParser.FunctionInterfaceContext) context).localVariableDef()) {
            args.add(
                    (VariableDeclaration) new VariableDeclaration().parse(arg, this)
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
    public RawElement setParent(RawElement parent)  {
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
    public List<Declaration> getDeclarationList() {
        List<Declaration> result = new ArrayList<>(this.args);
        return result;
    }
}
