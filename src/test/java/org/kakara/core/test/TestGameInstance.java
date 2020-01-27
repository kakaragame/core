package org.kakara.core.test;

import org.kakara.core.GameInstance;
import org.kakara.core.GameType;
import org.kakara.core.game.CustomStackable;
import org.kakara.core.game.GameSettings;
import org.kakara.core.game.Item;
import org.kakara.core.game.ItemStack;

public class TestGameInstance implements GameInstance {
    @Override
    public GameSettings getGameSettings() {
        return new GameSettings();
    }

    @Override
    public ItemStack createItemStack(Item item) {
        if (item instanceof CustomStackable) {
            return ((CustomStackable) item).createItemStack();
        }
        return null;
    }

    @Override
    public GameType getType() {
        return GameType.SERVER;
    }
}
