package org.kakara.core.mod.game;

import org.kakara.core.mod.ModRules;
import org.kakara.core.mod.ModType;
import org.kakara.core.mod.annotations.ModInfo;

public class GameModRules implements ModRules {
    private String name;
    private String version;
    private String description;
    private String[] authors;
    private ModType type;

    public GameModRules(ModInfo modInfo) {
        name=modInfo.name();
        version=modInfo.version();
        description=modInfo.description();
        authors=modInfo.authors();
        type=modInfo.modType();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public String[] getAuthors() {
        return authors;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public ModType getModType() {
        return type;
    }

    @Override
    public String getMainClass() {
        return null;
    }

    @Override
    public String[] getSoftDepends() {
        return new String[0];
    }

    @Override
    public String[] getDepends() {
        return new String[0];
    }
}
