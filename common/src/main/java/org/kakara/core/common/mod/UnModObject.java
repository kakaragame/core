package org.kakara.core.common.mod;

/**
 * This is one of those classes that you kinda just ignore.
 * <p>
 * It is used for internal uses.
 *
 * @since 1.0
 */
public class UnModObject {
    private final ModRules modRules;
    private final ClassLoader modClassLoader;

    public UnModObject(ModRules modRules, ClassLoader modClassLoader) {
        this.modRules = modRules;
        this.modClassLoader = modClassLoader;
    }

    public ModRules getModRules() {
        return modRules;
    }

    public ClassLoader getModClassLoader() {
        return modClassLoader;
    }
}
