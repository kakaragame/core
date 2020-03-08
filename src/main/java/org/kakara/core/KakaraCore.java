package org.kakara.core;

import org.kakara.core.crafting.CraftingManager;
import org.kakara.core.events.EventManager;
import org.kakara.core.game.Block;
import org.kakara.core.game.Item;
import org.kakara.core.game.ItemManager;
import org.kakara.core.game.ItemStack;
import org.kakara.core.mod.ModManager;
import org.kakara.core.resources.ResourceManager;
import org.kakara.core.sound.SoundManager;
import org.kakara.core.world.WorldGenerationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class KakaraCore {
    private ModManager modManager;
    private GameInstance gameInstance;
    public static Logger LOGGER = LoggerFactory.getLogger(KakaraCore.class);
    private ResourceManager resourceManager;
    private CraftingManager craftingManager;
    private SoundManager soundManager;
    private ItemManager itemManager;
    private EventManager eventManager;
    private WorldGenerationManager worldGenerationManager;
    private File workingDirectory;
    private boolean loaded;

    public KakaraCore(ModManager modManager, GameInstance gameInstance, ResourceManager resourceManager, CraftingManager craftingManager, SoundManager soundManager, ItemManager itemManager, EventManager eventManager, WorldGenerationManager worldGenerationManager, File workingDirectory) {
        this.modManager = modManager;
        this.gameInstance = gameInstance;
        this.resourceManager = resourceManager;
        this.craftingManager = craftingManager;
        this.soundManager = soundManager;
        this.itemManager = itemManager;
        this.eventManager = eventManager;
        this.worldGenerationManager = worldGenerationManager;
        this.workingDirectory = workingDirectory;
    }

    public void load() throws IOException {
        if (loaded) return;
        loaded = true;
        modManager.load(this);
        resourceManager.load(this);
        itemManager.load(this);
    }

    public ItemStack createItemStack(Item item) {
        return gameInstance.createItemStack(item);
    }

    public ResourceManager getResourceManager() {
        return resourceManager;
    }

    public SoundManager getSoundManager() {
        return soundManager;
    }

    public ItemManager getItemManager() {
        return itemManager;
    }

    public CraftingManager getCraftingManager() {
        return craftingManager;
    }

    public ModManager getModManager() {
        return modManager;
    }

    public GameType getGameType() {
        return gameInstance.getType();
    }

    public GameInstance getGameInstance() {
        return gameInstance;
    }

    public File getWorkingDirectory() {
        return workingDirectory;
    }

    public EventManager getEventManager() {
        return eventManager;
    }

    public WorldGenerationManager getWorldGenerationManager() {
        return worldGenerationManager;
    }

    public Item getItem(String item) {
        return itemManager.getItem(item);
    }

    public Block getBlock(String block) {
        return itemManager.getBlock(block);
    }
}
