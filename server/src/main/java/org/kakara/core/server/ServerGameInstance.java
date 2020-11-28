package org.kakara.core.server;

import org.kakara.core.common.GameInstance;
import org.kakara.core.common.game.Item;
import org.kakara.core.common.game.ItemStack;

public interface ServerGameInstance extends GameInstance {
    ItemStack createItemStack(Item item);
}
