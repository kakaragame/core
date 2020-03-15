package org.kakara.core.mod.game;

import me.kingtux.other.TheCodeOfAMadMan;
import org.apache.commons.lang3.StringUtils;
import org.kakara.core.GameInstance;
import org.kakara.core.Kakara;
import org.kakara.core.exceptions.IllegalModException;
import org.kakara.core.mod.*;
import org.kakara.core.resources.ResourceType;
import org.kakara.core.resources.TextureResolution;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.jar.JarFile;
import java.util.stream.Collectors;

public class GameModManager implements ModManager {
    private List<Mod> loadedMods = new ArrayList<>();
    private ModLoader modLoader;
    private Mod coreMod;
    private GameInstance gameInstance;

    public GameModManager(Mod coreMod) {
        this.coreMod = coreMod;
    }

    public void load(GameInstance gameInstance) {
        this.gameInstance = gameInstance;
        this.modLoader = new GameModLoader(gameInstance);

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
        return null;
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
