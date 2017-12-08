package org.fmgroup.mediator.common;

import org.fmgroup.mediator.plugin.command.Command;
import org.fmgroup.mediator.plugin.Plugin;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class UtilClass {

    private static String getClassRoot() {
        try {
            return URLDecoder.decode(
                    UtilClass.class.getResource("/").getPath().toString(),
                    "utf-8"
            );
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Class> getImplementation(Class _interface) {
        return getImplementation(_interface, "");
    }

    public static List<Class> getImplementation(Class _interface, String pkgname) {

        Path searchPath = Paths.get(
                getClassRoot(),
                pkgname.replace(".", "/")
        );

        File pkg = searchPath.toFile();
        assert pkg.isDirectory();

        return getImplementation(_interface, pkg);
    }

    public static boolean isExtendedFrom(Class sub, Class parent) {
        try {
            sub.asSubclass(parent);
            return true;
        } catch (ClassCastException e) {
            // this class does not implement the interface
        }

        return false;
    }

    public static List<Class> getImplementation(Class _interface, File root) {
        List<Class> classes = new ArrayList<>();
        for (File f : root.listFiles()) {
            if (f.isFile() && f.getName().endsWith(".class")) {
                String clsname = f.getPath().substring(0, f.getPath().length() - 6);
                if (clsname.startsWith(getClassRoot())) {
                    clsname = clsname.substring(getClassRoot().length());
                }
                // fixme what if under windows system?
                clsname = clsname.replace("/", ".");

                try {
                    if (isExtendedFrom(Class.forName(clsname), _interface)) {
                        classes.add(Class.forName(clsname));
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (NoClassDefFoundError e) {
                    // just ignore them
                }
            } else if (f.isDirectory()) {
                classes.addAll(getImplementation(_interface, f));
            }
        }
        return classes;
    }

    public static List<Class> getPlugins() {
        return getImplementation(Plugin.class, "org.fmgroup.mediator.plugins");
    }

    public static List<Class> getCommands() {
        return getImplementation(Command.class, "org.fmgroup.mediator.plugins");
    }
}
