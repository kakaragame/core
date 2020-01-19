package org.kakara.core.mod.game;

import org.kakara.core.KakaraCore;
import org.kakara.core.exceptions.IllegalModException;
import org.kakara.core.mod.Mod;
import org.kakara.core.mod.ModLoader;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class GameModLoader implements ModLoader {
    public static final String MOD_PROPERTIES = "mod.properties";
    public static final String MAIN_CLASS = "main.class";

    @Override
    public Mod load(File file) throws IOException, IllegalModException {
        KakaraCore.LOGGER.debug("Loading Mod File " + file.getName());
        //You screwed up somewhere?
        if (!file.exists()) return null;
        JarFile jarFile = new JarFile(file);
        ModClassLoader classLoader = new ModClassLoader(file.toURI().toURL(), ClassLoader.getSystemClassLoader());
        Properties properties = getModProperties(jarFile);
        if (properties.getProperty(MAIN_CLASS) == null) {
            throw new IllegalModException("Missing main.class property " + file.getName());
        }
        Class<? extends Mod> modClass;

        try {
            modClass = (Class<? extends Mod>) classLoader.loadClass(properties.getProperty(MAIN_CLASS));
        } catch (ClassNotFoundException e) {
            throw new IllegalModException("Unable to locate main class for mod " + file.getName(), e);
        }
        return buildModObject(modClass);
    }

    private Mod buildModObject(Class<? extends Mod> modClass) {
        Mod mod = null;
        //TODO build mod object
        return mod;
    }

    private Properties getModProperties(JarFile jarFile) throws IllegalModException, IOException {
        Properties properties = new Properties();
        JarEntry jarEntry = jarFile.getJarEntry(MOD_PROPERTIES);
        if (jarEntry == null) {
            throw new IllegalModException("Unable to find Mod Properties File");
        }
        properties.load(jarFile.getInputStream(jarEntry));
        return properties;
    }

    @Override
    public void unload(Mod mod) {

    }
}
