package org.kakara.core.service;

import org.kakara.core.ControllerKey;
import org.kakara.core.mod.LoadStage;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * The service manager
 */
public interface ServiceManager extends LoadStage {
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
    <T extends Service> void executeOnceServiceIsFound(Consumer<T> service, Class<? extends Service> serviceToFind);

    /**
     * Will execute the Consumer once the implementation has been registered.
     *
     * @param service       the consumer to use once the service has been found
     * @param controllerKey the service controllerkey
     */
    <T extends Service> void executeOnceServiceIsFound(Consumer<T> service, ControllerKey controllerKey);

    /**
     * Register the Service implementation
     *
     * @param service the implementation of the service
     * @see Service
     */
    void registerService(Service service);

    @Override
    default Class<?> getStageClass() {
        return ServiceManager.class;
    }
}
