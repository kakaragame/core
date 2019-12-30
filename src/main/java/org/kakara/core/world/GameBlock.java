package org.kakara.core.world;

import org.kakara.core.game.ItemStack;

public interface GameBlock {

    Location getLocation();

    ItemStack getItemStack();
}
