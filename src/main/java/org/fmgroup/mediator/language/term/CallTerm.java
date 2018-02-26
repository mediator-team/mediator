package org.fmgroup.mediator.language.term;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.generated.MediatorLangParser;
import org.fmgroup.mediator.language.type.paramType.TemplateType;
import org.fmgroup.mediator.language.type.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * formalization for a function call
 * - func(a, b)
 * - func()
 * where **callee** is the function that is called, and **args** is
 */
public class CallTerm implements Term {

    private RawElement parent;

    private TemplateType callee;
    private List<Term> args = new ArrayList<>();

    @Override
    public CallTerm fromContext(ParserRuleContext context, RawElement parent) throws ValidationException {
        if (!(context instanceof MediatorLangParser.CallTermContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "CallTermContext", context.toString());
        }

        setParent(parent);
        setCallee(new TemplateType().fromContext(((MediatorLangParser.CallTermContext) context).callee, this));

        for (MediatorLangParser.TermContext t : ((MediatorLangParser.CallTermContext) context).args.term()) {
            addArg(Term.parse(t, this));
        }

        return this;
    }

    @Override
    public String toString() {
        return String.format(
                "%s(%s)",
                callee.toString(),
                args.stream().map(Object::toString).collect(Collectors.joining(", "))
        );
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

    public TemplateType getCallee() {
        return callee;
    }

    public CallTerm setCallee(TemplateType callee) {
        this.callee = callee;
        callee.setParent(this);
        return this;
    }

    public CallTerm addArg(Term arg) {
        this.args.add(arg);
        arg.setParent(this);
        return this;
    }

    public Term getArg(int i) { return args.get(i); }

    public List<Term> getArgs() {
        return args;
    }

    public CallTerm setArgs(List<Term> args) {
        this.args = new ArrayList<>();
        args.forEach(this::addArg);
        return this;
    }

    @Override
    public CallTerm copy(RawElement parent) throws ValidationException {
        CallTerm nct = new CallTerm();
        nct.setParent(parent);
        nct.setCallee(this.getCallee().copy(nct));
        for (Term arg : this.args) {
            nct.addArg(arg.copy(nct));
        }

        return nct;
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
    public CallTerm refactor(Map<String, Type> typeRewriteMap, Map<String, Term> termRewriteMap) throws ValidationException {
        setCallee(getCallee().refactor(typeRewriteMap, termRewriteMap));
        List<Term> args = new ArrayList<>();
        for (Term arg : getArgs()) {
            args.add(arg.refactor(typeRewriteMap, termRewriteMap));
        }
        setArgs(args);
        return this;
    }

}
