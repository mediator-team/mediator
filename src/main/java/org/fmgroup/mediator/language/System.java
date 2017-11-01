package org.fmgroup.mediator.language;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.fmgroup.mediator.generator.framework.UtilCode;
import org.fmgroup.mediator.language.term.IdValue;
import org.fmgroup.mediator.language.type.IdType;
import org.fmgroup.mediator.language.type.InterfaceType;
import org.fmgroup.mediator.language.type.Type;
import org.fmgroup.mediator.language.type.UtilType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class System implements InterfacedElement {

    private RawElement parent = null;
    public String name;
    public CompInterface compInterface = null;
    public CompTemplate compTemplate = null;

    public Map<String, InterfaceType> components = new HashMap<>();
    public List<String> internals = new ArrayList<>();
    public List<Connection> connections = new ArrayList<>();

    public Map<String, Type> internalsType = new HashMap<>();

    @Override
    public RawElement fromContext(ParserRuleContext context) throws ValidationException {
        if (!(context instanceof MediatorLangParser.SystemContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "SystemContext", context.toString());
        }

        name = ((MediatorLangParser.SystemContext) context).name.getText();
        compInterface = (CompInterface) new CompInterface()
                .setParent(this)
                .fromContext(((MediatorLangParser.SystemContext) context).compInterface());

        if (((MediatorLangParser.SystemContext) context).compTemplate() != null) {
            compTemplate = (CompTemplate) new CompTemplate()
                    .setParent(this)
                    .fromContext(((MediatorLangParser.SystemContext) context).compTemplate());
        }

        for (MediatorLangParser.ComponentSegmentContext csc : ((MediatorLangParser.SystemContext) context).componentSegment()) {
            for (MediatorLangParser.ComponentDeclContext comp : csc.componentDecl()) {
                Type iftype = UtilType.parse(comp.type(), this);
                if (!(iftype instanceof InterfaceType) && !(iftype instanceof IdType)) {
                    throw ValidationException.UnexpectedType(this.getClass(), iftype.getClass(), "InterfaceType", "Components");
                }
                if (iftype instanceof IdType) {
                    InterfaceType _iftype = (InterfaceType) new InterfaceType().setParent(iftype.getParent());
                    _iftype.reference = (IdValue) new IdValue().setIdentifier(((IdType) iftype).identifier).setParent(_iftype);
                    iftype = _iftype;
                    iftype.validate();
                }
                for (TerminalNode name : comp.ID()) {
                    components.put(name.getText(), (InterfaceType) iftype);
                }
            }
        }

        for (MediatorLangParser.InternalSegmentContext isc : ((MediatorLangParser.SystemContext) context).internalSegment()) {
            for (TerminalNode t : isc.ID()) {
                internals.add(t.getText());
            }
        }

        for (MediatorLangParser.ConnectionSegmentContext csc : ((MediatorLangParser.SystemContext) context).connectionSegment()) {
            for (MediatorLangParser.ConnectionDeclContext conn : csc.connectionDecl()) {
                connections.add((Connection) new Connection().setParent(this).fromContext(conn));
            }
        }

        return this.validate();
    }

    @Override
    public String toString() {
        String template = compTemplate == null? "" : compTemplate.toString();
        if (template.length() > 0) template = "<" + template + "> ";
        String rel = String.format("system %s%s (%s) {\n", template, name, compInterface.toString());
        if (internals.size() > 0) {
            rel += UtilCode.addIndent(
                    "internal {\n" +
                        UtilCode.addIndent(String.join(", ", internals), 1) + ";\n"
                        + "}\n",
                    1
            );
        }
        if (components.size() > 0) {
            String componentSeg = "";
            componentSeg += "components {\n";

            for (String name : components.keySet()) {
                componentSeg += UtilCode.addIndent(
                        name + ": " + components.get(name).toString() + ";\n",
                        1
                );
            }
            componentSeg += "}\n";

            rel += UtilCode.addIndent(componentSeg, 1);
        }
        if (connections.size() > 0) {
            String connectionSeg = "";
            connectionSeg += "connections {\n";
            for (Connection conn : connections) {
                connectionSeg += UtilCode.addIndent(conn.toString() + "\n", 1);
            }
            connectionSeg += "}\n";

            rel += UtilCode.addIndent(connectionSeg, 1);
        }
        rel += "}\n";
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

    @Override
    public CompInterface getInterface() {
        return compInterface;
    }

    @Override
    public CompTemplate getTemplate() {
        return compTemplate;
    }

    public Port locatePort(IdValue portid) {
        assert portid.scopes.size() == 1;
        if (portid.scopes.size() == 1) {
            String compname = portid.scopes.get(0);
            if (components.containsKey(compname)) {
                List<Port> ports = components.get(compname).provider.getInterface().ports;
                for (Port p : ports) {
                    if (p.name.equals(portid.identifier)) return p;
                }
            }
        }

        // the port can also belong to the system itself
        if (portid.scopes.size() == 0) {
            for (Port p : this.compInterface.ports) {
                if (p.name.equals(portid.toString())) {
                    return p;
                }
            }
        }
        return null;
    }
}
