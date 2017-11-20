package org.fmgroup.mediator.language.scope;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.fmgroup.mediator.language.MediatorLangParser;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.type.Type;
import org.fmgroup.mediator.language.type.UtilType;

import java.util.ArrayList;
import java.util.List;

public class VariableDeclaration implements RawElement, Declaration {

    private RawElement parent = null;
    public List<String> identifiers = new ArrayList<>();
    public Type type = null;

    @Override
    public RawElement fromContext(ParserRuleContext context) throws ValidationException {
        if (!(context instanceof MediatorLangParser.LocalVariableDefContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "LocalVariableDefContext", context.toString());
        }

        Scope currentScope = getCurrentScope();

        MediatorLangParser.LocalVariableDefContext vardef = (MediatorLangParser.LocalVariableDefContext) context;
        for (TerminalNode tn : vardef.ID()) {
            if (identifiers.contains(tn.getText()) || currentScope.existsDeclaration(tn.getText())) {
                throw ValidationException.DumplicatedIdentifier(tn.getText(), "symbol");
            }

            identifiers.add(tn.getText());
        }
        type = UtilType.parse(vardef.type(), this);

        return this;
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < identifiers.size(); i ++) str += (i == 0 ? "" : ", ") + identifiers.get(i);

        if (identifiers.size() > 0) {
            str += " : " + type.toString();
        }
        return str;
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
    public RawElement clone(RawElement parent) throws ValidationException {
        VariableDeclaration nvd = (VariableDeclaration) new VariableDeclaration().setParent(parent);
        nvd.identifiers = new ArrayList<>(this.identifiers);
        nvd.type = (Type) this.type.clone(nvd);

        return nvd;
    }

    @Override
    public RawElement validate() throws ValidationException {
        return this;
    }

    @Override
    public int size() {
        return identifiers.size();
    }

    @Override
    public String getIdentifier(int index) {
        return identifiers.get(index);
    }
}
