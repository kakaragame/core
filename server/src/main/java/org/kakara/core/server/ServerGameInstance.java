package org.kakara.core.server;

import org.kakara.core.common.GameInstance;
import org.kakara.core.common.game.Item;
import org.kakara.core.server.game.ServerItemStack;

public interface ServerGameInstance extends GameInstance {

    ServerItemStack createItemStack(Item item);
}
