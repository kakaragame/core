package org.kakara.core.mod.game;

import org.kakara.core.mod.Mod;
import org.kakara.core.mod.ModLoader;
import org.kakara.core.mod.ModManager;
import org.kakara.core.mod.ModType;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameModManager implements ModManager {
    private List<Mod> loadedMods = new ArrayList<>();
    private ModLoader modLoader;
    private Mod coreMod;

    public GameModManager(ModLoader modLoader, Mod coreMod) {
        this.modLoader = modLoader;
        this.coreMod = coreMod;
    }

    @Override
    public List<Mod> getLoadedMods() {
        List<Mod> list = new ArrayList<>(loadedMods);
        list.add(coreMod);
        return list;
    }

    @Override
    public void loadMods(List<File> modsToLoad) {

    }

    @Override
    public void unloadMods(List<Mod> modsToUnload) {
        for (Mod mod : modsToUnload) {
            if (mod == coreMod) continue;
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
