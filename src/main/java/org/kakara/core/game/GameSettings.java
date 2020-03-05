package org.kakara.core.game;

/**
 * Settings that must be set at the start of the game.
 */
public abstract class GameSettings {
    public GameSettings(String authServer, String[] modServers, boolean testMode) {
        this.authServer = authServer;
        this.modServers = modServers;
        this.testMode = testMode;
    }

    /**
     * This the server. That the client and Server will use to get skins, Users Names, UUID, and for the client get the login token for logging in and stuff
     * <p>
     * Warning if the server and Client mismatch in authServer. The server will response with an unable to verify account.
     */
    protected String authServer;
    /**
     * Servers a client or server. Can verify and get mods from.
     * <p>
     * Mostly will be used by the client to verify mods
     */
    protected String[] modServers;

    protected boolean testMode;

    public String getAuthServer() {
        return authServer;
    }

    public String[] getModServers() {
        return modServers;
    }

    public boolean isTestMode() {
        return testMode;
    }
}
