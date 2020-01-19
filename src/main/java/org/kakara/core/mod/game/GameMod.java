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
    private ModInfo modInfo;
    private ModRules modRules;

    protected GameMod() {
        modInfo = getClass().getAnnotation(ModInfo.class);
        modRules = new GameModRules(modInfo);
    }

    public void setKakaraCore(KakaraCore kakaraCore) {
        this.kakaraCore = kakaraCore;
    }

    public String getName() {
        return modInfo.name();
    }

    @Override
    public String getVersion() {
        return modInfo.version();
    }

    @Override
    public String[] getAuthors() {
        return modInfo.authors();
    }

    @Override
    public String getDescription() {
        return modInfo.description();
    }

    @Override
    public ModType getModType() {
        return modInfo.modType();
    }

    void enable() {
        Method method = MethodFinder.getFirstMethodWithAnnotation(getClass(), OnEnable.class, true);

        method.setAccessible(true);
        try {
            method.invoke(this);
        } catch (IllegalAccessException | InvocationTargetException e) {
            KakaraCore.LOGGER.error("Unable to invoke enableMethod", e);
        }
    }

    void disable() {
        Method method = MethodFinder.getFirstMethodWithAnnotation(getClass(), OnDisable.class, true);
        if (method == null) return;
        method.setAccessible(true);
        try {
            method.invoke(this);
        } catch (IllegalAccessException | InvocationTargetException e) {
            KakaraCore.LOGGER.error("Unable to invoke onDisable", e);
        }
    }

    void reload() {
        Method method = MethodFinder.getFirstMethodWithAnnotation(getClass(), Reload.class, true);
        method.setAccessible(true);
        try {
            method.invoke(this);
        } catch (IllegalAccessException | InvocationTargetException e) {
            KakaraCore.LOGGER.error("Unable to invoke reloadMethod", e);
        }
    }

    @Override
    public KakaraCore getKakaraCore() {
        return null;
    }

    protected void registerResource(String path, ResourceType type) {
        kakaraCore.getResourceManager().registerResource(path, type, this);
    }


}
