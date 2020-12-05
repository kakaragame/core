package org.kakara.core.common.mod.environment;

import org.kakara.core.common.ControllerKey;
import org.kakara.core.common.GameInstance;
import org.kakara.core.common.Kakara;
import org.kakara.core.common.mod.Mod;
import org.kakara.core.common.mod.ModRules;
import org.kakara.core.common.mod.ModType;
import org.kakara.core.common.resources.ResourceType;
import org.slf4j.Logger;

public class EnvironmentMod implements Mod {
    private ModRules modRules;
    private EnvironmentClassLoader modClassLoader;
    private Logger logger;
    private String upperCaseName;

    protected EnvironmentMod() {
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
        return Kakara.getGameInstance();
    }



    protected void registerResource(String path, ResourceType type) {
        //getGameInstance().getResourceManager().registerResource(path, type, this);
    }

    @Override
    public Logger getLogger() {
        return logger;
    }

    void setLogger(Logger logger) {
        this.logger = logger;
    }

    EnvironmentClassLoader getClassLoader() {
        return modClassLoader;
    }

    void setModClassLoader(EnvironmentClassLoader modClassLoader) {
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
