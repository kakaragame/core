package org.kakara.core.mod.game;

import org.kakara.core.GameInstance;
import org.kakara.core.Kakara;
import org.kakara.core.exceptions.IllegalModException;
import org.kakara.core.mod.Mod;
import org.kakara.core.mod.ModLoader;
import org.kakara.core.mod.logger.ModLogger;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class GameModLoader implements ModLoader {
    public static final String MOD_PROPERTIES = "mod.properties";
    public static final String MAIN_CLASS = "main.class";
    private GameInstance gameInstance;
    private List<ModClassLoader> modClassLoaders = new CopyOnWriteArrayList<>();

    public GameModLoader(GameInstance Kakara) {
        this.gameInstance = Kakara;
    }

    @Override
    public Mod load(File file) throws IOException, IllegalModException {
        Kakara.LOGGER.debug(String.format("Loading Mod File %s", file.getName()));
        //You screwed up somewhere?
        if (!file.exists()) return null;

        JarFile jarFile = new JarFile(file);

        ModClassLoader classLoader = new ModClassLoader(file.toURI().toURL(), ClassLoader.getSystemClassLoader(), this);
        modClassLoaders.add(classLoader);
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

        if (!GameMod.class.isAssignableFrom(modClass)) {
            return null;
        }

        try {
            Mod mod = buildModObject(modClass, classLoader);

            return mod;
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            Kakara.LOGGER.error("Unable to create mod object", e);
        }

        return null;
    }

    private Mod buildModObject(Class<?> modClass, ModClassLoader classLoader) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        GameMod mod = (GameMod) modClass.getConstructor().newInstance();
        mod.setGameInstance(gameInstance);
        mod.setLogger(new ModLogger(mod.getName()));
        mod.setModClassLoader(classLoader);
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

    public Class<?> getClassByName(String name) {
        for (ModClassLoader loader : modClassLoaders) {
            Class<?> result = null;

            try {
                result = loader.findClass(name, false);
            } catch (ClassNotFoundException ignored) {
            }
            if (result != null) return result;
        }
        return null;
    }
}
