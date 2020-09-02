package org.kakara.core;

import org.kakara.core.command.CommandManager;
import org.kakara.core.crafting.CraftingManager;
import org.kakara.core.events.EventManager;
import org.kakara.core.game.GameSettings;
import org.kakara.core.game.Item;
import org.kakara.core.game.ItemManager;
import org.kakara.core.game.ItemStack;
import org.kakara.core.game.entity.EntityManager;
import org.kakara.core.mod.ModManager;
import org.kakara.core.player.OfflinePlayer;
import org.kakara.core.resources.ResourceManager;
import org.kakara.core.sound.SoundManager;
import org.kakara.core.world.WorldGenerationManager;
import org.kakara.core.world.WorldManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.UUID;

public class Kakara {
    public static final Logger LOGGER = LoggerFactory.getLogger("Kakara Core");
    private static GameInstance gameInstance;

    public static GameInstance getGameInstance() {
        return gameInstance;
    }

    public static void setGameInstance(GameInstance gameInstance) {
        if (Kakara.gameInstance != null) {
            throw new IllegalArgumentException("GameInstance has already been set. ");
        }
        Kakara.gameInstance = gameInstance;
    }

    public static GameSettings getGameSettings() {
        return gameInstance.getGameSettings();
    }

    public static ItemStack createItemStack(Item item) {
        return gameInstance.createItemStack(item);
    }

    public static ResourceManager getResourceManager() {
        return gameInstance.getResourceManager();
    }

    public static SoundManager getSoundManager() {
        return gameInstance.getSoundManager();
    }

    public static ItemManager getItemManager() {
        return gameInstance.getItemManager();
    }

    public static CraftingManager getCraftingManager() {
        return gameInstance.getCraftingManager();
    }

    public static WorldManager getWorldManager() {
        return gameInstance.getWorldManager();
    }

    public static ModManager getModManager() {
        return gameInstance.getModManager();
    }

    public static File getWorkingDirectory() {
        return gameInstance.getWorkingDirectory();
    }

    public static EventManager getEventManager() {
        return gameInstance.getEventManager();
    }

    public static CommandManager getCommandManager() {
        return gameInstance.getCommandManager();
    }

    public static WorldGenerationManager getWorldGenerationManager() {
        return gameInstance.getWorldGenerationManager();
    }

    public static EntityManager getEntityManager() {
        return gameInstance.getEntityManager();
    }


    public static GameTypes getType() {
        return gameInstance.getType();
    }

    public static OfflinePlayer getOfflinePlayer(UUID uuid) {
        return gameInstance.getOfflinePlayer(uuid);
    }
}
