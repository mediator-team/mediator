package org.fmgroup.mediator.language.term;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.MediatorLangParser;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.type.TemplateType;
import org.fmgroup.mediator.language.type.Type;

import java.util.ArrayList;
import java.util.List;

public class CallTerm implements Term {

    private RawElement parent;

    public TemplateType callee;
    public List<Term> args = new ArrayList<>();

    @Override
    public RawElement fromContext(ParserRuleContext context) throws ValidationException {
        if (!(context instanceof MediatorLangParser.CallTermContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "CallTermContext", context.toString());
        }

        this.callee = (TemplateType) new TemplateType().parse(((MediatorLangParser.CallTermContext) context).callee, this);

        Term targs = Term.parse(((MediatorLangParser.CallTermContext) context).args, this);
        if (targs instanceof TupleTerm) {
            args.addAll(((TupleTerm) targs).getTerms());
        } else {
            args.add(targs);
        }

        return this.validate();
    }

    @Override
    public String toString() {
        return String.format(
                "%s(%s)",
                callee.toString(),
                args.toString()
        );
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
    public RawElement clone(RawElement parent) throws ValidationException {
        CallTerm nct = (CallTerm) new CallTerm().setParent(parent);
        nct.parent = parent;
        nct.callee = (TemplateType) this.callee.clone(nct);
        nct.args = new ArrayList<>(this.args);
        return nct.validate();
    }

    @Override
    public Type getType() {
        return null;
    }

    @Override
    public int getPrecedence() {
        return 11;
    }

    @Override
    public RawElement validate() throws ValidationException {
        // TODO
        return this;
    }
}
