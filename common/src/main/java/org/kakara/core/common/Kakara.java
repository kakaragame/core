package org.kakara.core.common;

import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents the core of the Kakara API.
 */
public class Kakara {
    public static final Logger LOGGER = LoggerFactory.getLogger("Kakara Core");
    private static EnvironmentInstance environmentInstance;
    private static GameInstance gameInstance;

    public static EnvironmentInstance getEnvironmentInstance() {
        return environmentInstance;
    }

    /**
     * Can only be called once.
     * Will be called upon creating an instance
     *
     * @param environmentInstance the gameinstance
     */
    public static void setEnvironmentInstance(EnvironmentInstance environmentInstance) {
        if (Kakara.environmentInstance != null) {
            throw new IllegalArgumentException("GameInstance has already been set. ");
        }
        Kakara.environmentInstance = environmentInstance;
    }


    @Nullable
    public static GameInstance getGameInstance() {
        return gameInstance;
    }

    public static void setGameInstance(GameInstance gameInstance) {
        Kakara.gameInstance = gameInstance;
        //Reloading Utils with proper tools
        Utils.init();
    }

    /**
     * Warning. Doing this without properly closing down the rest of the game could result in destrctuction of anything within the game.
     * <p>
     * This should only be called by Kakara itself.
     */
    public static void coreClose() {
        Kakara.gameInstance = null;

    }

}
