package org.kakara.core;

import org.kakara.core.crafting.CraftingManager;
import org.kakara.core.events.EventManager;
import org.kakara.core.game.Item;
import org.kakara.core.game.ItemManager;
import org.kakara.core.game.ItemStack;
import org.kakara.core.mod.ModManager;
import org.kakara.core.resources.ResourceManager;
import org.kakara.core.sound.SoundManager;

import java.io.File;
import java.io.IOException;

public class Kakara {
    private static KakaraCore kakaraCore;

    public static KakaraCore getKakaraCore() {
        return kakaraCore;
    }

    public static void setKakaraCore(KakaraCore kakaraCore) {
        if (Kakara.kakaraCore != null) {
            throw new IllegalArgumentException("Cant do that sonny");
        }
        Kakara.kakaraCore = kakaraCore;
    }


    public static ItemStack createItemStack(Item item) {
        return kakaraCore.createItemStack(item);
    }

    public static ResourceManager getResourceManager() {
        return kakaraCore.getResourceManager();
    }

    public static SoundManager getSoundManager() {
        return kakaraCore.getSoundManager();
    }

    public static ItemManager getItemManager() {
        return kakaraCore.getItemManager();
    }

    public static CraftingManager getCraftingManager() {
        return kakaraCore.getCraftingManager();
    }

    public static ModManager getModManager() {
        return kakaraCore.getModManager();
    }

    public static GameType getGameType() {
        return kakaraCore.getGameType();
    }

    public static GameInstance getGameInstance() {
        return kakaraCore.getGameInstance();
    }

    public static File getWorkingDirectory() {
        return kakaraCore.getWorkingDirectory();
    }

    public static EventManager getEventManager() {
        return kakaraCore.getEventManager();
    }
}
