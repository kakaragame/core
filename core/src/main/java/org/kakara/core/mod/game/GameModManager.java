package org.kakara.core.mod.game;

import me.kingtux.other.TheCodeOfAMadMan;
import me.kingtux.simpleannotation.MethodFinder;
import org.apache.commons.lang3.StringUtils;
import org.kakara.core.GameInstance;
import org.kakara.core.Kakara;
import org.kakara.core.annotations.GameType;
import org.kakara.core.exceptions.IllegalModException;
import org.kakara.core.mod.*;
import org.kakara.core.mod.annotations.LoadingStage;
import org.kakara.core.resources.ResourceType;
import org.kakara.core.resources.TextureResolution;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.jar.JarFile;
import java.util.stream.Collectors;

import static me.kingtux.simpleannotation.MethodFinder.getAllMethodsWithAnnotation;

public class GameModManager implements ModManager {
    private List<Mod> loadedMods = new ArrayList<>();
    private ModLoader modLoader;
    private Mod coreMod;
    private GameInstance gameInstance;

    public GameModManager(Mod coreMod) {
        this.coreMod = coreMod;
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
            if (meth.isAnnotationPresent(GameType.class)) {
                GameType gameType = meth.getAnnotation(GameType.class);
                if (gameType.value() != gameInstance.getType()) continue;
            }
            method = meth;
            break;
        }
        if (method == null) return;


        try {
            method.invoke(mod,loadStage);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void load(GameInstance gameInstance) {
        this.gameInstance = gameInstance;
        this.modLoader = new GameModLoader(gameInstance);
    }


    public void postEnable() {
        loadedMods.forEach(Mod::postEnable);
    }

    private void loadResources(Mod mod, JarFile file) throws IOException {
        List<String> paths = TheCodeOfAMadMan.getResourcesInJar(file, "resources", true);
        for (String s : paths) {
            String path = s.replace("/resources/", "");
            String[] splitPath = path.split("/");
            if (splitPath[0].equalsIgnoreCase("texture")) {
                String newPath = StringUtils.join(Arrays.stream(splitPath).collect(Collectors.toList()), "/", 2, splitPath.length);
                gameInstance.getResourceManager().registerTexture(newPath, TextureResolution.get(Integer.parseInt(splitPath[1])), mod);
            } else {
                String newPath = StringUtils.join(Arrays.stream(splitPath).collect(Collectors.toList()), "/", 1, splitPath.length);
                gameInstance.getResourceManager().registerResource(newPath, ResourceType.valueOf(splitPath[0].toUpperCase()), mod);
            }
        }
    }

}
