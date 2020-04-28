package org.kakara.core.mod;

import org.kakara.core.GameInstance;
import org.kakara.core.mod.annotations.LoadingStage;

import java.io.File;
import java.util.List;

public interface ModManager {

    List<Mod> getLoadedMods();

    ModLoader getModLoader();


    List<UnModObject> loadModsFile(List<File> modsToLoad);

    void unloadMod(Mod mod);

    void loadMods(List<UnModObject> modsToLoad);

    void loadStage(LoadStage loadStage, Mod mod);

    void loadStage(LoadStage loadStage);

    void load(GameInstance gameInstance);
}
