package org.fmgroup.mediator.language.type;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.MediatorLangParser;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.term.Term;
import org.fmgroup.mediator.language.term.UtilTerm;

public class InitType implements Type {

    private RawElement parent = null;

    public Term defaultValue = null;
    public Type baseType = null;

    @Override
    public String getName() {
        return "init";
    }

    @Override
    public RawElement fromContext(ParserRuleContext context) throws ValidationException {
        if (!(context instanceof MediatorLangParser.InitTypeContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "InitTypeContext", context.toString());
        }

        this.defaultValue = UtilTerm.parse(((MediatorLangParser.InitTypeContext) context).term(), this);
        this.baseType = UtilType.parse(((MediatorLangParser.InitTypeContext) context).type(), this);
        return this.validate();
    }

    @Override
    public String toString() {
        return baseType.toString() + " init " + defaultValue.toString();
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
        InitType nit = new InitType();
        nit.setParent(parent);
        nit.baseType = (Type) this.baseType.clone(nit);
        nit.defaultValue = (Term) this.defaultValue.clone(nit);

        return nit.validate();
    }

    public InitType setBaseType(Type baseType) { this.baseType = baseType; return this; }

    public InitType setDefaultValue(Term value) { this.defaultValue = value; return this; }

    @Override
    public RawElement validate() throws ValidationException {
        // TODO
        return this;
    }
}
