package org.kakara.core.server.gui;

import org.kakara.core.common.KValidate;
import org.kakara.core.common.Kakara;
import org.kakara.core.common.game.ItemStack;
import org.kakara.core.server.ServerGameInstance;

import java.util.ArrayList;
import java.util.List;

public class InventoryUtils {
    public static List<ItemStack> listWithAir(int capacity) {
        KValidate.checkServer();
        List<ItemStack> itemStacks = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            itemStacks.add(((ServerGameInstance) Kakara.getGameInstance()).createItemStack(Kakara.getGameInstance().getItemManager().getItem(0)));
        }
        return itemStacks;
    }
}
