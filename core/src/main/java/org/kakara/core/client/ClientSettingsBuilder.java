package org.kakara.core.client;

/**
 * This builds you a ClientSettingsObject easily.
 */
public class ClientSettingsBuilder {
    private String authServer;
    private String[] modServers;
    private boolean testMode = false;
    private String authToken;

    /**
     * @param authServer the link to the authentication server.
     * @return the builder
     */
    public ClientSettingsBuilder setAuthServer(String authServer) {
        this.authServer = authServer;
        return this;
    }

    /**
     * @param modServers the array of links to the mod servers.
     * @return the builder
     */
    public ClientSettingsBuilder setModServers(String[] modServers) {
        this.modServers = modServers;
        return this;
    }

    /**
     * @param testMode is the client in test mode?
     * @return the builder
     */
    public ClientSettingsBuilder setTestMode(boolean testMode) {
        this.testMode = testMode;
        return this;
    }

    /**
     * @param authToken the authentication token for the client.
     * @return the builder
     */
    public ClientSettingsBuilder setAuthToken(String authToken) {
        this.authToken = authToken;
        return this;
    }

    /**
     * @return the built ClientSettings object.
     */
    public ClientSettings createClientSettings() {
        return new ClientSettings(authServer, modServers, testMode, authToken);
    }
}