package org.kakara.core;

import org.kakara.core.client.Client;
import org.kakara.core.crafting.CraftingManager;
import org.kakara.core.mod.ModManager;
import org.kakara.core.resources.ResourceManager;
import org.kakara.core.server.Server;
import org.kakara.core.sound.SoundManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KakaraCore {
    private ModManager modManager;
    private GameType gameType;
    private GameInstance gameInstance;
    public static Logger LOGGER = LoggerFactory.getLogger(KakaraCore.class);
    private ResourceManager resourceManager;
    private CraftingManager craftingManager;
    private SoundManager soundManager;
    private static KakaraCore core;

    /**
     * Not Sure if I am actually gonna do this
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
}
