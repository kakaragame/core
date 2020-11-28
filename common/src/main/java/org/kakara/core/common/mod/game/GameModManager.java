package org.kakara.core.common.mod.game;

import me.kingtux.other.TheCodeOfAMadMan;
import me.kingtux.simpleannotation.MethodFinder;
import org.apache.commons.lang3.StringUtils;
import org.kakara.core.common.EnvironmentInstance;
import org.kakara.core.common.GameInstance;
import org.kakara.core.common.Kakara;
import org.kakara.core.common.annotations.Environment;
import org.kakara.core.common.exceptions.IllegalModException;
import org.kakara.core.common.mod.*;
import org.kakara.core.common.mod.annotations.LoadingStage;
import org.kakara.core.common.resources.ResourceType;
import org.kakara.core.common.resources.TextureResolution;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.jar.JarFile;
import java.util.stream.Collectors;

public class GameModManager implements ModManager {
    private final List<Mod> loadedMods = new ArrayList<>();
    private ModLoader modLoader;
    private final Mod coreMod;
    private GameInstance gameInstance;

    public GameModManager(Mod coreMod) {
        this.coreMod = coreMod;
    }

    public static void loadResources(Mod mod, JarFile file) throws IOException {
        List<String> paths = TheCodeOfAMadMan.getResourcesInJar(file, "resources", true);
        for (String s : paths) {
            String path = s.replace("/resources/", "");
            String[] splitPath = path.split("/");
            try {
                if (splitPath[0].equalsIgnoreCase("texture")) {
                    String newPath = StringUtils.join(Arrays.stream(splitPath).collect(Collectors.toList()), "/", 2, splitPath.length);
                    Kakara.getGameInstance().getResourceManager().registerTexture(newPath, TextureResolution.get(Integer.parseInt(splitPath[1])), mod);
                } else {
                    String newPath = StringUtils.join(Arrays.stream(splitPath).collect(Collectors.toList()), "/", 1, splitPath.length);
                    Kakara.getGameInstance().getResourceManager().registerResource(newPath, ResourceType.valueOf(splitPath[0].toUpperCase()), mod);
                }
            } catch (IllegalArgumentException e) {

            }
        }
    }

    @Override
    public List<Mod> getLoadedMods() {
        List<Mod> list = new ArrayList<>(loadedMods);
        list.add(coreMod);
        return list;
    }

    @Override
    public ModLoader getModLoader() {
        return modLoader;
    }

    @Override
    public List<UnModObject> loadModsFile(List<File> modsToLoad) {
        List<UnModObject> objects = new ArrayList<>();
        for (File file : modsToLoad) {
            UnModObject unModObject = null;
            try {
                unModObject = modLoader.load(file);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (IllegalModException e) {
                e.printStackTrace();
            }
            if (unModObject == null) {
                continue;
            }
            objects.add(unModObject);
        }
        return objects;
    }

    @Override
    public void unloadMod(Mod mod) {

    }

    @Override
    public void loadMods(List<UnModObject> modsToLoad) {
        for (UnModObject modObject : modsToLoad) {
            GameMod gameMod = null;
            try {
                gameMod = (GameMod) modLoader.createMod(modObject);
            } catch (ClassNotFoundException e) {
                Kakara.LOGGER.error("unable to locate class", e);
            } catch (IllegalModException e) {
                Kakara.LOGGER.error("unable to load mod", e);
            }
            if (gameMod == null) continue;
            loadedMods.add(gameMod);
            gameMod.preEnable();
            try {
                loadResources(gameMod, gameMod.getClassLoader().getFile());
            } catch (IOException e) {
                Kakara.LOGGER.error("Unable to poll resources", e);
            }
        }
    }

    @Override
    public void loadStage(LoadStage loadStage) {
        Kakara.LOGGER.info(String.format("Loading Stage: %s", loadStage.getName()));
        for (Mod mod : loadedMods) {
            loadStage(loadStage, mod);
        }
    }

    @Override
    public void loadStage(LoadStage loadStage, Mod mod) {
        Method[] methods = MethodFinder.getAllMethodsWithAnnotation(mod.getClass(), LoadingStage.class);
        Method method = null;
        for (Method meth : methods) {
            if (meth.getParameterTypes().length != 1) {
                continue;
            }
            if (loadStage.getStageClass() != meth.getParameterTypes()[0]) {
                continue;
            }
            if (meth.isAnnotationPresent(Environment.class)) {
                Environment environment = meth.getAnnotation(Environment.class);
                if (environment.value() != gameInstance.getType()) continue;
            }
            method = meth;
            break;
        }
        if (method == null) return;
        Kakara.LOGGER.debug(String.format("Loading %s Stage: %s", mod.getName(), loadStage.getName()));
        try {
            method.invoke(mod, loadStage);
        } catch (IllegalAccessException | InvocationTargetException e) {
            Kakara.LOGGER.error(String.format("Unable to call %s Stage: %s", mod.getName(), loadStage.getName()), e);
        }
    }

    @Override
    public void load(EnvironmentInstance gameInstance) {
        //TODO redo this loading
        //this.gameInstance = gameInstance;
        //this.modLoader = new GameModLoader(gameInstance);
    }

    public void postEnable() {
        loadedMods.forEach(Mod::postEnable);
    }

}
