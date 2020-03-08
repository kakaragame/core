package org.kakara.core.mod.game;

import org.kakara.core.KakaraCore;
import org.kakara.core.exceptions.IllegalModException;
import org.kakara.core.mod.Mod;
import org.kakara.core.mod.ModLoader;
import org.kakara.core.mod.logger.ModLogger;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class GameModLoader implements ModLoader {
    public static final String MOD_PROPERTIES = "mod.properties";
    public static final String MAIN_CLASS = "main.class";
    private KakaraCore kakaraCore;

    public GameModLoader(KakaraCore kakaraCore) {
        this.kakaraCore = kakaraCore;
    }

    @Override
    public Mod load(File file) throws IOException, IllegalModException {
        KakaraCore.LOGGER.debug(String.format("Loading Mod File %s", file.getName()));
        //You screwed up somewhere?
        if (!file.exists()) return null;
        JarFile jarFile = new JarFile(file);
        ModClassLoader classLoader = new ModClassLoader(file.toURI().toURL(), ClassLoader.getSystemClassLoader());
        Properties properties = getModProperties(jarFile);
        if (properties.getProperty(MAIN_CLASS) == null) {
            throw new IllegalModException("Missing main.class property " + file.getName());
        }
        Class<?> modClass;

        try {
            modClass = classLoader.loadClass(properties.getProperty(MAIN_CLASS));
        } catch (ClassNotFoundException e) {
            throw new IllegalModException("Unable to locate main class for mod " + file.getName(), e);
        }
        if (!modClass.isAssignableFrom(GameMod.class)) {
            return null;
        }
        try {
            return buildModObject(modClass);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            KakaraCore.LOGGER.error("Unable to create mod object", e);
        }
        return null;
    }

    private Mod buildModObject(Class<?> modClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        GameMod mod = (GameMod) modClass.getConstructor().newInstance();
        mod.setKakaraCore(kakaraCore);
        mod.setLogger(new ModLogger(mod.getName()));
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
    public void unload(Mod mod) throws IOException {
        if (!(mod instanceof GameMod)) {
            return;
        }
        ((GameMod) mod).getClassLoader().close();
    }
}
