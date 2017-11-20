package org.fmgroup.mediator.language;

import java.io.*;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.fmgroup.mediator.core.antlr.VerboseListener;

public class UtilLang {
    public static Program ParseFile(String filename) {
        File file = new File(filename);
        try {
            InputStream is = new FileInputStream(file);
            MediatorLangLexer lexer = new MediatorLangLexer(CharStreams.fromStream(is));
            CommonTokenStream ts = new CommonTokenStream(lexer);
            MediatorLangParser parser = new MediatorLangParser(ts);

            // register exception listener
            parser.removeErrorListeners();
            parser.addErrorListener(new VerboseListener());

            return (Program) new Program().fromContext(parser.prog());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ValidationException e) {
            e.printStackTrace();
        }
        return null;
    }

//    public static Program ParseStr(String str) {
//        try {
//            InputStream is = new ByteArrayInputStream(str.getBytes());
//            MediatorLangLexer lexer = new MediatorLangLexer(CharStreams.fromStream(is));
//            CommonTokenStream ts = new CommonTokenStream(lexer);
//            MediatorLangParser parser = new MediatorLangParser(ts);
//            return (Program) new Program().fromContext(parser.prog());
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ValidationException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    public static Program getRoot(RawElement e) throws ValidationException {
        while (e != null) {
            if (e instanceof Program) return (Program) e;
            else
                e = e.getParent();
        }

        return null;
    }
}
