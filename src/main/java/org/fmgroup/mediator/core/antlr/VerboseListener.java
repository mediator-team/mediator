package org.fmgroup.mediator.core.antlr;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class VerboseListener extends BaseErrorListener{

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        System.out.println(String.format("error @ line %d, column %d : %s", line, charPositionInLine, msg));
        super.syntaxError(recognizer, offendingSymbol, line, charPositionInLine, msg, e);
    }
}
