package org.fmgroup.mediator.language.property.StateFormulae;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.generated.MediatorLangParser;
import org.fmgroup.mediator.language.term.Term;
import org.fmgroup.mediator.language.type.Type;

import java.util.Map;

public class UntilStateFormulae implements StateFormulae {
    private RawElement parent;

    public StateFormulae getKeep() {
        return keep;
    }

    public UntilStateFormulae setKeep(StateFormulae keep) {
        this.keep = keep;
        keep.setParent(this);
        return this;
    }

    public StateFormulae getUntil() {
        return until;
    }

    public UntilStateFormulae setUntil(StateFormulae until) {
        this.until = until;
        until.setParent(this);
        return this;
    }

    private StateFormulae keep;
    private StateFormulae until;

    @Override
    public UntilStateFormulae fromContext(ParserRuleContext context, RawElement parent) throws ValidationException {
        if (!(context instanceof MediatorLangParser.UntilStateFormulaeContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "UntilStateFormulaeContext", context.toString());
        }

        setParent(parent);
        setKeep(
                StateFormulae.parse(((MediatorLangParser.UntilStateFormulaeContext) context).keep, this)
        );
        setUntil(
                StateFormulae.parse(((MediatorLangParser.UntilStateFormulaeContext) context).until, this)
        );

        return this;
    }

    @Override
    public Term refactor(Map<String, Type> typeRewriteMap, Map<String, Term> termRewriteMap) throws ValidationException {
        return null;
    }

    @Override
    public RawElement getParent() {
        return this.parent;
    }

    @Override
    public UntilStateFormulae setParent(RawElement parent) {
        this.parent = parent;
        return this;
    }

    @Override
    public String toString() {
        return String.format(
                "[%s U %s]",
                keep.toString(),
                until.toString()
        );
    }
}
