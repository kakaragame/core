package org.kakara.core.common;

import org.kakara.core.common.game.GameSettings;
import org.kakara.core.common.game.ItemManager;
import org.kakara.core.common.resources.ResourceManager;

public interface GameInstance extends Serverable {
    default EnvironmentInstance getEnvironment() {
        return Kakara.getEnvironmentInstance();
    }

    default EnvType getType() {
        return getEnvironment().getType();
    }

    ResourceManager getResourceManager();

    GameSettings getGameSettings();

    ItemManager getItemManager();
}
