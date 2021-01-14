package org.kakara.core.common.gui.container;

import org.jetbrains.annotations.NotNull;
import org.kakara.core.common.Serverable;
import org.kakara.core.common.game.ItemStack;

/**
 * InventoryContainer is a basic container to hold data within an Inventory.
 * Everything is stored inside a array using.
 */
public interface InventoryContainer extends Iterable<ItemStack>, Serverable {

    @NotNull
    ItemStack getItemStack(int index);

    @NotNull
    ItemStack[] getContents();

    int getNextEmtpySlot();

}
