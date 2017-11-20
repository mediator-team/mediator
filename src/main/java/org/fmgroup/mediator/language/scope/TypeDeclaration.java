package org.fmgroup.mediator.language.scope;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.fmgroup.mediator.language.MediatorLangParser;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.type.Type;

import java.util.ArrayList;
import java.util.List;


public class TypeDeclaration implements RawElement, Declaration {

    public RawElement parent;

    public List<String> identifiers = new ArrayList<>();
    public Type type;
    public boolean isTypedef = true;

    @Override
    public RawElement fromContext(ParserRuleContext context) throws ValidationException {
        if (!(context instanceof MediatorLangParser.TypedefContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "TypedefContext", context.toString());
        }

        Scope currentScope = getCurrentScope();

        for (TerminalNode tn : ((MediatorLangParser.TypedefContext) context).ID()) {
            if (identifiers.contains(tn.getText()) || currentScope.existsDeclaration(tn.getText())) {
                throw ValidationException.DumplicatedIdentifier(tn.getText(), "symbol");
            }

            identifiers.add(tn.getText());
        }

        type = Type.parse(((MediatorLangParser.TypedefContext) context).type(), this);

        return this;
    }

    @Override
    public String toString() {
        if (isTypedef) {
            return String.format(
                    "typedef %s as %s",
                    type.toString(),
                    String.join(", ", identifiers)
            );
        } else {
            return String.format(
                    "%s : %s",
                    String.join(", ", identifiers),
                    type.toString()
            );
        }
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
    public RawElement validate() throws ValidationException {
        // TODO
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
