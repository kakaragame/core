package org.kakara.core.client;

import org.kakara.core.game.GameSettings;

public class ClientSettings extends GameSettings {
    protected String authToken;

    public ClientSettings(String authServer, String[] modServers, boolean testMode, String authToken) {
        super(authServer, modServers, testMode);
        this.authToken = authToken;
    }

    public String getAuthToken() {
        return authToken;
    }
}
