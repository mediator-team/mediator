package org.fmgroup.mediator.language.entity.system;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.fmgroup.mediator.generator.framework.UtilCode;
import org.fmgroup.mediator.language.*;
import org.fmgroup.mediator.language.entity.Entity;
import org.fmgroup.mediator.language.entity.EntityInterface;
import org.fmgroup.mediator.language.scope.Declarations;
import org.fmgroup.mediator.language.Template;
import org.fmgroup.mediator.language.entity.PortDeclaration;
import org.fmgroup.mediator.language.scope.Scope;
import org.fmgroup.mediator.language.term.IdValue;
import org.fmgroup.mediator.language.type.IdType;
import org.fmgroup.mediator.language.type.InterfaceType;
import org.fmgroup.mediator.language.type.Type;
import org.fmgroup.mediator.language.type.UtilType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class System implements Entity, Scope {

    private RawElement parent = null;
    public String name;
    public EntityInterface entityInterface = null;
    public Template template = null;

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
        entityInterface = (EntityInterface) new EntityInterface()
                .setParent(this)
                .fromContext(((MediatorLangParser.SystemContext) context).compInterface());

        if (((MediatorLangParser.SystemContext) context).entityTemplate() != null) {
            template = (Template) new Template()
                    .setParent(this)
                    .fromContext(((MediatorLangParser.SystemContext) context).entityTemplate());
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
        String template = this.template == null? "" : this.template.toString();
        if (template.length() > 0) template = "<" + template + "> ";
        String rel = String.format("system %s%s (%s) {\n", template, name, entityInterface.toString());
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
    public EntityInterface getInterface() {
        return entityInterface;
    }

    @Override
    public Template getTemplate() {
        return template;
    }

    public PortDeclaration locatePort(IdValue portid) {
        assert portid.scopeIdentifiers.size() == 1;
        if (portid.scopeIdentifiers.size() == 1) {
            String compname = portid.scopeIdentifiers.get(0);
            if (components.containsKey(compname)) {
                List<PortDeclaration> portDeclarations = components.get(compname).provider.getInterface().portDeclarations;
                for (PortDeclaration p : portDeclarations) {
                    if (p.names.equals(portid.identifier)) return p;
                }
            }
        }

        // the port can also belong to the system itself
        if (portid.scopeIdentifiers.size() == 0) {
            for (PortDeclaration p : this.entityInterface.portDeclarations) {
                if (p.names.equals(portid.toString())) {
                    return p;
                }
            }
        }
        return null;
    }

    @Override
    public List<Declarations> getDeclarations() {
        return null;
    }
}
