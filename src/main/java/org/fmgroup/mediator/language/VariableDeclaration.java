package org.fmgroup.mediator.language;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.fmgroup.mediator.language.type.Type;
import org.fmgroup.mediator.language.type.UtilType;

import java.util.ArrayList;
import java.util.List;

public class VariableDeclaration implements RawElement {

    private RawElement parent = null;
    public List<String> names = new ArrayList<>();
    public Type type = null;

    @Override
    public RawElement fromContext(ParserRuleContext context) throws ValidationException {
        if (!(context instanceof MediatorLangParser.LocalVariableDefContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "LocalVariableDefContext", context.toString());
        }

        MediatorLangParser.LocalVariableDefContext vardef = (MediatorLangParser.LocalVariableDefContext) context;
        for (TerminalNode tn : vardef.ID()) {
            names.add(tn.getText());
        }
        type = UtilType.parse(vardef.type(), this);

        return this.validate();
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < names.size(); i ++) str += (i == 0 ? "" : ", ") + names.get(i);

        if (names.size() > 0) {
            str += " : " + type.toString() + ";";
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
        nvd.names = new ArrayList<>(this.names);
        nvd.type = (Type) this.type.clone(nvd);

        return nvd;
    }

    @Override
    public RawElement validate() throws ValidationException {
        // TODO
        return this;
    }
}
