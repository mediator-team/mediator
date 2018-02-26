package org.fmgroup.mediator.core.antlr;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.fmgroup.mediator.common.ToolInfo;
import org.fmgroup.mediator.language.generated.MediatorLangLexer;
import org.fmgroup.mediator.language.generated.MediatorLangParser;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    static public MediatorLangParser getParserFromString(String content) throws IOException {
        InputStream is = new ByteArrayInputStream(content.getBytes());
        return getParserFromCharStream(CharStreams.fromStream(is));
    }

    static public MediatorLangParser getParserFromFile(String filename) throws IOException {
        List<String> paths = new ArrayList<>();

        // obtain paths, both internal and external
        paths.add(ToolInfo.getSystemLibraryPath());
        paths.add(System.getProperty("user.dir").toString());

        for (String path : paths) {
            if (Files.exists(Paths.get(path, filename))) {
                InputStream is = new FileInputStream(Paths.get(path, filename).toFile());
                return getParserFromCharStream(CharStreams.fromStream(is));
            }
        }

        throw new FileNotFoundException(String.format(
                "cannot locate %s in all paths",
                filename
        ));
    }

    static public MediatorLangParser getParserFromCharStream(CharStream cs) {
        MediatorLangLexer lexer = new MediatorLangLexer(cs);
        CommonTokenStream ts = new CommonTokenStream(lexer);
        MediatorLangParser parser = new MediatorLangParser(ts);

        return parser;
    }
}
