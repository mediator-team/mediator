package org.fmgroup.mediator.language.type;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.fmgroup.mediator.language.*;
import org.fmgroup.mediator.language.Program;
import org.fmgroup.mediator.language.Template;
import org.fmgroup.mediator.language.term.CallTerm;
import org.fmgroup.mediator.language.term.Term;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TemplateType implements Type {

    private RawElement parent;

    public List<String> libraryPath;
    public String identifier;
    public Templated provider = null;
    public List<RawElement> params = new ArrayList<>();

    @Override
    public RawElement fromContext(ParserRuleContext context) throws ValidationException {
        if (context instanceof MediatorLangParser.TemplateTypeContext) {
            identifier = ((MediatorLangParser.TemplateTypeContext) context).scopedID().identifier.getText();
            libraryPath = ((MediatorLangParser.TemplateTypeContext) context).scopedID().scopes.stream()
                    .map(Token::getText)
                    .collect(Collectors.toList());

            for (MediatorLangParser.TypeorvalueContext tov : ((MediatorLangParser.TemplateTypeContext) context).typeorvalue()) {
                if (tov.type() == null) {
                    // it is a value
                    params.add(Term.parseValue(tov.value(), this));
                } else {
                    params.add(Type.parse(tov.type(), this));
                }
            }
        }
        else if (context instanceof MediatorLangParser.IdTypeContext) {
            identifier = ((MediatorLangParser.IdTypeContext) context).scopedID().identifier.getText();
            libraryPath = ((MediatorLangParser.IdTypeContext) context).scopedID().scopes.stream()
                    .map(Token::getText)
                    .collect(Collectors.toList());
        }
        else {
            throw ValidationException.IncompatibleContextType(
                    this.getClass(),
                    "TemplateTypeContext / IdTypeContext",
                    context.getClass().toString()
            );
        }

        return this;
    }

    @Override
    public String toString() {
        String rel = String.join(".", this.libraryPath);
        if (rel.length() > 0) rel += ".";
        rel += identifier;

        if (this.params.size() > 0) {
            rel += "<";
            for (RawElement raw : this.params) {
                if (this.params.indexOf(raw) > 0) {
                    rel += ", ";
                }
                rel += raw.toString();
            }
            rel += ">";
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
    public RawElement clone(RawElement parent) throws ValidationException {
        TemplateType nit = new TemplateType();
        nit.setParent(parent);
        nit.identifier = identifier;
        nit.libraryPath = new ArrayList<>(libraryPath);
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

        // locate the reference
        Program prog = UtilLang.getRoot(this);
        Template template = null;
        if (libraryPath.size() > 0) {
            // TODO look it up in the dependencies
            throw ValidationException.UnderDevelopment();
        } else {

            if (parent instanceof CallTerm) {
                provider = prog.getFunction(libraryPath, identifier);
                if (provider == null) throw ValidationException.UnknownIdentifier(identifier, "function");
            } else {
                provider = (Templated) prog.getEntity(libraryPath, identifier);
                if (provider == null) throw ValidationException.UnknownIdentifier(identifier, "entity");
            }

            template = provider.getTemplate();
        }

        if (provider == null) {
            throw ValidationException.UnknownIdentifier(toString(), "Interface");
        }

        // validate the reference
        if (params.size() != (template == null ? 0 : template.params.size())) {
            throw ValidationException.FromMessage("Number of params mismatched.");
        }

        // TODO type should also match

        return this;
    }
}
