package org.kakara.core.mod;

import org.kakara.core.GameInstance;

import java.io.File;
import java.util.List;

public interface ModManager {

    List<Mod> getLoadedMods();

    void loadMods(List<File> modsToLoad);

    void unloadMods(List<Mod> modsToUnload);

    List<Mod> getModsByType(ModType modType);

    void unLoadMods(ModType type);

    ModLoader getModLoader();

    void load(GameInstance kakaraCore);
}
