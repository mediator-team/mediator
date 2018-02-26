package org.fmgroup.mediator.language.property;

import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.property.PathFormulae.PathFormulae;
import org.fmgroup.mediator.language.term.Term;
import org.fmgroup.mediator.language.type.Type;

import java.util.Map;

/**
 * Basically, notTemporalFormulae can be either subclass of PathFormulae or StateFormulae.
 * But PathFormulae is subclass of StateFormulae, so we only extends PathFormulae here (
 * actually this is the only solution I have found! So any other suggestions are welcome...
 * @param <T> PathFormulae or StateFormulae
 */
public class NotFormulae<T extends Formulae> implements PathFormulae {
    private RawElement parent;
    private T formulae;

    public T getFormulae() {
        return formulae;
    }

    public NotFormulae<T> setFormulae(T formulae) {
        this.formulae = formulae;
        formulae.setParent(this);
        return this;
    }

    @Override
    public String toString() {
        return "!" + formulae.toString();
    }

    @Override
    public int getPrecedence() {
        return 0;
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
    public NotFormulae<T> setParent(RawElement parent) {
        this.parent = parent;
        return this;
    }
}
