package org.kakara.core;

import org.kakara.core.client.Client;
import org.kakara.core.mod.ModManager;
import org.kakara.core.server.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KakaraCore {
    private ModManager modManager;
    private GameType gameType;
    private GameInstance gameInstance;
    public static Logger LOGGER = LoggerFactory.getLogger(KakaraCore.class);
}
