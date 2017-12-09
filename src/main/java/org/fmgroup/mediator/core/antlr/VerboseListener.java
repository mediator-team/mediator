package org.fmgroup.mediator.core.antlr;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.fmgroup.mediator.language.ValidationException;

import java.util.ArrayList;
import java.util.List;

public class VerboseListener extends BaseErrorListener {

    public List<ValidationException> getExceptions() {
        return exceptions;
    }

    private List<ValidationException> exceptions = new ArrayList<>();

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
//        System.out.println(String.format("error @ line %d, column %d : %s", line, charPositionInLine, msg));
        exceptions.add(
                ValidationException.FromMessage(msg)
                .setLine(line)
                .setColumn(charPositionInLine)
        );
    }

    public boolean Succeed() {
        return exceptions.size() == 0;
    }
}
