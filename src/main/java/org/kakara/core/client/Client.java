package org.kakara.core.client;

import org.kakara.core.GameInstance;
import org.kakara.core.exceptions.InvalidImplementationException;

public interface Client extends GameInstance {

    default ClientSettings getClientSettings() {
        if (!(getGameSettings() instanceof ClientSettings)) {
            throw new InvalidImplementationException("You failed to create an implementation of Client correctly");
        }
        return ((ClientSettings) getGameSettings());
    }

}
