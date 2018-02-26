package org.fmgroup.mediator.language.term;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.common.UtilCode;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.generated.MediatorLangParser;
import org.fmgroup.mediator.language.type.Type;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class StructTerm implements Term {
    private RawElement parent = null;

    public Map<String, Term> getFields() {
        return fields;
    }

    public StructTerm addField(String name, Term term) throws ValidationException {
        if (fields.containsKey(name)) {
            throw ValidationException.DumplicatedIdentifier(name, "field name");
        }

        fields.put(name, term);
        term.setParent(this);
        return this;
    }

    public StructTerm setFields(Map<String, Term> fields) {
        this.fields = fields;
        return this;
    }

    private Map<String, Term> fields = new HashMap<>();

    @Override
    public int getPrecedence() {
        return 13;
    }

    @Override
    public StructTerm fromContext(ParserRuleContext context, RawElement parent) throws ValidationException {
        setParent(parent);

        if (!(context instanceof MediatorLangParser.StructTermContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "StructTermContext", context.toString());
        }

        // number of field names should always be equal to the number of field values
        assert ((MediatorLangParser.StructTermContext) context).ID().size() == ((MediatorLangParser.StructTermContext) context).term().size();

        for (int i = 0; i < ((MediatorLangParser.StructTermContext) context).ID().size(); i ++) {
            addField(
                    ((MediatorLangParser.StructTermContext) context).ID(i).getText(),
                    Term.parse(((MediatorLangParser.StructTermContext) context).term(i), this)
            );
        }
        return this;
    }

    @Override
    public String toString() {
        String result = String.format(
                "{ %s }",
                fields.keySet().stream().map(
                        key -> String.format(
                                    "%s = %s",
                                    key,
                                    fields.get(key).toString()
                            )
                ).collect(Collectors.joining(", "))
        );

        // needs more attention
        if (result.length() > 40) result = String.format(
                "{\n%s\n}",
                UtilCode.addIndent(
                        fields.keySet().stream().map(
                                key -> String.format(
                                        "%s = %s",
                                        key,
                                        fields.get(key).toString()
                                )
                        ).collect(Collectors.joining(",\n")),
                        1
                )
        );

        return result;
    }

    @Override
    public Term refactor(Map<String, Type> typeRewriteMap, Map<String, Term> termRewriteMap) throws ValidationException {
        for (Term t: this.getFields().values()) {
            t.refactor(typeRewriteMap, termRewriteMap);
        }

        return this;
    }

    @Override
    public RawElement getParent() {
        return parent;
    }

    @Override
    public StructTerm setParent(RawElement parent) {
        this.parent = parent;
        return this;
    }
}
