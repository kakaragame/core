package org.kakara.core.common;

import org.kakara.core.common.exceptions.NoServerVersionAvailableException;

/**
 * Any object that implements this may have a server version counter part.
 */
public interface Serverable {

    boolean isServerVersionAvailable();

    /**
     * @param <T> is the Servered version of this object.
     * @return The server version of this object
     */
    <T extends Serverable> T getServerVersion();

    void requiresServerVersion() throws NoServerVersionAvailableException;
}
