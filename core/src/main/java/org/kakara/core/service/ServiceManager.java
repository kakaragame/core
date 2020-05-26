package org.kakara.core.service;

import org.kakara.core.NameKey;

import java.util.Optional;

public interface ServiceManager {
    Optional<Service> getService(NameKey nameKey);


    void registerService(Service service);
}
