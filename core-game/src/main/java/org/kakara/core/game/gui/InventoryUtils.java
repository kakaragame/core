package org.kakara.core.game.gui;


import java.util.ArrayList;
import java.util.List;

public class InventoryUtils {
    public static List<ItemStack> listWithAir(int capacity) {
        List<ItemStack> itemStacks = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            itemStacks.add(Kakara.createItemStack(Kakara.getItemManager().getItem(0)));
        }
        return itemStacks;
    }
}
