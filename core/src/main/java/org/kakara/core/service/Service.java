package org.kakara.core.service;

import org.kakara.core.ControllerKey;
import org.kakara.core.Identifiable;

/**
 * Represents a Service
 * <p>
 * All the methods from {@link Identifiable}  are to be values from the service not the Implementation!
 */
public interface Service extends Identifiable {
    /**
     * The ControllerKey for the implementation
     *
     * @return the implementation ControllerKEy
     */
    ControllerKey getImplementationControllerKey();

    /**
     * The Implementation name
     *
     * @return the implementation name
     */
    String getImplementationName();

    /**
     * The int id for the ImplementationID
     *
     * @return the id for the implementation ID
     */
    int getImplementationId();

    Class<? extends Service> getServiceClass();
}
