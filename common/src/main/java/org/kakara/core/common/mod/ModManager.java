package org.kakara.core.common.mod;


import org.kakara.core.common.EnvTypeable;

import java.io.File;
import java.util.List;

/**
 * The ModManager.
 * Handles mod loading, load stages, and mod unloading.
 *
 * @since 1.0
 */
public interface ModManager {
    /**
     * Get all loaded mods.
     *
     * @return currently loaded mods
     */
    List<Mod> getLoadedMods();

    /**
     * The mod loader
     *
     * @return the mod loader.
     */
    ModLoader getModLoader();

    /**
     * Load mods into UnModObjects.
     *
     * @param modsToLoad the mods to load
     * @return the UnModObjects
     */
    List<UnModObject> loadModsFile(List<File> modsToLoad);

    /**
     * Loads the UnModObjects
     *
     * @param modsToLoad the mods to load.
     */
    void loadMods(List<UnModObject> modsToLoad);

    /**
     * Unload a specific mod.
     *
     * @param mod the mod.
     */
    void unloadMod(Mod mod);

    /**
     * Loads a specific LoadStage in a specified mod
     *
     * @param loadStage the load stage
     * @param mod       The mod
     */
    void loadStage(LoadStage loadStage, Mod mod);

    /**
     * Loads a specific LoadStage in all loaded mods
     *
     * @param loadStage the load stage
     */
    void loadStage(LoadStage loadStage);

    /**
     * Initializes the ModManager
     *
     * @param typeable The EnvTypeable
     */
    void load(EnvTypeable typeable);
}
