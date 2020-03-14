package org.kakara.core.mod.game;

import java.net.URL;
import java.net.URLClassLoader;

public class ModClassLoader extends URLClassLoader {
    private final GameModLoader loader;

    public ModClassLoader(URL urls, ClassLoader parent, GameModLoader loader) {
        super(new URL[]{
                urls
        }, parent);
        this.loader = loader;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return findClass(name, true);
    }

    public Class<?> findClass(String name, boolean global) throws ClassNotFoundException {
        Class<?> result = null;
        try {
            result = super.findClass(name);
        } catch (ClassNotFoundException ex) {
            if (global) {
                result = loader.getClassByName(name);
            }
        }
        if (result == null) {
            throw new ClassNotFoundException("Unable to locate " + name);
        }
        return result;
    }
}
