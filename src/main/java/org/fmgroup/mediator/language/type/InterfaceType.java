package org.fmgroup.mediator.language.type;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.*;
import org.fmgroup.mediator.language.System;
import org.fmgroup.mediator.language.term.IdValue;
import org.fmgroup.mediator.language.term.UtilTerm;

import java.util.ArrayList;
import java.util.List;

public class InterfaceType implements Type {

    private RawElement parent;

    public IdValue reference;
    public InterfacedElement provider = null;
    public List<RawElement> params = new ArrayList<>();

    @Override
    public RawElement fromContext(ParserRuleContext context) throws ValidationException {
        if (!(context instanceof MediatorLangParser.InterfaceTypeContext)) {
            throw ValidationException.IncompatibleContextType(
                    this.getClass(),
                    "InterfaceTypeContext",
                    context.getClass().toString()
            );
        }

        this.reference = (IdValue) new IdValue()
                .setParent(this)
                .fromContext(((MediatorLangParser.InterfaceTypeContext) context).scopeID());
        for (MediatorLangParser.TypeorvalueContext tov : ((MediatorLangParser.InterfaceTypeContext) context).typeorvalue()) {
            if (tov.type() == null) {
                // it is a value
                params.add((RawElement) UtilTerm.parseValue(tov.value(), this));
            } else {
                params.add((RawElement) UtilType.parse(tov.type(), this));
            }
        }

        return this.validate();
    }

    @Override
    public String toString() {
        String rel = this.reference.toString();
        rel += "<";
        for (RawElement raw : this.params) {
            if (this.params.indexOf(raw) > 0) {
                rel += ", ";
            }
            rel += raw.toString();
        }
        rel += ">";
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
    public RawElement clone(RawElement parent) throws ValidationException {
        InterfaceType nit = new InterfaceType();
        nit.setParent(parent);
        nit.reference = (IdValue) this.reference.clone(nit);
        for (RawElement elem : this.params) {
            nit.params.add(elem.clone(nit));
        }

        return nit.validate();
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public RawElement validate() throws ValidationException {
        if (!(parent instanceof System) && !(parent instanceof Connection)) {
            throw ValidationException.UnexpectedElement(this.getClass(), parent.getClass(),"System", "parent");
        }

        // locate the reference
        Program prog = UtilLang.getRoot(this);
        CompTemplate template = null;
        if (reference.scopes.size() > 0) {
            // TODO look it up in the dependencies
            throw ValidationException.UnderDevelopment();
        } else {
            if (prog.automata.containsKey(reference.identifier)) {
                provider = prog.automata.get(reference.identifier);
            }
            else if (prog.systems.containsKey(reference.identifier)) {
                provider = prog.systems.get(reference.identifier);
            }
            template = provider.getTemplate();
        }

        if (provider == null) {
            throw ValidationException.UnknownIdentifier(reference.toString(), "Interface");
        }

        // validate the reference
        if (params.size() != (template == null ? 0 : template.params.size())) {
            throw ValidationException.FromMessage("Number of params mismatched.");
        }

        // TODO type should also match

        return this;
    }
}
