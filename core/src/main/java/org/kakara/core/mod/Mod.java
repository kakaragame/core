package org.kakara.core.mod;

import org.kakara.core.GameInstance;
import org.kakara.core.GameInstance;
import org.slf4j.Logger;

public interface Mod {


    String getName();

    String getVersion();

    String[] getAuthors();

    String getDescription();

    ModType getModType();

    ModRules getModRules();

    Logger getLogger();

    GameInstance getGameInstance();

    void preEnable();

    void postEnable();

    String getUppercaseName();
}
