package org.fmgroup.mediator.plugins.generators.arduino;

import org.fmgroup.mediator.generator.framework.Generator;
import org.fmgroup.mediator.generator.framework.UtilCode;
import org.fmgroup.mediator.language.*;
import org.fmgroup.mediator.language.entity.automaton.Automaton;
import org.fmgroup.mediator.language.scope.VariableDeclaration;
import org.fmgroup.mediator.language.statement.AssignmentStatement;
import org.fmgroup.mediator.language.statement.IteStatement;
import org.fmgroup.mediator.language.statement.Statement;
import org.fmgroup.mediator.language.statement.SynchronizingStatement;
import org.fmgroup.mediator.language.term.*;
import org.fmgroup.mediator.language.entity.automaton.Transition;
import org.fmgroup.mediator.language.entity.automaton.TransitionGroup;
import org.fmgroup.mediator.language.entity.automaton.TransitionSingle;
import org.fmgroup.mediator.language.type.*;

import java.lang.System;
import java.util.ArrayList;
import java.util.List;

public class ArduinoGenerator extends Generator {

    @Override
    public String generate(RawElement elem) throws ArduinoGeneratorException {
        if (elem instanceof Automaton) try {
            return automatonGenerate((Automaton) elem);
        } catch (ValidationException e) {
            e.printStackTrace();
        }

        return null;
    }

    private String automatonGenerate(Automaton a) throws ArduinoGeneratorException, ValidationException {
        // TODO only an automaton with no portDeclarations can be generated directly

        String endline = System.getProperty("line.separator");
        String tab = "\t";

        String prog = "";
        for (VariableDeclaration var : a.localVars.vardecls) {
            String strType = typeGenerate(var.type);
            for (String name : var.identifiers) {
                if (!strType.contains("%s")) {
                    strType += " %s";
                }

                strType += ";\n";
                prog += String.format(strType, name);
            }
        }

        prog += String.format(
                "\nint cmd_activated[%d];\nint cmd_activated_counter;\n",
                ((TransitionGroup) a.transitions.get(0)).transitions.size()
        );
        prog += "int cmd;\n";

        prog += endline;
        // generate setup
        prog += "void setup() {" + endline;
        for (VariableDeclaration var : a.localVars.vardecls) {
            for (String name : var.identifiers) {
                prog += UtilCode.addIndent(
                        name +
                            " = " +
                            termGenerate(UtilType.getInitValue(var.type), 0) + ";" + endline,
                        1
                );
            }
        }

        prog += "}" + endline;

        prog += endline;
        // generate loop
        prog += "void loop() {" + endline;

        // we assume that the automaton has been canonicalized already
        assert a.transitions.size() == 1;
        assert a.transitions.get(0) instanceof TransitionGroup;

        prog += UtilCode.addIndent(
                String.format(
                        "cmd_activated_counter = 0;\n",
                        ((TransitionGroup) a.transitions.get(0)).transitions.size()
                ),
                1
        );

        prog += "\n";

        String conditionCheck = "";
        String transitionExecution = "";

        for (Transition t : ((TransitionGroup) a.transitions.get(0)).transitions) {
            assert t instanceof TransitionSingle;

            int index = ((TransitionGroup) a.transitions.get(0)).transitions.indexOf(t);
            conditionCheck += String.format(
                    // FIXME how to make it looks better?
                    "if (%s) {\n\tcmd_activated[cmd_activated_counter] = %d;\n\tcmd_activated_counter ++;\n}\n",
                    termGenerate(((TransitionSingle) t).guard, 0),
                    index
            );

            transitionExecution += String.format(
                    "if (cmd == %d) {\n%s\n}\n",
                    index,
                    UtilCode.addIndent(
                            statementGenerate(((TransitionSingle) t).statements),
                            1
                    )
            );

        }

        // which transitions are activated ?
        prog += UtilCode.addIndent(conditionCheck, 1);
        prog += "\n";
        prog += UtilCode.addIndent(
                String.format(
                        "cmd = cmd_activated[random(%d)];\n",
                        ((TransitionGroup) a.transitions.get(0)).transitions.size()
                ),
                1
        );
        prog += "\n";
        prog += UtilCode.addIndent(transitionExecution, 1);
        prog += "}" + endline;

        return prog;
    }

    private String statementGenerate(List<Statement> statements) throws ArduinoGeneratorException {
        String rel = "";
        for (Statement s : statements) {
            if (rel.length() > 0) rel += "\n";

            if (s instanceof SynchronizingStatement) {
                System.err.println("A sync statement is not supposed to show up when generating codes.");
            } else if (s instanceof AssignmentStatement) {

                if (((AssignmentStatement) s).target == null) {
                    rel += termGenerate(((AssignmentStatement) s).expr, 0) + ";";
                } else if (((AssignmentStatement) s).target instanceof TupleTerm){
                    // TODO
                    String temp = "";
                    for (Term assigned : ((TupleTerm) ((AssignmentStatement) s).target).getTerms()) {
                        int index = ((TupleTerm) ((AssignmentStatement) s).target).getTerms().indexOf(assigned);
                        if (temp.length() > 0) temp += "\n";
                        temp += String.format(
                                "%s = %s;",
                                assigned.toString(),
                                ((TupleTerm) ((AssignmentStatement) s).expr).getTerms().get(index)
                                );
                    }
                    rel += temp;
                } else {
                    rel += termGenerate(((AssignmentStatement) s).target, 0) +
                            " = " +
                            termGenerate(((AssignmentStatement) s).expr, 0) + ";";
                }
            }
            else if (s instanceof IteStatement) {
                rel += String.format(
                        "if (%s) {\n%s\n}",
                        termGenerate(((IteStatement) s).condition, 0),
                        UtilCode.addIndent(statementGenerate(((IteStatement) s).thenStmts), 1)
                );

                if (((IteStatement) s).elseStmts.size() > 0) {
                    rel += String.format(
                            "else {\n%s\n}\n",
                            UtilCode.addIndent(statementGenerate(((IteStatement) s).elseStmts), 1)
                    );
                } else {
                    rel += "\n";
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
            if (((ListType) t).capacity != null) {
                // TODO: recheck the precedence between terms and types
                return typeGenerate(((ListType) t).baseType) + " %s[" + termGenerate(((ListType) t).capacity, 0) + "]";
            }
            return typeGenerate(((ListType) t).baseType) + " * %s";
        }
        if (t instanceof InitType) return typeGenerate(((InitType) t).baseType);
        if (t instanceof IdType) {
            // TODO
            return ((IdType) t).identifier;
        }

        throw ArduinoGeneratorException.UnhandledType(t);
    }

    private String termGenerate(Term t, int parentPrecedence) throws ArduinoGeneratorException {
        if (t instanceof IntValue) return String.valueOf(((IntValue) t).value);
        if (t instanceof NullValue) return "NULL";
        if (t instanceof BoolValue) return ((BoolValue) t).value ? "1" : "0";
        if (t instanceof IdValue) {
            // TODO : validation (whether the ID exists)
            return ((IdValue) t).identifier;
        }
        if (t instanceof DoubleValue) {
            return String.valueOf(((DoubleValue) t).value);
        }


        if (t instanceof BinaryOperatorTerm) {
            // TODO : validation
            // TODO : brackets
            return String.format(
                    "%s %s %s",
                    termGenerate(((BinaryOperatorTerm) t).left, t.getPrecedence()),
                    ((BinaryOperatorTerm) t).opr.toString(),
                    termGenerate(((BinaryOperatorTerm) t).right, t.getPrecedence())
            );
        }
        if (t instanceof FieldTerm) {
            return String.format(
                    "%s.%s",
                    termGenerate(((FieldTerm) t).owner, t.getPrecedence()), ((FieldTerm) t).field
            );
        }
        if (t instanceof CallTerm) {
            List<String> args = new ArrayList<>();
            for (Term arg : ((CallTerm) t).args) {
                args.add(termGenerate(arg, 0));
            }
            return String.format(
                    "%s(%s)",
                    termGenerate(((CallTerm) t).callee, t.getPrecedence()),
                    String.join(", ", args)
            );
        }

        if (t instanceof SingleOperatorTerm) {
            return ((SingleOperatorTerm) t).opr + termGenerate(((SingleOperatorTerm) t).term, t.getPrecedence());
        }
        if (t instanceof ElementTerm) {
            return String.format(
                    "%s[%s]",
                    termGenerate(((ElementTerm) t).container, t.getPrecedence()),
                    termGenerate(((ElementTerm) t).key, 0)
            );
        }

        throw ArduinoGeneratorException.UnhandledTerm(t);
    }
}
