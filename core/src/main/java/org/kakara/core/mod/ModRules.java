package org.kakara.core.mod;

/**
 * The details about the a mod
 */
public interface ModRules {
    /**
     * The mods name.
     * Name must contain not spaces or `:` This is used inside the ControllerKey
     *
     * @return mod name
     */
    String getName();

    /**
     * Mod version.
     *
     * @return Mod Version
     */
    String getVersion();

    /**
     * The authors of the mod.
     *
     * @return the authors
     */
    String[] getAuthors();

    /**
     * Quick and small description about the mod
     *
     * @return the description
     */
    String getDescription();

    /**
     * The type of mod it is
     *
     * @return the mod type
     * @see ModType
     */
    ModType getModType();

    /**
     * The canonical name of the mod main class
     *
     * @return the main class
     */
    String getMainClass();

    /**
     * Might be removed!
     *
     * @return the soft depends
     */
    String[] getSoftDepends();

    /**
     * Mods this mod depends upon
     *
     * @return the mods this mod depends on
     */
    String[] getDepends();
}
