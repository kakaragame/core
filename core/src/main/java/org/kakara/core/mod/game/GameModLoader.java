package org.kakara.core.mod.game;

import com.google.gson.JsonObject;
import org.kakara.core.GameInstance;
import org.kakara.core.Kakara;
import org.kakara.core.Utils;
import org.kakara.core.exceptions.IllegalModException;
import org.kakara.core.mod.*;
import org.kakara.core.mod.logger.ModLogger;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class GameModLoader implements ModLoader {
    public static final String MOD_PROPERTIES = "mod.properties";
    public static final String MAIN_CLASS = "main.class";
    private final GameInstance gameInstance;
    private final List<ModClassLoader> modClassLoaders = new CopyOnWriteArrayList<>();

    public GameModLoader(GameInstance Kakara) {
        this.gameInstance = Kakara;
    }

    @Override
    public UnModObject load(File file) throws IOException, IllegalModException {
        Kakara.LOGGER.debug(String.format("Loading Mod File %s", file.getName()));
        //You screwed up somewhere?
        if (!file.exists()) return null;

        JarFile jarFile = new JarFile(file);

        ModClassLoader classLoader = new ModClassLoader(file.toURI().toURL(), ClassLoader.getSystemClassLoader(), this, jarFile);
        modClassLoaders.add(classLoader);

        return new UnModObject(getModRules(jarFile), classLoader);
    }

    @Override
    public Mod createMod(UnModObject unModObject) throws ClassNotFoundException, IllegalModException {
        ModClassLoader classLoader = (ModClassLoader) unModObject.getModClassLoader();
        Class<?> mod = classLoader.findClass(unModObject.getModRules().getMainClass(), false);

        if (!GameMod.class.isAssignableFrom(mod)) {
            throw new IllegalModException("sounds like a personal problem. Error 32");
        }
        GameMod gameMod = easyCreate(mod);
        if (gameMod == null) return null;
        gameMod.setGameInstance(gameInstance);
        gameMod.setLogger(new ModLogger(unModObject.getModRules().getName()));
        gameMod.setModClassLoader(classLoader);
        gameMod.setModRules(unModObject.getModRules());


        return gameMod;
    }

    private GameMod easyCreate(Class<?> mod) {
        try {
            return (GameMod) mod.getConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    private ModRules getModRules(JarFile jarFile) throws IOException, IllegalModException {
        JarEntry entry = jarFile.getJarEntry("mod.json");
        if (entry == null) {
            throw new IllegalModException("Unable to locate mod.json");
        }
        JsonObject jsonObject = Utils.getGson().fromJson(new InputStreamReader(jarFile.getInputStream(entry)), JsonObject.class);
        JsonModRules.validate(jsonObject);
        return new JsonModRules(jsonObject);
    }


    @Override
    public void unload(Mod mod) throws IOException {
        if (!(mod instanceof GameMod)) {
            return;
        }
        modClassLoaders.remove(((GameMod) mod).getClassLoader());
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
