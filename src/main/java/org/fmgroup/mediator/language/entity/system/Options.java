package org.fmgroup.mediator.language.entity.system;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.generated.MediatorLangParser;
import org.fmgroup.mediator.language.term.Term;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Options implements RawElement {

    private RawElement parent;
    /**
     * <i>items</i> contains the option items in a basic connection
     * <ul>
     *     <li>items[key] == null means that the option is specified but with no parameter</li>
     *     <li>items[key] == val means that the option is specified with a parameter</li>
     * </ul>
     */
    private Map<String, Term> items = new HashMap<>();

    @Override
    public RawElement getParent() {
        return this.parent;
    }

    @Override
    public Options setParent(RawElement parent) {
        this.parent = parent;
        return this;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public boolean contains(String key) {
        return items.containsKey(key);
    }

    public Term get(String key) {
        return items.get(key);
    }

    @Override
    public Options fromContext(ParserRuleContext context, RawElement parent) throws ValidationException {
        if (!(context instanceof MediatorLangParser.ConnectionOptionsContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "ProgContext", context.toString());
        }
        setParent(parent);

        for (MediatorLangParser.ConnectionOptionContext opt : ((MediatorLangParser.ConnectionOptionsContext) context).connectionOption()) {
            if (opt.term() == null) {
                this.items.put(opt.connectionOptionItem().getText(), null);
            } else {
                this.items.put(
                        opt.connectionOptionItem().getText(),
                        Term.parse(opt.term(), this)
                );
            }
        }

        return this;
    }

    @Override
    public String toString() {
        return String.join(
                ",",
                items.entrySet().stream().map(
                        stringTermEntry -> stringTermEntry.getKey() +
                                (stringTermEntry.getValue() == null ? "" : " = " + stringTermEntry.getValue().toString())
                ).collect(Collectors.toList())
        );
    }
}
