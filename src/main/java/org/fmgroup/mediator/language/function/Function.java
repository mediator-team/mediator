package org.fmgroup.mediator.language.function;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.common.UtilCode;
import org.fmgroup.mediator.language.*;
import org.fmgroup.mediator.language.generated.MediatorLangParser;
import org.fmgroup.mediator.language.scope.DeclarationCollection;
import org.fmgroup.mediator.language.scope.Scope;
import org.fmgroup.mediator.language.scope.VariableDeclaration;
import org.fmgroup.mediator.language.scope.VariableDeclarationCollection;
import org.fmgroup.mediator.language.statement.Statement;
import org.fmgroup.mediator.language.term.Term;
import org.fmgroup.mediator.language.type.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Function implements RawElement, Scope, Templated {

    private RawElement parent = null;
    private String name;
    private Template template = null;
    private FuncInterface funcInterface = null;
    private VariableDeclarationCollection variables;
    private List<Statement> statements = new ArrayList<>();
    private Type returnType = null;
    private boolean isNative = false;
    private Meta meta = null;

    public Meta getMeta() {
        return meta;
    }

    public Function setMeta(Meta meta) {
        this.meta = meta;
        meta.setParent(this);
        return this;
    }

    public String getName() {
        return name;
    }

    public Function setName(String name) {
        this.name = name;
        return this;
    }

    public FuncInterface getFuncInterface() {
        return funcInterface;
    }

    public Function setFuncInterface(FuncInterface funcInterface) {
        this.funcInterface = funcInterface;
        funcInterface.setParent(this);
        return this;
    }

    public VariableDeclarationCollection getVariables() {
        return variables;
    }

    public Function setVariables(VariableDeclarationCollection variables) {
        this.variables = variables;
        variables.setParent(this);
        return this;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    public Function setStatements(List<Statement> statements) {
        this.statements = new ArrayList<>();
        statements.forEach(this::addStatement);
        return this;
    }

    public Function addStatement(Statement statement) {
        this.statements.add(statement);
        statement.setParent(this);
        return this;
    }

    public Type getReturnType() {
        return returnType;
    }

    public Function setReturnType(Type returnType) {
        this.returnType = returnType;
        if (returnType != null)
            returnType.setParent(this);
        return this;
    }

    public boolean isNative() {
        return isNative;
    }

    public Function setNative(boolean aNative) {
        isNative = aNative;
        return this;
    }

    @Override
    public Function fromContext(ParserRuleContext context, RawElement parent) throws ValidationException {
        if (!(context instanceof MediatorLangParser.FunctionContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "FunctionContext", context.toString());
        }

        setParent(parent);

        setNative(((MediatorLangParser.FunctionContext) context).isNative);
        setName(((MediatorLangParser.FunctionContext) context).name.getText());

        setTemplate(new Template().fromContext(((MediatorLangParser.FunctionContext) context).template(), this));
        setFuncInterface(new FuncInterface().fromContext(((MediatorLangParser.FunctionContext) context).functionInterface(), this));

        setReturnType(Type.parse(((MediatorLangParser.FunctionContext) context).returnType, this));

        if (!isNative) {
            setVariables(new VariableDeclarationCollection().setParent(this));
            for (MediatorLangParser.LocalVariableDefContext lvd : ((MediatorLangParser.FunctionContext) context).localVariableDef()) {
                getVariables().addDeclaration(new VariableDeclaration().fromContext(lvd, this));
            }

            for (MediatorLangParser.StatementContext sc : ((MediatorLangParser.FunctionContext) context).statement()) {
                addStatement(Statement.parse(sc, this));
            }

            if (((MediatorLangParser.FunctionContext) context).meta() != null)
                setMeta(new Meta().fromContext(((MediatorLangParser.FunctionContext) context).meta(), this));
        }

        return this;
    }

    @Override
    public String toString() {
        String template = this.template == null ? "" : this.template.toString();
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
            if (getMeta() != null) rel += " " + getMeta().toString();
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
    public Function setParent(RawElement parent) {
        this.parent = parent;
        return this;
    }

    @Override
    public Function copy(RawElement parent) throws ValidationException {
        Function nfunc = new Function();

        nfunc.setParent(parent);
        nfunc.setName(getName());
        nfunc.setTemplate(getTemplate().copy(nfunc));
        nfunc.setFuncInterface(getFuncInterface().copy(nfunc));
        nfunc.setReturnType(getReturnType().copy(nfunc));

        for (Statement stmt : getStatements()) {
            nfunc.addStatement((Statement) stmt.copy(nfunc));
        }

        return nfunc;
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

    @Override
    public Templated refactor(Map<String, Type> typeRewriteMap, Map<String, Term> termRewriteMap) throws ValidationException {
        throw ValidationException.UnderDevelopment();
    }

    public Function setTemplate(Template template) {
        this.template = template;
        return this;
    }
}
