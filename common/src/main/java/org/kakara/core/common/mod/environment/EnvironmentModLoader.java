package org.kakara.core.common.mod.environment;

import com.google.gson.JsonObject;
import org.kakara.core.common.GameInstance;
import org.kakara.core.common.Kakara;
import org.kakara.core.common.exceptions.IllegalModException;
import org.kakara.core.common.exceptions.ModLoadException;
import org.kakara.core.common.mod.*;
import org.kakara.core.common.mod.game.GameMod;
import org.kakara.core.common.mod.logger.ModLogger;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipFile;

public class EnvironmentModLoader implements ModLoader {
    public static final String MOD_PROPERTIES = "mod.properties";
    public static final String MAIN_CLASS = "main.class";
    private final GameInstance gameInstance;
    private final List<EnvironmentClassLoader> environmentClassLoaders = new CopyOnWriteArrayList<>();

    public EnvironmentModLoader(GameInstance Kakara) {
        this.gameInstance = Kakara;
    }

    @Override
    public UnModObject load(File file) throws IOException, IllegalModException {
        Kakara.LOGGER.debug(String.format("Loading Mod File %s", file.getName()));
        //You screwed up somewhere?
        if (!file.exists()) return null;

        JarFile jarFile = new JarFile(file, true, ZipFile.OPEN_READ, Runtime.version());

        EnvironmentClassLoader classLoader = new EnvironmentClassLoader(file.toURI().toURL(), ClassLoader.getSystemClassLoader(), this, jarFile);
        environmentClassLoaders.add(classLoader);

        return new UnModObject(getModRules(jarFile), classLoader);
    }

    @Override
    public Mod createMod(UnModObject unModObject) throws ClassNotFoundException, IllegalModException {
        EnvironmentClassLoader classLoader = (EnvironmentClassLoader) unModObject.getModClassLoader();
        Class<?> mod = classLoader.findClass(unModObject.getModRules().getMainClass(), false);

        if (!GameMod.class.isAssignableFrom(mod)) {
            throw new IllegalModException("ModClass must extend GameMod");
        }
        EnvironmentMod gameMod = null;
        try {
            gameMod = easyCreate(mod);
        } catch (ModLoadException e) {
            e.printStackTrace();
        }
        if (gameMod == null) return null;
        //gameMod.setGameInstance(gameInstance);
        gameMod.setLogger(new ModLogger(unModObject.getModRules().getName()));
        gameMod.setModClassLoader(classLoader);
        gameMod.setModRules(unModObject.getModRules());


        return gameMod;
    }

    private  EnvironmentMod easyCreate(Class<?> mod) throws ModLoadException {
        try {
            return (EnvironmentMod) mod.getConstructor().newInstance();
        } catch (InstantiationException e) {
            throw new ModLoadException("Abnormal Mod type", e);
        } catch (IllegalAccessException | NoSuchMethodException e) {
            throw new ModLoadException("No public constructor with 0 args", e);
        } catch (InvocationTargetException e) {
            throw new ModLoadException("Unable to load mod due to internal coding", e.getTargetException());
        }
    }


    private ModRules getModRules(JarFile jarFile) throws IOException, IllegalModException {
        JarEntry entry = jarFile.getJarEntry("mod.json");
        if (entry == null) {
            throw new IllegalModException("Unable to locate mod.json");
        }
        JsonObject jsonObject = null;//Utils.getGson().fromJson(new InputStreamReader(jarFile.getInputStream(entry)), JsonObject.class);
        JsonModRules.validate(jsonObject);
        return new JsonModRules(jsonObject);
    }


    @Override
    public void unload(Mod mod) throws IOException {
        if (!(mod instanceof GameMod)) {
            return;
        }
        environmentClassLoaders.remove(((EnvironmentMod) mod).getClassLoader());
        ((EnvironmentMod) mod).getClassLoader().close();
    }

    public Class<?> getClassByName(String name) {
        for (EnvironmentClassLoader loader : environmentClassLoaders) {
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
