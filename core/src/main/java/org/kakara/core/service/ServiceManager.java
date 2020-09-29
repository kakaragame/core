package org.kakara.core.service;

import org.kakara.core.ControllerKey;

import java.util.Optional;

public interface ServiceManager {
    Optional<Service> getService(ControllerKey nameKey);


    void registerService(Service service);
}
