package org.fmgroup.mediator.generator.framework;

public class UtilCode {

    public static String addIndent(String rawCode, int level) {
        String [] lines = rawCode.split("\n");
        String newCode = "";
        String indent = "";
        for (int i = 0; i < level; i ++) indent += "\t";
        for (int i = 0; i < lines.length; i ++) {
            newCode += indent + lines[i];
            if (i < lines.length - 1 || rawCode.endsWith("\n")) newCode += "\n";
        }
        return newCode;
    }

}