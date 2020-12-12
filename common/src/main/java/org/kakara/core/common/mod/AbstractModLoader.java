package org.kakara.core.common.mod;

import com.google.gson.JsonObject;
import org.kakara.core.common.Kakara;
import org.kakara.core.common.Utils;
import org.kakara.core.common.exceptions.IllegalModException;
import org.kakara.core.common.exceptions.ModLoadException;
import org.kakara.core.common.mod.logger.ModLogger;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipFile;

public abstract class AbstractModLoader implements ModLoader {
    public static final String MOD_PROPERTIES = "mod.properties";
    public static final String MAIN_CLASS = "main.class";
    private final List<ModClassLoader> modClassLoaders = new CopyOnWriteArrayList<>();


    @Override
    public UnModObject load(File file) throws IOException, IllegalModException {
        Kakara.LOGGER.debug(String.format("Loading Mod File %s", file.getName()));
        //You screwed up somewhere?
        if (!file.exists()) return null;

        JarFile jarFile = new JarFile(file, true, ZipFile.OPEN_READ, Runtime.version());

        ModClassLoader classLoader = new ModClassLoader(file.toURI().toURL(), ClassLoader.getSystemClassLoader(), this, jarFile);
        modClassLoaders.add(classLoader);

        return new UnModObject(getModRules(jarFile), classLoader);
    }

    @Override
    public Mod createMod(UnModObject unModObject) throws ClassNotFoundException, IllegalModException {
        ModClassLoader classLoader = (ModClassLoader) unModObject.getModClassLoader();
        Class<?> mod = classLoader.findClass(unModObject.getModRules().getMainClass(), false);

        if (!requiredClass().isAssignableFrom(mod)) {
            throw new IllegalModException("ModClass must extend " + requiredClass().getName());
        }
        AbstractMod gameMod = null;
        try {
            gameMod = easyCreate(mod);
        } catch (ModLoadException e) {
            e.printStackTrace();
        }
        if (gameMod == null) return null;
        gameMod.setLogger(new ModLogger(unModObject.getModRules().getName()));
        gameMod.setModClassLoader(classLoader);
        gameMod.setModRules(unModObject.getModRules());


        return gameMod;
    }

    protected abstract Class<?> requiredClass();

    protected abstract void postSetup(AbstractMod abstractMod);

    private AbstractMod easyCreate(Class<?> mod) throws ModLoadException {
        try {
            return (AbstractMod) mod.getConstructor().newInstance();
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
        JsonObject jsonObject = Utils.getGson().fromJson(new InputStreamReader(jarFile.getInputStream(entry)), JsonObject.class);
        JsonModRules.validate(jsonObject);
        return new JsonModRules(jsonObject);
    }


    @Override
    public void unload(Mod mod) throws IOException {
        if (!(mod instanceof AbstractMod)) {
            return;
        }
        modClassLoaders.remove(((AbstractMod) mod).getClassLoader());
        ((AbstractMod) mod).getClassLoader().close();
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
