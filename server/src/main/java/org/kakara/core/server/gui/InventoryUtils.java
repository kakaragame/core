package org.kakara.core.server.gui;

import org.kakara.core.common.KValidate;
import org.kakara.core.common.Kakara;
import org.kakara.core.common.game.ItemStack;
import org.kakara.core.server.ServerGameInstance;
import org.kakara.core.server.game.ServerItemStack;

import java.util.ArrayList;
import java.util.List;

public class InventoryUtils {
    public static ServerItemStack[] arrayWithAir(int capacity) {
        KValidate.gameInstanceCheckServer();
        ServerItemStack[] serverItemStacks = new ServerItemStack[capacity];
        for (int i = 0; i < capacity; i++) {
            serverItemStacks[i] = ((ServerGameInstance) Kakara.getGameInstance()).createItemStack(Kakara.getGameInstance().getItemManager().getItem(0));
        }
        return serverItemStacks;
    }
}
