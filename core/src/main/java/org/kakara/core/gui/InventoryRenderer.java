package org.kakara.core.gui;

import org.kakara.core.game.ItemStack;

import java.util.UUID;

public interface InventoryRenderer {

    void render(ItemStack[] itemStacks);

    void closeInventory();
}
