package org.kakara.core.common.mod;


import org.kakara.core.common.EnvironmentInstance;

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

    void load(EnvironmentInstance gameInstance);
}
