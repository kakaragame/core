package org.kakara.core.client;

import org.kakara.core.game.GameSettings;

/**
 * This is the setting configuration for the client.
 */
public class ClientSettings extends GameSettings {
    protected String authToken;

    /**
     * @param authServer the link to the authentication server.
     * @param modServers the array of links to the mod servers.
     * @param testMode   is the client in test mode?
     * @param authToken  the authentication token for the client.
     */
    public ClientSettings(String authServer, String[] modServers, boolean testMode, String authToken) {
        super(authServer, modServers, testMode);
        this.authToken = authToken;
    }

    /**
     * @return The authentication token for the client.
     */
    public String getAuthToken() {
        return authToken;
    }
}
