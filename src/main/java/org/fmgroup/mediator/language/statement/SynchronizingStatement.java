package org.fmgroup.mediator.language.statement;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.MediatorLangParser;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.entity.PortIdentifier;

import java.util.ArrayList;
import java.util.List;


public class SynchronizingStatement implements Statement {

    public RawElement parent = null;
    public List<PortIdentifier> synchronizedPorts = new ArrayList<>();

    @Override
    public RawElement fromContext(ParserRuleContext context) throws ValidationException {
        if (!(context instanceof MediatorLangParser.SynchronizingStatementContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "SynchronizingStatementContext", context.toString());
        }

        for (MediatorLangParser.PortIdentifierContext portid : ((MediatorLangParser.SynchronizingStatementContext) context).portIdentifier()) {
            this.synchronizedPorts.add(
                    (PortIdentifier) new PortIdentifier().parse(portid, this)
            );
        }

        return this.validate();
    }

    public List<SynchronizingStatement> split() throws ValidationException {
        List<SynchronizingStatement> newStmts = new ArrayList<>();
        for (PortIdentifier port : synchronizedPorts) {
            newStmts.add(
                    (SynchronizingStatement) new SynchronizingStatement().addPort(port).setParent(this.parent)
            );
        }

        return newStmts;
    }

    @Override
    public boolean equals(Object obj) {
        return
                this.toString().equals(obj.toString()) &&
                        obj instanceof Statement;
    }

    @Override
    public String toString() {
        assert synchronizedPorts.size() > 0;

        String rel = "sync ";
        for (int i = 0; i < synchronizedPorts.size(); i ++) {
            if (i > 0) rel += ",";
            rel += synchronizedPorts.get(i);
        }
        return rel + ";";
    }

    public SynchronizingStatement addPort(PortIdentifier port) throws ValidationException {
        this.synchronizedPorts.add((PortIdentifier) port.clone(this));
        return this;
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
        SynchronizingStatement nss = new SynchronizingStatement();
        nss.setParent(parent);
        nss.synchronizedPorts = new ArrayList<>(this.synchronizedPorts);
        return nss.validate();
    }

    @Override
    public RawElement validate() throws ValidationException {
        /*
        1. you cannot synchronize two portDeclarations at the same time
        2. all portDeclarations are correctly declared in the interface
        */

        return this;
    }

}
