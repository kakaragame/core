package org.kakara.core.mod.game;

import org.apache.commons.lang3.StringUtils;
import org.kakara.core.KakaraCore;
import org.kakara.core.exceptions.IllegalModException;
import org.kakara.core.mod.Mod;
import org.kakara.core.mod.ModLoader;
import org.kakara.core.mod.ModManager;
import org.kakara.core.mod.ModType;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameModManager implements ModManager {
    private List<Mod> loadedMods = new ArrayList<>();
    private ModLoader modLoader;
    private Mod coreMod;
    private KakaraCore kakaraCore;

    public GameModManager(ModLoader modLoader, Mod coreMod, KakaraCore kakaraCore) {
        this.modLoader = modLoader;
        this.coreMod = coreMod;
        this.kakaraCore = kakaraCore;
    }

    @Override
    public List<Mod> getLoadedMods() {
        List<Mod> list = new ArrayList<>(loadedMods);
        list.add(coreMod);
        return list;
    }

    @Override
    public void loadMods(List<File> modsToLoad) {
        for (File file : modsToLoad) {
            try {
                GameMod mod = (GameMod) modLoader.load(file);
                loadedMods.add(mod);
                KakaraCore.LOGGER.info("Enabling " + mod.getName() + " " + mod.getVersion() + " by " + StringUtils.join(mod.getAuthors(), ","));
                mod.enable();
            } catch (IOException | IllegalModException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void unloadMods(List<Mod> modsToUnload) {
        for (Mod mod : modsToUnload) {
            if (mod == coreMod) continue;
            KakaraCore.LOGGER.info("Disabling " + mod.getName() + " " + mod.getVersion());
            if (!(mod instanceof GameMod)) continue;
            ((GameMod) mod).disable();
            loadedMods.remove(mod);
            try {
                modLoader.unload(mod);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Mod> getModsByType(ModType modType) {
        return loadedMods.stream().filter(mod -> mod.getModType() == modType).collect(Collectors.toList());
    }

    @Override
    public void unLoadMods(ModType type) {
        unloadMods(getModsByType(type));
    }

    @Override
    public ModLoader getModLoader() {
        return modLoader;
    }
}
