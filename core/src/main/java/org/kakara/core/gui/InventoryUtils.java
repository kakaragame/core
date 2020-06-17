package org.kakara.core.gui;

import org.kakara.core.Kakara;
import org.kakara.core.game.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class InventoryUtils {
    public static List<ItemStack> listWithAir(int capacity) {
        List<ItemStack> itemStacks = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            itemStacks.set(i, Kakara.createItemStack(Kakara.getItemManager().getItem(0).get()));
        }
        return itemStacks;
    }
}
