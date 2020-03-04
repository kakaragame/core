package org.kakara.core.mod.game;

import me.kingtux.simpleannotation.MethodFinder;
import org.kakara.core.KakaraCore;
import org.kakara.core.mod.Mod;
import org.kakara.core.mod.ModRules;
import org.kakara.core.mod.ModType;
import org.kakara.core.mod.annotations.ModInfo;
import org.kakara.core.mod.annotations.OnDisable;
import org.kakara.core.mod.annotations.OnEnable;
import org.kakara.core.mod.annotations.Reload;
import org.kakara.core.resources.ResourceType;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class GameMod implements Mod {
    private KakaraCore kakaraCore;
    private ModRules modRules;
    private ModClassLoader modClassLoader;

    protected GameMod() {
        ModInfo modInfo = getClass().getAnnotation(ModInfo.class);
        modRules = new GameModRules(modInfo);
    }

    public void setKakaraCore(KakaraCore kakaraCore) {
        this.kakaraCore = kakaraCore;
    }

    public String getName() {
        return modRules.getName();
    }

    @Override
    public String getVersion() {
        return modRules.getVersion();
    }

    @Override
    public String[] getAuthors() {
        return modRules.getAuthors();
    }

    @Override
    public String getDescription() {
        return modRules.getDescription();
    }

    @Override
    public ModType getModType() {
        return modRules.getModType();
    }

    void enable() {
        Method method = MethodFinder.getFirstMethodWithAnnotation(getClass(), OnEnable.class, true).get();

        method.setAccessible(true);
        try {
            method.invoke(this);
        } catch (IllegalAccessException | InvocationTargetException e) {
            KakaraCore.LOGGER.error("Unable to invoke enableMethod", e);
        }
    }

    void disable() {
        Method method = MethodFinder.getFirstMethodWithAnnotation(getClass(), OnDisable.class, true).get();
        if (method == null) return;
        method.setAccessible(true);
        try {
            method.invoke(this);
        } catch (IllegalAccessException | InvocationTargetException e) {
            KakaraCore.LOGGER.error("Unable to invoke onDisable", e);
        }
    }

    void reload() {
        Method method = MethodFinder.getFirstMethodWithAnnotation(getClass(), Reload.class, true).get();
        method.setAccessible(true);
        try {
            method.invoke(this);
        } catch (IllegalAccessException | InvocationTargetException e) {
            KakaraCore.LOGGER.error("Unable to invoke reloadMethod", e);
        }
    }

    @Override
    public KakaraCore getKakaraCore() {
        return kakaraCore;
    }

    protected void registerResource(String path, ResourceType type) {
        kakaraCore.getResourceManager().registerResource(path, type, this);
    }

    protected ModClassLoader getClassLoader() {
        return modClassLoader;
    }

    protected void setModClassLoader(ModClassLoader modClassLoader) {
        this.modClassLoader = modClassLoader;
    }

    @Override
    public ModRules getModRules() {
        return modRules;
    }
}
