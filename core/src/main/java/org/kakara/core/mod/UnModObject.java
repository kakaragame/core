package org.kakara.core.mod;

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
