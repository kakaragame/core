package org.kakara.core.server.gui;

import org.apache.commons.lang3.Validate;
import org.kakara.core.common.EnvType;
import org.kakara.core.common.Kakara;
import org.kakara.core.common.game.ItemStack;
import org.kakara.core.server.ServerGameInstance;

import java.util.ArrayList;
import java.util.List;

public class InventoryUtils {
    public static List<ItemStack> listWithAir(int capacity) {
        Validate.isTrue(Kakara.getEnvironmentInstance().getType() == EnvType.SERVER);
        List<ItemStack> itemStacks = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            //Kakara.getItemManager().getItem(0))
            itemStacks.add(((ServerGameInstance) Kakara.getGameInstance()).createItemStack(null));
        }
        return itemStacks;
    }
}
