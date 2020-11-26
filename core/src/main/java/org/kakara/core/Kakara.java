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
import org.kakara.core.service.ServiceManager;
import org.kakara.core.sound.SoundManager;
import org.kakara.core.world.WorldGenerationManager;
import org.kakara.core.world.WorldManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.UUID;

/**
 * Represents the core of the Kakara API.
 */
public class Kakara {
    public static final Logger LOGGER = LoggerFactory.getLogger("Kakara Core");
    private static GameInstance gameInstance;

    public static GameInstance getGameInstance() {
        return gameInstance;
    }

    /**
     * Can only be called once.
     * Will be called upon creating an instance
     *
     * @param gameInstance the gameinstance
     */
    public static void setGameInstance(GameInstance gameInstance) {
        if (Kakara.gameInstance != null) {
            throw new IllegalArgumentException("GameInstance has already been set. ");
        }
        Kakara.gameInstance = gameInstance;
    }

    public static GameSettings getGameSettings() {
        return getGameInstance().getGameSettings();
    }

    public static ItemStack createItemStack(Item item) {
        return getGameInstance().createItemStack(item);
    }

    public static ResourceManager getResourceManager() {
        return getGameInstance().getResourceManager();
    }

    public static SoundManager getSoundManager() {
        return getGameInstance().getSoundManager();
    }

    public static ItemManager getItemManager() {
        return getGameInstance().getItemManager();
    }

    public static CraftingManager getCraftingManager() {
        return getGameInstance().getCraftingManager();
    }

    public static WorldManager getWorldManager() {
        return getGameInstance().getWorldManager();
    }

    public static ModManager getModManager() {
        return getGameInstance().getModManager();
    }

    public static File getWorkingDirectory() {
        return getGameInstance().getWorkingDirectory();
    }

    public static EventManager getEventManager() {
        return getGameInstance().getEventManager();
    }

    public static CommandManager getCommandManager() {
        return getGameInstance().getCommandManager();
    }

    public static WorldGenerationManager getWorldGenerationManager() {
        return getGameInstance().getWorldGenerationManager();
    }

    /**
     * Warning. Doing this without properly closing down the rest of the game could result in destrctuction of anything within the game.
     * <p>
     * This should only be called by Kakara itself.
     */
    public void coreClose() {
        Kakara.gameInstance = null;

    }

    public static EntityManager getEntityManager() {
        return getGameInstance().getEntityManager();
    }


    public static EnvType getType() {
        return getGameInstance().getType();
    }

    public static ServiceManager getServiceManager() {
        return getGameInstance().getServiceManager();
    }

    public static OfflinePlayer getOfflinePlayer(UUID uuid) {
        return getGameInstance().getOfflinePlayer(uuid);
    }
}
