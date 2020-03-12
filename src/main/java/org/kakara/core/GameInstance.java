package org.kakara.core;

import org.kakara.core.crafting.CraftingManager;
import org.kakara.core.events.EventManager;
import org.kakara.core.game.GameSettings;
import org.kakara.core.game.Item;
import org.kakara.core.game.ItemManager;
import org.kakara.core.game.ItemStack;
import org.kakara.core.mod.ModManager;
import org.kakara.core.resources.ResourceManager;
import org.kakara.core.sound.SoundManager;
import org.kakara.core.world.WorldGenerationManager;

import java.io.File;

public interface GameInstance {
    GameSettings getGameSettings();

    ItemStack createItemStack(Item item);

    public ResourceManager getResourceManager();

    public SoundManager getSoundManager();

    public ItemManager getItemManager();

    public CraftingManager getCraftingManager();

    public ModManager getModManager();


    public File getWorkingDirectory();

    public EventManager getEventManager();

    public WorldGenerationManager getWorldGenerationManager();

    GameType getType();
}

