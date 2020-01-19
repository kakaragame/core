package org.kakara.core.mod.game;

import java.net.URL;
import java.net.URLClassLoader;

public class ModClassLoader extends URLClassLoader {
    public ModClassLoader(URL urls, ClassLoader parent) {
        super(new URL[]{urls}, parent);
    }
}
