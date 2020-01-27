package org.kakara.core;

import org.kakara.core.crafting.CraftingManager;
import org.kakara.core.events.EventManager;
import org.kakara.core.game.ItemManager;
import org.kakara.core.mod.ModManager;
import org.kakara.core.resources.ResourceManager;
import org.kakara.core.sound.SoundManager;

import java.io.File;
import java.io.IOException;

public class KakaraCoreBuilder {
    private ModManager modManager;
    private GameInstance gameInstance;
    private ResourceManager resourceManager;
    private CraftingManager craftingManager;
    private SoundManager soundManager;
    private ItemManager itemManager;
    private EventManager eventManager;
    private File workingDirectory;

    public KakaraCoreBuilder setModManager(ModManager modManager) {
        this.modManager = modManager;
        return this;
    }

    public KakaraCoreBuilder setGameInstance(GameInstance gameInstance) {
        this.gameInstance = gameInstance;
        return this;
    }

    public KakaraCoreBuilder setResourceManager(ResourceManager resourceManager) {
        this.resourceManager = resourceManager;
        return this;
    }

    public KakaraCoreBuilder setCraftingManager(CraftingManager craftingManager) {
        this.craftingManager = craftingManager;
        return this;
    }

    public KakaraCoreBuilder setSoundManager(SoundManager soundManager) {
        this.soundManager = soundManager;
        return this;
    }

    public KakaraCoreBuilder setItemManager(ItemManager itemManager) {
        this.itemManager = itemManager;
        return this;
    }

    public KakaraCoreBuilder setEventManager(EventManager eventManager) {
        this.eventManager = eventManager;
        return this;
    }

    public void setWorkingDirectory(File workingDirectory) {
        this.workingDirectory = workingDirectory;
    }

    public KakaraCore createKakaraCore() {
        if (workingDirectory == null) {
            try {
                workingDirectory = new File(".").getCanonicalFile();
            } catch (IOException e) {
                KakaraCore.LOGGER.error("Unable to get path", e);
            }
        }
        return new KakaraCore(modManager, gameInstance, resourceManager, craftingManager, soundManager, itemManager, eventManager, workingDirectory);
    }
}