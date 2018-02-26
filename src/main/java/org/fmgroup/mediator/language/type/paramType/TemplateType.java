package org.fmgroup.mediator.language.type.paramType;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.fmgroup.mediator.language.*;
import org.fmgroup.mediator.language.generated.MediatorLangParser;
import org.fmgroup.mediator.language.term.CallTerm;
import org.fmgroup.mediator.language.term.Term;
import org.fmgroup.mediator.language.type.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TemplateType implements Type {

    private RawElement parent;

    private List<String> libraryPath;
    private String identifier;
    private Templated provider = null;
    private List<RawElement> params = new ArrayList<>();

    public List<String> getLibraryPath() {
        return libraryPath;
    }

    public TemplateType setLibraryPath(List<String> libraryPath) {
        this.libraryPath = libraryPath;
        return this;
    }

    public String getIdentifier() {
        return identifier;
    }

    public TemplateType setIdentifier(String identifier) throws ValidationException {
        this.identifier = identifier;

        // locate the reference
        Program prog = RawElement.getRoot(this);
        Template template = null;
        if (libraryPath.size() > 0) {
            // TODO look it up in the dependencies
            throw ValidationException.UnderDevelopment();
        } else {

            if (parent instanceof CallTerm) {
                provider = prog.getFunction(libraryPath, identifier);
                if (provider == null) throw ValidationException.UnknownIdentifier(identifier, "function");
            } else {
                provider = prog.getEntity(libraryPath, identifier);
                if (provider == null) throw ValidationException.UnknownIdentifier(identifier, "entity");
            }

            template = provider.getTemplate();
        }

        if (provider == null) {
            throw ValidationException.UnknownIdentifier(toString(), "Interface");
        }

        // validate the reference
        if (params.size() != (template == null ? 0 : template.getDeclarationList().size())) {
            throw ValidationException.FromMessage("Number of params mismatched.");
        }

        return this;
    }

    public List<RawElement> getParams() {
        return params;
    }

    public TemplateType addParam(RawElement param) {
        params.add(param);
        param.setParent(this);
        return this;
    }

    public TemplateType setParams(List<RawElement> params) {
        this.params = new ArrayList<>();
        params.forEach(this::addParam);
        return this;
    }

    public Templated getProvider() {
        return provider;
    }

    @Override
    public TemplateType fromContext(ParserRuleContext context, RawElement parent) throws ValidationException {
        setParent(parent);

        if (context instanceof MediatorLangParser.TemplateTypeContext) {
            for (MediatorLangParser.TypeorvalueContext tov : ((MediatorLangParser.TemplateTypeContext) context).typeorvalue()) {
                if (tov.type() == null) {
                    // it is a value
                    params.add(Term.parseValue(tov.value(), this));
                } else {
                    params.add(Type.parse(tov.type(), this));
                }
            }

            setLibraryPath(((MediatorLangParser.TemplateTypeContext) context).scopedID().scopes.stream()
                    .map(Token::getText)
                    .collect(Collectors.toList()));

            setIdentifier(((MediatorLangParser.TemplateTypeContext) context).scopedID().identifier.getText());
        } else if (context instanceof MediatorLangParser.IdTypeContext) {
            setLibraryPath(((MediatorLangParser.IdTypeContext) context).scopedID().scopes.stream()
                    .map(Token::getText)
                    .collect(Collectors.toList()));

            setIdentifier(((MediatorLangParser.IdTypeContext) context).scopedID().identifier.getText());
        } else {
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
    public TemplateType setParent(RawElement parent) {
        this.parent = parent;
        return this;
    }

    @Override
    public TemplateType copy(RawElement parent) throws ValidationException {
        TemplateType nit = new TemplateType();
        nit.setParent(parent);

        for (RawElement elem : this.params) {
            nit.addParam(elem.copy(nit));
        }

        nit.setLibraryPath(getLibraryPath());
        nit.setIdentifier(getIdentifier());

        return nit;
    }

    @Override
    public TemplateType refactor(Map<String, Type> typeRewriteMap, Map<String, Term> termRewriteMap) throws ValidationException {
        return this;
    }

    public Templated getProviderWithNoTemplate() throws ValidationException {
        return this.getProvider().resolveTemplate(this.getParams());
    }
}
