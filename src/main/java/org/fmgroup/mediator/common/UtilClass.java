package org.fmgroup.mediator.common;

import org.fmgroup.mediator.plugin.generator.Generator;
import org.fmgroup.mediator.plugin.command.Command;
import org.fmgroup.mediator.plugin.Plugin;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// todo consider using https://github.com/ronmamo/reflections instead
// prevent doing redundant work!

public class UtilClass {

    /**
     * use cache to improve performance, but only when the classes do not change
     * dynamically
     */
    private static Map<Class, Map<String, List<Class>>> cache = new HashMap<>();

    private static String getClassRoot() {
        try {
            return URLDecoder.decode(
                    ToolInfo.getSystemRootPath(),
                    "utf-8"
            );
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * get all implemention classes of <b>_interface</b> in the root package, i.e. the whole
     * directory in classloader
     * @param _interface
     * @return
     */
    public static List<Class> getImplementation(Class _interface) {
        return getImplementation(_interface, "");
    }

    /**
     * get all implemention classes of <b>_interface</b> in package <b>pkgname</b>
     * <b>NOTE</b> only this getImplementation function is utilized with cache
     * @param _interface
     * @param pkgname
     * @return
     */
    public static List<Class> getImplementation(Class _interface, String pkgname) {

        // use cache to enhance performance
        if (cache.containsKey(_interface) && cache.get(_interface).containsKey(pkgname))
            return cache.get(_interface).get(pkgname);

        Path searchPath = Paths.get(
                getClassRoot(),
                pkgname.replace(".", "/")
        );

        File pkg = searchPath.toFile();
        assert pkg.isDirectory();

        List<Class> classes = getImplementation(_interface, pkg);

        if (!cache.containsKey(_interface)) cache.put(_interface, new HashMap<>());
        cache.get(_interface).put(pkgname, classes);

        return classes;
    }

    public static List<Class> getImplementation(Class _interface, File root) {
        List<Class> classes = new ArrayList<>();
        for (File f : root.listFiles()) {
            if (f.isFile() && f.getName().endsWith(".class")) {
                String clsname = f.getPath().substring(0, f.getPath().length() - 6);
                if (clsname.startsWith(getClassRoot())) {
                    clsname = clsname.substring(getClassRoot().length());
                }
                if (ToolInfo.isWindows()) {
                    clsname = clsname.replace("\\", ".");
                } else {
                    clsname = clsname.replace("/", ".");
                }

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

    public static List<Class<Plugin>> getPlugins() {
        List<Class<Plugin>> plugins = new ArrayList<>();
        for (Class c: getImplementation(Plugin.class, "org.fmgroup.mediator.plugins")) {
            plugins.add(c);
        }

        return plugins;
    }

    public static List<Class<Command>> getCommands() {
        List<Class<Command>> commands = new ArrayList<>();
        for (Class c: getImplementation(Command.class, "org.fmgroup.mediator.plugins")) {
            commands.add(c);
        }

        return commands;
    }

    public static List<Class<Generator>> getGenerators() {
        List<Class<Generator>> generators = new ArrayList<>();
        for (Class c : getImplementation(Generator.class, "org.fmgroup.mediator.plugins")) {
            generators.add(c);
        }
        return generators;
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
}
