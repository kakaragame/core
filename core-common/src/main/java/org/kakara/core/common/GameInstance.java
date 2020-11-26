package org.kakara.core.common;

import org.kakara.core.EnvType;
import org.kakara.core.command.CommandManager;
import org.kakara.core.game.events.EventManager;
import org.kakara.core.game.game.GameSettings;
import org.kakara.core.game.game.Item;
import org.kakara.core.game.game.ItemManager;
import org.kakara.core.game.game.ItemStack;
import org.kakara.core.game.game.entity.EntityManager;
import org.kakara.core.game.world.WorldGenerationManager;
import org.kakara.core.game.world.WorldManager;
import org.kakara.core.key.KeyBindManager;
import org.kakara.core.mod.ModManager;
import org.kakara.core.player.OfflinePlayer;
import org.kakara.core.resources.ResourceManager;
import org.kakara.core.service.ServiceManager;
import org.kakara.core.sound.SoundManager;

import java.io.File;
import java.util.UUID;

public interface GameInstance {
    GameSettings getGameSettings();

    ItemStack createItemStack(Item item);

    ResourceManager getResourceManager();

    SoundManager getSoundManager();

    ItemManager getItemManager();

    EntityManager getEntityManager();


    ModManager getModManager();

    WorldManager getWorldManager();

    KeyBindManager getKeyBindManager();

    ServiceManager getServiceManager();

    File getWorkingDirectory();

    EventManager getEventManager();

    EnvType getType();

    WorldGenerationManager getWorldGenerationManager();

    CommandManager getCommandManager();

    OfflinePlayer getOfflinePlayer(UUID uuid);
}

