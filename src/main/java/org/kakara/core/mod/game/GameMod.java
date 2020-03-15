package org.kakara.core.mod.game;

import me.kingtux.simpleannotation.MethodFinder;
import org.kakara.core.GameInstance;
import org.kakara.core.Kakara;
import org.kakara.core.mod.Mod;
import org.kakara.core.mod.ModRules;
import org.kakara.core.mod.ModType;
import org.kakara.core.mod.annotations.ModInfo;
import org.kakara.core.mod.annotations.OnDisable;
import org.kakara.core.mod.annotations.OnEnable;
import org.kakara.core.mod.annotations.Reload;
import org.kakara.core.resources.ResourceType;
import org.slf4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class GameMod implements Mod {
    private GameInstance gameInstance;
    private ModRules modRules;
    private ModClassLoader modClassLoader;
    private Logger logger;

    protected GameMod() {
    }

    @Override
    public void preEnable() {

    }

    @Override
    public void postEnable() {

    }

    public void setGameInstance(GameInstance Kakara) {
        this.gameInstance = Kakara;
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


    @Override
    public GameInstance getGameInstance() {
        return gameInstance;
    }

    protected void registerResource(String path, ResourceType type) {
        gameInstance.getResourceManager().registerResource(path, type, this);
    }

    @Override
    public Logger getLogger() {
        return logger;
    }

    void setLogger(Logger logger) {
        this.logger = logger;
    }

    ModClassLoader getClassLoader() {
        return modClassLoader;
    }

    void setModClassLoader(ModClassLoader modClassLoader) {
        this.modClassLoader = modClassLoader;
    }

    @Override
    public ModRules getModRules() {
        return modRules;
    }

    void setModRules(ModRules modRules) {
        this.modRules = modRules;
    }
}
