package org.kakara.core.common.mod.game;


import org.kakara.core.common.ControllerKey;
import org.kakara.core.common.GameInstance;
import org.kakara.core.common.mod.Mod;
import org.kakara.core.common.mod.ModRules;
import org.kakara.core.common.mod.ModType;
import org.kakara.core.common.resources.ResourceType;
import org.slf4j.Logger;

public abstract class GameMod implements Mod {
    private GameInstance gameInstance;
    private ModRules modRules;
    private ModClassLoader modClassLoader;
    private Logger logger;
    private String upperCaseName;

    protected GameMod() {
    }

    @Override
    public void preEnable() {

    }

    @Override
    public void postEnable() {

    }

    @Override
    public void enableCompletion() {

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

    public void setGameInstance(GameInstance Kakara) {
        this.gameInstance = Kakara;
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
        upperCaseName = modRules.getName().toUpperCase();
    }

    /**
     * Creates a ControllerKey with the mod
     *
     * @param key the key
     * @return the new ControllerKey
     */
    public ControllerKey createControllerKey(String key) {
        return new ControllerKey(this, key);
    }

    @Override
    public String getUppercaseName() {
        return upperCaseName;
    }
}
