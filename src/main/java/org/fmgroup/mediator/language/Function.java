package org.fmgroup.mediator.language;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.generator.framework.UtilCode;
import org.fmgroup.mediator.language.statement.Statement;
import org.fmgroup.mediator.language.statement.UtilStatement;
import org.fmgroup.mediator.language.type.Type;
import org.fmgroup.mediator.language.type.UtilType;

import javax.swing.plaf.nimbus.State;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Function implements RawElement {

    private RawElement parent = null;
    public CompTemplate compTemplate = null;
    public FuncInterface funcInterface = null;
    public String name;
    public List<VariableDeclaration> variables = new ArrayList<>();
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

        if (((MediatorLangParser.FunctionContext) context).compTemplate() != null) {
            compTemplate = (CompTemplate) new CompTemplate()
                    .setParent(this)
                    .fromContext(((MediatorLangParser.FunctionContext) context).compTemplate()
                    );
        }

        if (((MediatorLangParser.FunctionContext) context).returnType != null) {
            returnType = UtilType.parse(((MediatorLangParser.FunctionContext) context).returnType, this);
        }

        funcInterface = (FuncInterface) new FuncInterface()
                .setParent(this)
                .fromContext(((MediatorLangParser.FunctionContext) context).funcInterface());

        for (MediatorLangParser.LocalVariableDefContext lvd : ((MediatorLangParser.FunctionContext) context).localVariableDef()) {
            VariableDeclaration vardecl = (VariableDeclaration) new VariableDeclaration().setParent(this).fromContext(lvd);
            variables.add(vardecl);
        }

        for (MediatorLangParser.StatementContext sc : ((MediatorLangParser.FunctionContext) context).statement()) {
            statements.add(UtilStatement.parse(sc, this));
        }

        return this.validate();
    }

    @Override
    public String toString() {
        String template = compTemplate == null? "" : compTemplate.toString();
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
            for (VariableDeclaration var : variables) {
                rel += UtilCode.addIndent(var.toString() + "\n", 1);
            }
            for (Statement stmt : statements) {
                rel += UtilCode.addIndent(stmt.toString() + "\n", 1);
            }
            rel += "}\n";
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
}
