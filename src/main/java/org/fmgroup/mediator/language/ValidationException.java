package org.fmgroup.mediator.language;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.term.Term;
import org.fmgroup.mediator.language.type.Type;

public class ValidationException extends Exception {

    private int line = 0;
    private int column = 0;

    public ValidationException(Class<? extends RawElement> element, String content) {
        super(content);
    }

    public ValidationException() {
        super();
    }

    public static ValidationException IncompatibleContextType(
            Class<? extends RawElement> element,
            String contextExpected, String contextProvided
    ) {
        return new ValidationException(
                element,
                "Incompatible Context Type, Expected: " + contextExpected + ", Provided: " + contextProvided
        );
    }

    public static ValidationException UnregisteredType(String contextProvided) {
        return new ValidationException(
                null,
                "Unhandled Context Type Provided: " + contextProvided
        );
    }

    public static ValidationException UnregisteredTerm(String contextProvided) {
        return new ValidationException(
                null,
                "Unhandled Context Term Provided: " + contextProvided
        );
    }

    public static ValidationException UnregisteredOperator(String oprStringProvided) {
        return new ValidationException(
                null,
                "Unregistered Operator Provided: " + oprStringProvided
        );
    }

    public static ValidationException UnregisteredStatement(String stmtStringProvided) {
        return new ValidationException(
                null,
                "Unregistered Statement Provided: " + stmtStringProvided
        );
    }

    public static ValidationException UnregisteredTransition(String transStringProvided) {
        return new ValidationException(
                null,
                "Unregistered Transition Provided: " + transStringProvided
        );
    }

    public static ValidationException TypeNotInitialized(Type type) {
        return new ValidationException(
                null,
                "Type is not initialized: " + type.toString()
        );
    }

    public static ValidationException DumplicatedIdentifier(String identifier, String identifierType) {
        return new ValidationException(
                null,
                String.format("%s %s is already declared before", identifierType, identifier)
        );
    }

    public static ValidationException UnknownIdentifier(String identifier, String identifierType) {
        return new ValidationException(
                null,
                String.format("%s %s is never declared before.", identifierType, identifier)
        );
    }

    public static ValidationException UnexpectedTermType(Class<? extends Term> t, String needed) {
        return new ValidationException(
                t,
                String.format("%s is expected.", needed)
        );
    }

    public static ValidationException UnexpectedElement(Class<? extends RawElement> t, Class<? extends RawElement> found, String expected, String position) {
        return new ValidationException(
                t,
                String.format("%s is expected for %s's %s (%s found).", expected, t.getName(), position, found.getName())
        );
    }

    public static ValidationException UnexpectedType(Class<? extends RawElement> t, Class<? extends Type> found, String expected, String position) {
        return new ValidationException(
                t,
                String.format("%s is expected for %s's %s (%s found).", expected, t.getName(), position, found.getName())
        );
    }

    public static ValidationException UnderDevelopment() {
        return new ValidationException(
                null,
                String.format("Feature is UNDER DEVELOPMENT and not fully supported yet.")
        );
    }

    public static ValidationException FromMessage(String msg) {
        return new ValidationException(
                null,
                msg
        );
    }

    public int getLine() {
        return line;
    }

    public ValidationException setLine(int line) {
        this.line = line;
        return this;
    }

    public int getColumn() {
        return column;
    }

    public ValidationException setColumn(int column) {
        this.column = column;
        return this;
    }

    public ValidationException At(ParserRuleContext context) {
        setLine(context.start.getLine());
        setColumn(context.start.getStartIndex());
        return this;
    }

    @Override
    public String toString() {
        return String.format(
                "(%d, %d) %s",
                getLine(),
                getColumn(),
                getMessage()
        );
    }
}