package org.kakara.core;

import org.kakara.core.command.CommandManager;
import org.kakara.core.crafting.CraftingManager;
import org.kakara.core.events.EventManager;
import org.kakara.core.game.GameSettings;
import org.kakara.core.game.Item;
import org.kakara.core.game.ItemManager;
import org.kakara.core.game.ItemStack;
import org.kakara.core.game.entity.EntityManager;
import org.kakara.core.key.KeyBindManager;
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

    ModManager getModManager();

    WorldManager getWorldManager();

    KeyBindManager getKeyBindManager();

    File getWorkingDirectory();

    EventManager getEventManager();

    GameTypes getType();

    WorldGenerationManager getWorldGenerationManager();

    CommandManager getCommandManager();

    OfflinePlayer getOfflinePlayer(UUID uuid);
}

