package org.kakara.core;

import org.kakara.core.crafting.CraftingManager;
import org.kakara.core.events.EventManager;
import org.kakara.core.game.ItemManager;
import org.kakara.core.mod.ModManager;
import org.kakara.core.resources.ResourceManager;
import org.kakara.core.sound.SoundManager;

public class KakaraCoreBuilder {
    private ModManager modManager;
    private GameType gameType;
    private GameInstance gameInstance;
    private ResourceManager resourceManager;
    private CraftingManager craftingManager;
    private SoundManager soundManager;
    private ItemManager itemManager;
    private EventManager eventManager;

    public KakaraCoreBuilder setModManager(ModManager modManager) {
        this.modManager = modManager;
        return this;
    }

    public KakaraCoreBuilder setGameType(GameType gameType) {
        this.gameType = gameType;
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

    public KakaraCore createKakaraCore() {
        return new KakaraCore(modManager, gameType, gameInstance, resourceManager, craftingManager, soundManager, itemManager, eventManager);
    }
}