package org.fmgroup.mediator.language.entity.system;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.core.antlr.Parser;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.Templated;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.entity.PortIdentifier;
import org.fmgroup.mediator.language.entity.automaton.Automaton;
import org.fmgroup.mediator.language.generated.MediatorLangParser;
import org.fmgroup.mediator.language.term.IntValue;
import org.fmgroup.mediator.language.term.Term;
import org.fmgroup.mediator.language.type.Type;
import org.fmgroup.mediator.language.type.paramType.AbstractType;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BasicConnection extends Connection {
    private Options options = null;
    private List<PortIdentifier> inPorts = new ArrayList<>();
    private List<PortIdentifier> outPorts = new ArrayList<>();

    private Automaton provider = null;
    private Term capacity = null;
    private Type type = new AbstractType();

    @Override
    public BasicConnection fromContext(ParserRuleContext context, RawElement parent) throws ValidationException {
        if (!(context instanceof MediatorLangParser.BasicConnectionContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "BasicConnectionContext", context.toString());
        }

        setParent(parent);

        for (MediatorLangParser.PortIdentifierContext portContext : ((MediatorLangParser.BasicConnectionContext) context).inPorts.portIdentifier()) {
            PortIdentifier portId = new PortIdentifier().fromContext(portContext, this);
            this.inPorts.add(portId);
            this.portIdentifiers.add(portId);
        }

        for (MediatorLangParser.PortIdentifierContext portContext : ((MediatorLangParser.BasicConnectionContext) context).outPorts.portIdentifier()) {
            PortIdentifier portId = new PortIdentifier().fromContext(portContext, this);
            this.outPorts.add(portId);
            this.portIdentifiers.add(portId);
        }

        this.options = new Options().fromContext(((MediatorLangParser.BasicConnectionContext) context).connectionOptions(), this);

        this.buildProvider();
        return this;
    }

    private void buildProvider() throws ValidationException {
        String ports = "";
        String variables = "";
        String transitions = "";
        String extTransitions = "";

        Stream<Integer> inputPortIndexStream = Stream.iterate(0, item -> item + 1).limit(inPorts.size());
        Stream<Integer> outputPortIndexStream = Stream.iterate(0, item -> item + 1).limit(outPorts.size());

        ports += String.join(",",
                inputPortIndexStream
                    .map(i -> String.format("_AG_PI%d", i))
                    .collect(Collectors.toList())
        );
        ports += ": in T, ";
        ports += String.join(",",
                outputPortIndexStream
                        .map(i -> String.format("_AG_PO%d", i))
                        .collect(Collectors.toList())
        );
        ports += ": out T";

        if (options.contains("async")) variables = String.format(
                        "buf  : (T | NULL) [bufsize] init null;" +
                        "front: int 0 .. bufsize - 1 init 0;" +
                        "rear : int 0 .. bufsize - 1 init 0;"

        );

        if (options.contains("async")) {
            this.capacity = options.get("capacity");

            for (int i = 0; i < inPorts.size(); i ++) {
                transitions += String.format(
                        "(_AG_PI%d.reqRead != (buf[rear] == null)) -> _AG_PI%d.reqRead = buf[rear] == null;", i, i
                );

                extTransitions += String.format(
                        "true -> {" +
                                "sync _AG_PI%d;" +
                                "buf[rear] = _AG_PI%d.value;" +
                                "rear = (rear + 1) %% bufsize;" +
                                "} ",
                        i, i
                );
            }
            for (int j = 0; j < outPorts.size(); j ++) {
                transitions += String.format(
                        "(_AG_PO%d.reqWrite != (buf[front] != null)) -> _AG_PI%d.reqWrite = buf[front] != null;", j, j
                );


            }

            if (options.contains("unicast")) {
                for (int j = 0; j < outPorts.size(); j ++) {
                    extTransitions += String.format(
                            "true -> {" +
                                    "_AG_PO%d.value = buf[front];" +
                                    "front = (front + 1) %% bufsize;" +
                                    "sync _AG_PO%d;" +
                                    "} ",
                            j, j
                    );
                }
            } else {
                String tmpExtTrans = "";
                for (int j = 0; j < outPorts.size(); j ++) {
                    tmpExtTrans += String.format(
                            "_AG_PO%d.value = buf[front];" +
                            "sync _AG_PO%d;",
                            j, j
                    );
                }

                tmpExtTrans += "front = (front + 1) % bufsize;";
                extTransitions += String.format("true -> {%s}", tmpExtTrans);
            }

        } else {
            this.capacity = new IntValue().setParent(this).setValue(0);
            // generate internal transitions

            // update reqwrite of output ports
            for (int i = 0; i < inPorts.size(); i ++) {
                for (int j = 0; j < outPorts.size(); j ++) {
                    transitions += String.format(
                            "(_AG_PO%d.reqWrite != _AG_PI%d.reqWrite) -> _AG_PO%d.reqWrite = _AG_PI%d.reqWrite;",
                            j, i, j, i
                    );
                }
            }

            // update reqread of input ports
            if (options.contains("unicast")) {
                // unicast transition
                for (int i = 0; i < inPorts.size(); i ++) {
                    for (int j = 0; j < outPorts.size(); j ++) {
                        transitions += String.format(
                                "(_AG_PI%d.reqRead != _AG_PO%d.reqRead) -> _AG_PI%d.reqRead = _AG_PO%d.reqRead;",
                                i, j, i, j
                        );

                        extTransitions += String.format(
                                "true -> {" +
                                        "sync _AG_PI%d;" +
                                        "_AG_PO%d.value = _AG_PI%d.value;" +
                                        "sync _AG_PO%d;" +
                                        "}",
                                i, j, i, j
                        );
                    }
                }
            } else {
                // broadcast transition
                for (int i = 0; i < inPorts.size(); i ++) {
                    String sourceCond = String.format("_AG_PI%d.reqRead", i);
                    String targetCond = "true";

                    String tmpExtTran = String.format("sync _AG_PI%d;", i);
                    for (int j = 0; j < outPorts.size(); j ++) {
                        targetCond = String.format(
                                "(%s && _AG_PO%d.reqRead)",
                                targetCond,
                                j
                        );
                        tmpExtTran += String.format(
                                "_AG_PO%d.value = _AG_PI%d.value; sync _AG_PO%d;", j, i, j
                        );
                    }

                    transitions += String.format(
                            "%s != %s -> %s = %s;",
                            sourceCond, targetCond,
                            sourceCond, targetCond
                    );

                    extTransitions += String.format(
                            "true -> {%s}", tmpExtTran
                    );
                }
            }
        }

        String providerText = String.format(
                "automaton <T:type, bufsize:int> CONN(%s) {\n%s%s\n}\n",
                ports,
                String.format("variables {%s}", variables),
                String.format(
                        "transitions {%s group {%s}}",
                        transitions,
                        extTransitions
                )
        );

        // parse the generated automaton
        try {
            MediatorLangParser.AutomatonContext context = Parser.getParserFromString(providerText).automaton();
            this.provider = new Automaton().fromContext(context, this.getTopScope());
        } catch (IOException e) {
            e.printStackTrace();
        }

//        java.lang.System.out.println(this.provider.toString());
    }

    @Override
    public Templated getProvider() {
        return this.provider;
    }

    @Override
    public List<RawElement> getParams() {
        List<RawElement> params = new ArrayList<>();
        params.add(type);
        params.add(capacity);
        return params;
    }

    @Override
    public String toString() {
        String inp = String.join(
                ",",
                this.inPorts.stream().map(PortIdentifier::toString).collect(Collectors.toList())
                );

        if (this.inPorts.size() > 1) inp = "(" + inp + ")";

        String outp = String.join(
                ",",
                this.outPorts.stream().map(PortIdentifier::toString).collect(Collectors.toList())
        );

        if (this.outPorts.size() > 1) outp = "(" + outp + ")";

        if (options.isEmpty()) return inp + " -> " + outp;
        else
            return String.format(
                    "%s --(%s)-> %s",
                    inp,
                    options.toString(),
                    outp
            );
    }
}
