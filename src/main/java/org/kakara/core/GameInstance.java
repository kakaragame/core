package org.kakara.core;

import org.kakara.core.game.GameSettings;
import org.kakara.core.game.Item;
import org.kakara.core.game.ItemStack;

public interface GameInstance {
    GameSettings getGameSettings();

    ItemStack createItemStack(Item item);

    GameType getType();
}

