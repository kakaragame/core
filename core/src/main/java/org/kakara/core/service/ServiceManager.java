package org.kakara.core.service;

import org.kakara.core.ControllerKey;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * The service manager
 */
public interface ServiceManager {
    /**
     * Look for the Service with the ControllerKey
     *
     * @param controllerKey the controllerkey for the service
     * @return the Service Optional
     */
    Optional<Service> getService(ControllerKey controllerKey);

    /**
     * Look for the Service with the Service
     *
     * @param serviceToFind the serviceToFind class
     * @return the Service Optional
     */
    Optional<Service> getService(Class<? extends Service> serviceToFind);

    /**
     * Will execute the Consumer once the implementation has been registered.
     *
     * @param service       the consumer to use once the service has been found
     * @param serviceToFind the service to find class
     */
    void executeOnceServiceIsFound(Consumer<Service> service, Class<? extends Service> serviceToFind);

    /**
     * Will execute the Consumer once the implementation has been registered.
     *
     * @param service       the consumer to use once the service has been found
     * @param controllerKey the service controllerkey
     */
    void executeOnceServiceIsFound(Consumer<Service> service, ControllerKey controllerKey);

    /**
     * Register the Service implementation
     *
     * @param service the implementation of the service
     * @see Service
     */
    void registerService(Service service);
}
