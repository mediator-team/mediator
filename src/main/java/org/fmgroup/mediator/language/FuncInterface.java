package org.fmgroup.mediator.language;

import jdk.nashorn.internal.ir.Terminal;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.fmgroup.mediator.language.type.Type;
import org.fmgroup.mediator.language.type.UtilType;

import java.util.HashMap;
import java.util.Map;

public class FuncInterface implements RawElement {

    private RawElement parent;

    public Map<String, Type> args = new HashMap<>();

    @Override
    public RawElement fromContext(ParserRuleContext context) throws ValidationException {
        if (!(context instanceof MediatorLangParser.FuncInterfaceContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "FuncInterfaceContext", context.toString());
        }

        for (MediatorLangParser.FuncArgContext arg : ((MediatorLangParser.FuncInterfaceContext) context).funcArg()) {
            for (TerminalNode name : arg.ID()) {
                args.put(name.getText(), UtilType.parse(arg.type(), this));
            }
        }

        return this.validate();
    }

    @Override
    public String toString() {
        String rel = "";
        for (String name : args.keySet()) {
            if (rel.length() > 0) rel += ", ";
            rel += name + ": " + args.get(name).toString();
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

    @Override
    public RawElement validate() throws ValidationException {
        // TODO
        return this;
    }
}
