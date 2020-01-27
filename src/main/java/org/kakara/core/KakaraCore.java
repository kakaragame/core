package org.kakara.core;

import org.kakara.core.crafting.CraftingManager;
import org.kakara.core.events.EventManager;
import org.kakara.core.game.ItemManager;
import org.kakara.core.mod.ModManager;
import org.kakara.core.resources.ResourceManager;
import org.kakara.core.sound.SoundManager;
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
    private static KakaraCore core;
    private ItemManager itemManager;
    private EventManager eventManager;
    private File workingDirectory;

    public KakaraCore(ModManager modManager, GameInstance gameInstance, ResourceManager resourceManager, CraftingManager craftingManager, SoundManager soundManager, ItemManager itemManager, EventManager eventManager, File workingDirectory) {
        this.modManager = modManager;
        this.gameInstance = gameInstance;
        this.resourceManager = resourceManager;
        this.craftingManager = craftingManager;
        this.soundManager = soundManager;
        this.itemManager = itemManager;
        this.eventManager = eventManager;
        this.workingDirectory = workingDirectory;
        core = this;
    }

    private void load() throws IOException {
        modManager.load(this);
        resourceManager.load(this);
        itemManager.load(this);
    }

    /**
     * Not Sure if I am actually gonna do this
     *
     * @return the kakaracore
     */
    @Deprecated
    public static KakaraCore getKakaraCore() {
        return core;
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


    public EventManager getEventManager() {
        return eventManager;
    }
}
