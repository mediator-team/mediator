package org.fmgroup.mediator.language.entity.system;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.fmgroup.mediator.generator.framework.UtilCode;
import org.fmgroup.mediator.language.*;
import org.fmgroup.mediator.language.entity.Entity;
import org.fmgroup.mediator.language.entity.EntityInterface;
import org.fmgroup.mediator.language.scope.DeclarationCollection;
import org.fmgroup.mediator.language.Template;
import org.fmgroup.mediator.language.entity.PortDeclaration;
import org.fmgroup.mediator.language.scope.Scope;
import org.fmgroup.mediator.language.term.IdValue;

import java.util.ArrayList;
import java.util.List;

public class System implements Entity, Scope, Templated {

    private RawElement parent = null;
    public String name;
    public EntityInterface entityInterface = null;
    public Template template = null;

    public ComponentDeclarationCollection componentCollection = null;

    public List<String> internals = new ArrayList<>();
    public List<Connection> connections = new ArrayList<>();

    @Override
    public RawElement fromContext(ParserRuleContext context) throws ValidationException {
        if (!(context instanceof MediatorLangParser.SystemContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "SystemContext", context.toString());
        }

        name = ((MediatorLangParser.SystemContext) context).name.getText();

        /**
         * order of parsing is very important, otherwise e.g., parameters declared in templates
         * cannot be referred by port types
         */
        if (((MediatorLangParser.SystemContext) context).template() != null) {
            template = new Template();
            template.parse(((MediatorLangParser.SystemContext) context).template(), this);
        }


        entityInterface = new EntityInterface();
        entityInterface.parse(((MediatorLangParser.SystemContext) context).entityInterface(), this);

        componentCollection = new ComponentDeclarationCollection();
        for (MediatorLangParser.ComponentSegmentContext csc : ((MediatorLangParser.SystemContext) context).componentSegment()) {
            componentCollection.parse(csc, this);
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

        return this;
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
        rel += UtilCode.addIndent(componentCollection.toString(), 1);

        if (connections.size() > 0) {
            String connectionSeg = "";
            connectionSeg += "connections {\n";
            for (Connection conn : connections) {
                connectionSeg += UtilCode.addIndent(conn.toString() + "\n", 1);
            }
            connectionSeg += "}\n";

            rel += UtilCode.addIndent(connectionSeg, 1);
        }
        rel += "}";
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
    public EntityInterface getInterface() {
        return entityInterface;
    }

    @Override
    public Template getTemplate() {
        return template;
    }

//    public PortDeclaration locatePort(IdValue portid) {
//        assert portid.scopeIdentifiers.size() == 1;
//        if (portid.scopeIdentifiers.size() == 1) {
//            String compname = portid.scopeIdentifiers.get(0);
//            if (componentCollection.containsKey(compname)) {
//                List<PortDeclaration> portDeclarations = componentCollection.get(compname).provider.getInterface().portDeclarations;
//                for (PortDeclaration p : portDeclarations) {
//                    if (p.names.equals(portid.identifier)) return p;
//                }
//            }
//        }
//
//        // the port can also belong to the system itself
//        if (portid.scopeIdentifiers.size() == 0) {
//            for (PortDeclaration p : this.entityInterface.portDeclarations) {
//                if (p.names.equals(portid.toString())) {
//                    return p;
//                }
//            }
//        }
//        return null;
//    }

    @Override
    public List<DeclarationCollection> getDeclarations() {
        List<DeclarationCollection> result = new ArrayList<>();

        if (template != null) result.add(template);
        if (entityInterface != null) result.add(entityInterface);
        // TODO intervals
        if (componentCollection != null) result.add(componentCollection);

        return result;
    }
}
