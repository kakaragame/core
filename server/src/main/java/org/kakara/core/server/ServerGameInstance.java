package org.kakara.core.server;

import org.kakara.core.common.GameInstance;
import org.kakara.core.common.game.Item;
import org.kakara.core.common.world.WorldGenerationManager;
import org.kakara.core.server.game.ServerItemStack;
import org.kakara.core.server.world.WorldManager;

public interface ServerGameInstance extends GameInstance {

    ServerItemStack createItemStack(Item item);

    WorldManager getWorldManager();

    WorldGenerationManager getWorldGenerationManager();

    /**
     * This will tell you if you are on an actual server or just the IntegratedServer
     * @return
     */
    boolean isIntegratedServer();
}
