package org.fmgroup.mediator.language.entity.system;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.common.UtilCode;
import org.fmgroup.mediator.language.*;
import org.fmgroup.mediator.language.entity.Entity;
import org.fmgroup.mediator.language.entity.EntityInterface;
import org.fmgroup.mediator.language.generated.MediatorLangParser;
import org.fmgroup.mediator.language.scope.DeclarationCollection;
import org.fmgroup.mediator.language.scope.Scope;
import org.fmgroup.mediator.language.term.Term;
import org.fmgroup.mediator.language.type.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class System implements Entity, Scope, Templated {

    private RawElement parent = null;
    private String name;
    private EntityInterface entityInterface = null;
    private Template template = null;
    private ComponentDeclarationCollection componentCollection = null;
    private InternalDeclarationCollection internalCollection = null;
    private List<Connection> connections = new ArrayList<>();
    private Meta meta = null;

    public Meta getMeta() {
        return meta;
    }

    public System setMeta(Meta meta) {
        this.meta = meta;
        return this;
    }

    public EntityInterface getEntityInterface() {
        return entityInterface;
    }

    public System setEntityInterface(EntityInterface entityInterface) {
        this.entityInterface = entityInterface;
        entityInterface.setParent(this);
        return this;
    }

    public ComponentDeclarationCollection getComponentCollection() {
        return componentCollection;
    }

    public System setComponentCollection(ComponentDeclarationCollection componentCollection) {
        this.componentCollection = componentCollection;
        componentCollection.setParent(this);
        return this;
    }

    public InternalDeclarationCollection getInternalCollection() {
        return internalCollection;
    }

    public System setInternalCollection(InternalDeclarationCollection internalCollection) {
        this.internalCollection = internalCollection;
        internalCollection.setParent(this);
        return this;
    }

    public List<Connection> getConnections() {
        return connections;
    }

    public System setConnections(List<CustomConnection> connections) {
        this.connections = new ArrayList<>();
        connections.forEach(this::addConnection);
        return this;
    }

    public System addConnection(CustomConnection connection) {
        this.connections.add(connection);
        connection.setParent(this);
        return this;
    }

    @Override
    public String getName() {
        return name;
    }

    public System setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public System fromContext(ParserRuleContext context, RawElement parent) throws ValidationException {
        if (!(context instanceof MediatorLangParser.SystemContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "SystemContext", context.toString());
        }

        setParent(parent);
        setName(((MediatorLangParser.SystemContext) context).name.getText());

        /**
         * order of parsing is very important, otherwise e.g., parameters declared in templates
         * cannot be referred by port types
         */
        setTemplate(
                new Template().fromContext(
                        ((MediatorLangParser.SystemContext) context).template(),
                        this
                )
        );

        setEntityInterface(
                new EntityInterface().fromContext(
                        ((MediatorLangParser.SystemContext) context).entityInterface(),
                        this
                )
        );

        setComponentCollection(new ComponentDeclarationCollection());
        for (MediatorLangParser.ComponentSegmentContext csc : ((MediatorLangParser.SystemContext) context).componentSegment()) {
            getComponentCollection().fromContext(csc, this);
        }

        setInternalCollection(new InternalDeclarationCollection());
        for (MediatorLangParser.InternalSegmentContext isc : ((MediatorLangParser.SystemContext) context).internalSegment()) {
            getInternalCollection().fromContext(isc, this);
        }

        for (MediatorLangParser.ConnectionSegmentContext csc : ((MediatorLangParser.SystemContext) context).connectionSegment()) {
            for (MediatorLangParser.ConnectionDeclContext conn : csc.connectionDecl()) {
                if (conn instanceof MediatorLangParser.CustomConnectionContext) {
                    connections.add(new CustomConnection().fromContext(conn, this));
                } else if (conn instanceof MediatorLangParser.BasicConnectionContext) {
                    connections.add(new BasicConnection().fromContext(conn, this));
                }
            }
        }

        if (((MediatorLangParser.SystemContext) context).meta() != null)
            setMeta(new Meta().fromContext(((MediatorLangParser.SystemContext) context).meta(), this));

        return this;
    }

    @Override
    public String toString() {
        String template = "";
        if (this.template != null) template = this.template.toString();

        String rel = String.format("system %s%s (%s) {\n", template, name, entityInterface.toString());

        rel += UtilCode.addIndent(componentCollection.toString(), 1);
        rel += UtilCode.addIndent(internalCollection.toString(), 1);

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

        if (getMeta() != null) rel += " " + getMeta().toString();

        return rel;
    }

    @Override
    public RawElement getParent() {
        return parent;
    }

    @Override
    public RawElement setParent(RawElement parent) {
        this.parent = parent;
        return this;
    }

    @Override
    public EntityInterface getInterface() {
        return entityInterface;
    }

    @Override
    public Template getTemplate() {
        if (template == null) return new Template().setParent(this);
        return template;
    }

    @Override
    public Templated refactor(Map<String, Type> typeRewriteMap, Map<String, Term> termRewriteMap) throws ValidationException {
        throw ValidationException.UnderDevelopment();
    }


    public System setTemplate(Template template) {
        this.template = template;
        return this;
    }

    @Override
    public List<DeclarationCollection> getDeclarations() {
        List<DeclarationCollection> result = new ArrayList<>();

        if (template != null) result.add(template);
        if (entityInterface != null) result.add(entityInterface);
        if (internalCollection != null) result.add(internalCollection);
        if (componentCollection != null) result.add(componentCollection);

        return result;
    }
}
