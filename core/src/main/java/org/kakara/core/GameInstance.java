package org.kakara.core;

import org.kakara.core.crafting.CraftingManager;
import org.kakara.core.data.SerializerManager;
import org.kakara.core.events.EventManager;
import org.kakara.core.game.*;
import org.kakara.core.game.entity.EntityManager;
import org.kakara.core.mod.ModManager;
import org.kakara.core.player.OfflinePlayer;
import org.kakara.core.resources.ResourceManager;
import org.kakara.core.sound.SoundManager;
import org.kakara.core.world.WorldGenerationManager;
import org.kakara.core.world.WorldManager;

import java.io.File;
import java.util.UUID;

public interface GameInstance {
    GameSettings getGameSettings();

    ItemStack createItemStack(Item item);

    ResourceManager getResourceManager();

    SoundManager getSoundManager();

    ItemManager getItemManager();

    EntityManager getEntityManager();

    CraftingManager getCraftingManager();

    WorldManager getWorldManager();

    ModManager getModManager();

    File getWorkingDirectory();

    EventManager getEventManager();

    WorldGenerationManager getWorldGenerationManager();

    SerializerManager getSerializerManager();

    OfflinePlayer getOfflinePlayer(UUID uuid);

    GameTypes getType();
}

