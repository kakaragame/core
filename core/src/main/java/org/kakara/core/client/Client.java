package org.kakara.core.client;

import org.kakara.core.GameInstance;
import org.kakara.core.exceptions.InvalidImplementationException;

/**
 * This allows you to start Kakara as a client.
 */
public interface Client extends GameInstance {
    /**
     * @return the setting configuration for the client.
     */
    default ClientSettings getClientSettings() {
        if (!(getGameSettings() instanceof ClientSettings)) {
            throw new InvalidImplementationException("You failed to create an implementation of Client correctly");
        }
        return ((ClientSettings) getGameSettings());
    }
}
