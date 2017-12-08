package org.fmgroup.mediator.common;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Paths;

public class ToolInfo {
    public static String version = "alpha";
    public static String authors = "Li Yi";

    public static String getSystemLibraryPath() {
        try {
            String root = URLDecoder.decode(
                    ToolInfo.class.getResource("/").getPath().toString(),
                    "utf-8"
            );

            return Paths.get(root, "library").toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
