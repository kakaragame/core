package org.kakara.core;

import org.kakara.core.crafting.CraftingManager;
import org.kakara.core.events.EventManager;
import org.kakara.core.game.*;
import org.kakara.core.game.entity.EntityManager;
import org.kakara.core.mod.ModManager;
import org.kakara.core.resources.ResourceManager;
import org.kakara.core.sound.SoundManager;
import org.kakara.core.world.WorldGenerationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class Kakara {
    private static GameInstance gameInstance;
public static final Logger LOGGER = LoggerFactory.getLogger("Kakara Core");
    public static GameInstance getGameInstance() {
        return gameInstance;
    }

    public static void setGameInstance(GameInstance gameInstance) {
        if (Kakara.gameInstance != null) {
            throw new IllegalArgumentException("Cant do that sonny");
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

    public static ModManager getModManager() {
        return gameInstance.getModManager();
    }

    public static File getWorkingDirectory() {
        return gameInstance.getWorkingDirectory();
    }

    public static EventManager getEventManager() {
        return gameInstance.getEventManager();
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
}
