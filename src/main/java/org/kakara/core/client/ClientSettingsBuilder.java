package org.kakara.core.client;

public class ClientSettingsBuilder {
    private String authServer;
    private String[] modServers;
    private boolean testMode = false;
    private String authToken;

    public ClientSettingsBuilder setAuthServer(String authServer) {
        this.authServer = authServer;
        return this;
    }

    public ClientSettingsBuilder setModServers(String[] modServers) {
        this.modServers = modServers;
        return this;
    }

    public ClientSettingsBuilder setTestMode(boolean testMode) {
        this.testMode = testMode;
        return this;
    }

    public ClientSettingsBuilder setAuthToken(String authToken) {
        this.authToken = authToken;
        return this;
    }

    public ClientSettings createClientSettings() {
        return new ClientSettings(authServer, modServers, testMode, authToken);
    }
}