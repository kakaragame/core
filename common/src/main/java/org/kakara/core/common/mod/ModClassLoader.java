package org.kakara.core.common.mod;

import org.kakara.core.common.mod.game.GameModLoader;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.jar.JarFile;

public class ModClassLoader extends URLClassLoader {
    private final ModLoader loader;
    private final JarFile file;

    public ModClassLoader(URL urls, ClassLoader parent, ModLoader loader, JarFile jarFile) {
        super(new URL[]{
                urls
        }, parent);
        this.loader = loader;
        this.file = jarFile;
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

    @Override
    public void close() throws IOException {
        file.close();
        super.close();
    }

    public JarFile getFile() {
        return file;
    }
}
