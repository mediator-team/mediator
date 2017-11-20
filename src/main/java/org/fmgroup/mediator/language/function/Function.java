package org.fmgroup.mediator.language.function;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.generator.framework.UtilCode;
import org.fmgroup.mediator.language.*;
import org.fmgroup.mediator.language.scope.DeclarationCollection;
import org.fmgroup.mediator.language.scope.Scope;
import org.fmgroup.mediator.language.scope.VariableDeclaration;
import org.fmgroup.mediator.language.scope.VariableDeclarationCollection;
import org.fmgroup.mediator.language.statement.Statement;
import org.fmgroup.mediator.language.type.Type;

import java.util.ArrayList;
import java.util.List;

public class Function implements RawElement, Scope, Templated {

    public RawElement parent = null;
    public String name;

    public Template template = null;
    public FuncInterface funcInterface = null;
    public VariableDeclarationCollection variables = new VariableDeclarationCollection();
    public List<Statement> statements = new ArrayList<>();
    public Type returnType = null;

    public boolean isNative = false;

    @Override
    public RawElement fromContext(ParserRuleContext context) throws ValidationException {
        if (!(context instanceof MediatorLangParser.FunctionContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "FunctionContext", context.toString());
        }

        isNative = ((MediatorLangParser.FunctionContext) context).isNative;
        name = ((MediatorLangParser.FunctionContext) context).name.getText();

        if (((MediatorLangParser.FunctionContext) context).template() != null) {
            template = new Template();
            template.parse(
                    ((MediatorLangParser.FunctionContext) context).template(),
                    this
            );
        }

        if (((MediatorLangParser.FunctionContext) context).returnType != null) {
            returnType = Type.parse(((MediatorLangParser.FunctionContext) context).returnType, this);
        }

        funcInterface = new FuncInterface();
        funcInterface.parse(((MediatorLangParser.FunctionContext) context).functionInterface(), this);


        for (MediatorLangParser.LocalVariableDefContext lvd : ((MediatorLangParser.FunctionContext) context).localVariableDef()) {
            variables.vardecls.add((VariableDeclaration) new VariableDeclaration().parse(lvd, this));
        }

        for (MediatorLangParser.StatementContext sc : ((MediatorLangParser.FunctionContext) context).statement()) {
            statements.add(Statement.parse(sc, this));
        }

        return this;
    }

    @Override
    public String toString() {
        String template = this.template == null? "" : this.template.toString();
        if (template.length() > 0) template = "<" + template + "> ";

        String rel = String.format(
                "function %s%s (%s)",
                template,
                name,
                funcInterface.toString()
        );

        if (returnType != null) rel += " : " + returnType.toString();

        if (!isNative) {
            rel += " {\n";
            rel += UtilCode.addIndent(variables.toString(), 1);

            rel += UtilCode.addIndent("statements {\n", 1);
            for (Statement stmt : statements) {
                rel += UtilCode.addIndent(stmt.toString() + "\n", 2);
            }
            rel += UtilCode.addIndent("}\n", 1);
            rel += "}";
        } else {
            rel += ";";
        }
        return rel;
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

    public RawElement validate() throws ValidationException {
        // TODO
        return this;
    }

    @Override
    public List<DeclarationCollection> getDeclarations() {
        List<DeclarationCollection> result = new ArrayList<>();

        if (template != null) {
            result.add(template);
        }
        if (funcInterface != null) result.add(funcInterface);
        if (variables != null) result.add(variables);

        return result;
    }

    @Override
    public Template getTemplate() {
        return this.template;
    }
}
