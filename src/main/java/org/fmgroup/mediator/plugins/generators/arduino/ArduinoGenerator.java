package org.fmgroup.mediator.plugins.generators.arduino;

import org.fmgroup.mediator.common.UtilCode;
import org.fmgroup.mediator.plugins.scheduler.Scheduler;
import org.fmgroup.mediator.language.Program;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.entity.Entity;
import org.fmgroup.mediator.language.entity.automaton.Automaton;
import org.fmgroup.mediator.language.entity.automaton.Transition;
import org.fmgroup.mediator.language.entity.automaton.TransitionGroup;
import org.fmgroup.mediator.language.entity.automaton.TransitionSingle;
import org.fmgroup.mediator.language.entity.system.System;
import org.fmgroup.mediator.language.scope.Declaration;
import org.fmgroup.mediator.language.scope.TypeDeclaration;
import org.fmgroup.mediator.language.scope.VariableDeclaration;
import org.fmgroup.mediator.language.statement.AssignmentStatement;
import org.fmgroup.mediator.language.statement.IteStatement;
import org.fmgroup.mediator.language.statement.Statement;
import org.fmgroup.mediator.language.statement.SynchronizingStatement;
import org.fmgroup.mediator.language.term.*;
import org.fmgroup.mediator.language.type.*;
import org.fmgroup.mediator.language.type.termType.*;
import org.fmgroup.mediator.plugin.generator.FileSet;
import org.fmgroup.mediator.plugin.generator.Generator;

import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

enum ArduinoPinDirection {
    IN,
    OUT
}

public class ArduinoGenerator implements Generator {

    private Map<Integer, ArduinoPinDirection> pinStatus = new HashMap<>();

    public String entityGenerate(Entity elem) throws ArduinoGeneratorException {

        pinStatus = new HashMap<>();

        if (elem instanceof Automaton) {
            try {
                return String.format(
                        "%s\n%s",
                        typedefGenerate((Program) elem.getParent()),
                        automatonGenerate((Automaton) elem)
                );
            } catch (ValidationException e) {
                e.printStackTrace();
            }
        } else if (elem instanceof System) {
            try {
                return entityGenerate(Scheduler.Schedule((System) elem));
            } catch (ValidationException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public FileSet generate(RawElement elem) throws ArduinoGeneratorException {
        // todo put dependencies
        FileSet files = new FileSet();
        if (elem instanceof Entity) {
            try {
                files.add(((Entity) elem).getName() + ".c", entityGenerate((Entity) elem));
            } catch (FileAlreadyExistsException e) {
                e.printStackTrace();
            }

            return files;
        } else {
            throw new ArduinoGeneratorException(String.format(
                    "unsupport language element %s",
                    elem.getClass().getName()
            ));
        }
    }

    @Override
    public String getSupportedPlatform() {
        return "arduino";
    }

    private String typedefGenerate(Program p) throws ArduinoGeneratorException {
        String code = "";
        // TODO only CommandGenerate typedefs used

        for (Declaration typedecl : p.getTypedefs().getDeclarationList()) {
            assert typedecl instanceof TypeDeclaration;
            code += String.format(
                    "typedef %s %s;\n",
                    typeGenerate(((TypeDeclaration) typedecl).getType()),
                    String.join(",", typedecl.getIdentifiers())
            );
        }

        return code;
    }

    private String automatonGenerate(Automaton a) throws ArduinoGeneratorException, ValidationException {

        if (a.getEntityInterface().getDeclarationList().size() > 0) {
            throw ArduinoGeneratorException.UnclosedEntity(a);
        }

        String prog = "";
        String globalDeclarations = "";
        String setup = "";
        String loop = "";

        for (Declaration var : a.getLocalVars().getDeclarationList()) {
            assert var instanceof VariableDeclaration;
            String strType = typeGenerate(((VariableDeclaration) var).getType());
            for (String name : var.getIdentifiers()) {
                if (!strType.contains("%s")) {
                    strType += " %s";
                }

                strType += ";\n";
                globalDeclarations += String.format(strType, name);
            }
        }

        globalDeclarations += String.format(
                "\nint cmd_activated[%d];\nint cmd_activated_counter;\n",
                ((TransitionGroup) a.getTransitions().get(0)).getTransitions().size()
        );

        globalDeclarations += "int cmd;\n";

        // CommandGenerate setup
        for (Declaration var : a.getLocalVars().getDeclarationList()) {
            assert var instanceof VariableDeclaration;
            for (String name : var.getIdentifiers()) {
                setup += String.format(
                        "%s = %s;\n",
                        name,
                        termGenerate(((VariableDeclaration) var).getType().getInitValue(), 0)
                );
            }
        }

        // CommandGenerate loop

        // we assume that the automaton has been canonicalized already
        assert a.getTransitions().size() == 1;
        assert a.getTransitions().get(0) instanceof TransitionGroup;

        loop += String.format(
                "cmd_activated_counter = 0;\n",
                ((TransitionGroup) a.getTransitions().get(0)).getTransitions().size()
        );

        String conditionCheck = "";
        String transitionExecution = "";

        for (Transition t : ((TransitionGroup) a.getTransitions().get(0)).getTransitions()) {
            assert t instanceof TransitionSingle;

            int index = ((TransitionGroup) a.getTransitions().get(0)).getTransitions().indexOf(t);
            conditionCheck += String.format(
                    // FIXME how to make it looks better?
                    "if (%s) {\n\tcmd_activated[cmd_activated_counter] = %d;\n\tcmd_activated_counter ++;\n}\n",
                    termGenerate(((TransitionSingle) t).getGuard(), 0),
                    index
            );

            transitionExecution += String.format(
                    "if (cmd == %d) {\n%s\n}\n",
                    index,
                    UtilCode.addIndent(
                            statementGenerate(((TransitionSingle) t).getStatements()),
                            1
                    )
            );

        }

        // which transitions are activated ?
        loop += conditionCheck;
        loop += "cmd = cmd_activated[random(cmd_activated_counter)];\n";

        loop += transitionExecution;

        // after all transitions generated, now we analyze the pin directions
        for (Integer pin : pinStatus.keySet()) {
            if (pinStatus.get(pin).equals(ArduinoPinDirection.IN)) {
                setup += String.format("pinMode(%d, INPUT);\n", pin);
            } else {
                setup += String.format("pinMode(%d, OUTPUT);\n", pin);
            }
        }

        prog = String.format(
                "%s\nvoid setup() {\n%s}\n\nvoid loop() {\n%s}\n",
                globalDeclarations,
                UtilCode.addIndent(setup, 1),
                UtilCode.addIndent(loop, 1)
        );

        return prog;
    }

    private String statementGenerate(List<Statement> statements) throws ArduinoGeneratorException, ValidationException {
        String rel = "";
        for (Statement s : statements) {
            if (rel.length() > 0) rel += "\n";

            if (s instanceof SynchronizingStatement) {
                java.lang.System.err.println("A sync statement is not supposed to show up when generating codes.");
            } else if (s instanceof AssignmentStatement) {

                if (((AssignmentStatement) s).getTarget() == null) {
                    rel += termGenerate(((AssignmentStatement) s).getExpr(), 0) + ";";
                } else {
                    rel += termGenerate(((AssignmentStatement) s).getTarget(), 0) +
                            " = " +
                            termGenerate(((AssignmentStatement) s).getExpr(), 0) + ";";

                    String assertion = termAssertionGenerate(((AssignmentStatement) s).getTarget());
                    if (assertion.length() > 0) {
                        rel += "\n" + assertion;
                    }
                }
            } else if (s instanceof IteStatement) {
                rel += String.format(
                        "if (%s) {\n%s\n}",
                        termGenerate(((IteStatement) s).getCondition(), 0),
                        UtilCode.addIndent(statementGenerate(((IteStatement) s).getThenStmts()), 1)
                );

                if (((IteStatement) s).getElseStmts().size() > 0) {
                    rel += String.format(
                            " else {\n%s\n}",
                            UtilCode.addIndent(statementGenerate(((IteStatement) s).getElseStmts()), 1)
                    );
                }
            } else {
                throw ArduinoGeneratorException.UnhandledStatement(s);
            }
        }
        return rel;
    }

    private String typeGenerate(Type t) throws ArduinoGeneratorException {
        if (t instanceof BoundedIntType || t instanceof IntType) {
            return "int";
        }
        if (t instanceof DoubleType) return "double";
        if (t instanceof ListType) {
            if (((ListType) t).getCapacity() != null) {
                // TODO: recheck the precedence between terms and types
                return typeGenerate(((ListType) t).getBaseType()) + " %s[" + termGenerate(((ListType) t).getCapacity(), 0) + "]";
            }
            return typeGenerate(((ListType) t).getBaseType()) + " * %s";
        }
        if (t instanceof InitType) return typeGenerate(((InitType) t).getBaseType());
        if (t instanceof IdType) {
            // TODO
            return ((IdType) t).getIdentifier();
        }
        if (t instanceof EnumType) {
            return String.format("enum {%s}", String.join(",", ((EnumType) t).getItems()));
        }
        if (t instanceof BoolType) return "bool";

        throw ArduinoGeneratorException.UnhandledType(t);
    }

    private String termGenerate(Term t, int parentPrecedence) throws ArduinoGeneratorException {

        if (t instanceof IntValue) return String.valueOf(((IntValue) t).getValue());
        if (t instanceof NullValue) return "NULL";
        if (t instanceof BoolValue) return ((BoolValue) t).getValue() ? "1" : "0";
        if (t instanceof IdValue) {
            return ((IdValue) t).getIdentifier();
        }
        if (t instanceof DoubleValue) {
            return String.valueOf(((DoubleValue) t).getValue());
        }


        if (t instanceof BinaryOperatorTerm) {
            // TODO : brackets
            return String.format(
                    "%s %s %s",
                    termGenerate(((BinaryOperatorTerm) t).getLeft(), t.getPrecedence()),
                    ((BinaryOperatorTerm) t).getOpr().toString(),
                    termGenerate(((BinaryOperatorTerm) t).getRight(), t.getPrecedence())
            );
        }
        if (t instanceof FieldTerm) {
            return String.format(
                    "%s.%s",
                    termGenerate(((FieldTerm) t).getOwner(), t.getPrecedence()), ((FieldTerm) t).getField()
            );
        }
        if (t instanceof CallTerm) {
            List<String> args = new ArrayList<>();
            for (Term arg : ((CallTerm) t).getArgs()) {
                args.add(termGenerate(arg, 0));
            }

            // todo check whether it is a pwm port

            String calleeName = ((CallTerm) t).getCallee().toString();
            Integer pin = null;
            ArduinoPinDirection pinDirection = null;

            if (calleeName.equals("digitalWrite") || calleeName.equals("analogWrite")) {
                pin = Integer.parseInt(((CallTerm) t).getArg(0).toString());
                pinDirection = ArduinoPinDirection.OUT;
            } else if (calleeName.equals("digitalRead") || calleeName.equals("analogRead")) {
                pin = Integer.parseInt(((CallTerm) t).getArg(0).toString());
                pinDirection = ArduinoPinDirection.IN;
            }

            if (pin != null) {
                if (pinStatus.containsKey(pin) && !pinStatus.get(pin).equals(pinDirection)) {
                    throw ArduinoGeneratorException.InconsistentPinType(pin);
                }

                pinStatus.put(pin, pinDirection);
            }

            return String.format(
                    "%s(%s)",
                    ((CallTerm) t).getCallee().toString(),
                    String.join(", ", args)
            );
        }

        if (t instanceof SingleOperatorTerm) {
            return ((SingleOperatorTerm) t).getOpr() + termGenerate(((SingleOperatorTerm) t).getTerm(), t.getPrecedence());
        }
        if (t instanceof ElementTerm) {
            return String.format(
                    "%s[%s]",
                    termGenerate(((ElementTerm) t).getContainer(), t.getPrecedence()),
                    termGenerate(((ElementTerm) t).getKey(), 0)
            );
        }

        if (t instanceof EnumValue) return t.toString();

        throw ArduinoGeneratorException.UnhandledTerm(t);
    }

    public String termAssertionGenerate(Term t) throws ValidationException, ArduinoGeneratorException {
        String result = "";
        if (t.getType() instanceof BoundedIntType) {
            BinaryOperatorTerm land = new BinaryOperatorTerm().setParent(t.getParent())
                    .setOpr(EnumBinaryOperator.LAND)
                    .setLeft(new BinaryOperatorTerm())
                    .setRight(new BinaryOperatorTerm());

            ((BinaryOperatorTerm) land.getLeft()).setLeft(t.copy());
            ((BinaryOperatorTerm) land.getLeft()).setRight(((BoundedIntType) t.getType()).getLowerBound());
            ((BinaryOperatorTerm) land.getLeft()).setOpr(EnumBinaryOperator.GEQ);

            ((BinaryOperatorTerm) land.getRight()).setLeft(t.copy());
            ((BinaryOperatorTerm) land.getRight()).setRight(((BoundedIntType) t.getType()).getUpperBound());
            ((BinaryOperatorTerm) land.getRight()).setOpr(EnumBinaryOperator.LEQ);

            result = termGenerate(land, 0);
        }

        // TODO assertions of more types should be supported

        if (result.length() > 0) {
            return String.format("assert (%s);", result);
        }
        return "";
    }

    @Override
    public String getName() {
        return "Arduino C code generator";
    }

    @Override
    public String getVersion() {
        return "0.0.1";
    }

    @Override
    public String getDescription() {
        return "providing support for Arduino C code generation";
    }

    @Override
    public List<String> requiredLibraries() {
        List<String> libs = new ArrayList<>();
        libs.add("arduino");
        return libs;
    }
}
