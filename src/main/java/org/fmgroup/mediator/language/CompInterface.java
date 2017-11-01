package org.fmgroup.mediator.language;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.fmgroup.mediator.language.type.Type;
import org.fmgroup.mediator.language.type.UtilType;

import java.util.ArrayList;
import java.util.List;

public class CompInterface implements RawElement {

    private RawElement parent;

    public List<Port> ports = new ArrayList<>();

    CompInterface () {}

    public CompInterface(CompInterface old, InterfacedElement newParent) {
        this.parent = (RawElement) newParent;
        for (Port p : old.ports) {
            ports.add(new Port(p, newParent));
        }
    }

    @Override
    public RawElement fromContext(ParserRuleContext context) throws ValidationException {
        if (!(context instanceof MediatorLangParser.CompInterfaceContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "CompInterfaceContext", context.toString());
        }

        for (MediatorLangParser.PortsDeclContext pdc : ((MediatorLangParser.CompInterfaceContext) context).portsDecl()) {
            for (TerminalNode name : pdc.ID()) {
                Port p = new Port();
                p.name = name.getText();
                p.parent = (InterfacedElement) this.parent;
                p.direction = pdc.direction.getText().equals("in") ? PortDirection.IN : PortDirection.OUT;
                p.type = UtilType.parse(pdc.type(), this);

                ports.add(p);
            }
        }

        return this.validate();
    }

    @Override
    public String toString() {
        String rel = "";
        for (Port p : ports) {
            if (rel.length() > 0) rel += ", ";
            rel += String.format("%s : %s %s", p.name, p.direction.toString(), p.type.toString());
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
    public RawElement clone(RawElement parent) {
        return null;
    }

    @Override
    public RawElement validate() throws ValidationException {
        // TODO
        return this;
    }
}
