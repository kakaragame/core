package org.kakara.core.mod;

import com.google.gson.JsonObject;
import org.kakara.core.mod.game.ModClassLoader;

import java.util.Properties;

public class UnModObject {
    private ModRules modRules;
    private ClassLoader modClassLoader;

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
