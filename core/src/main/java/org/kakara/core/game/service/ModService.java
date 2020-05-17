package org.kakara.core.game.service;

import org.kakara.core.NameKey;
import org.kakara.core.service.Service;

public abstract class ModService implements Service {
    private final NameKey implementationNameKey;
    private final NameKey serviceNameKey;

    public ModService(NameKey implementationNameKey, NameKey serviceNameKey) {
        this.implementationNameKey = implementationNameKey;
        this.serviceNameKey = serviceNameKey;
    }

    @Override
    public final NameKey getImplementationNameKey() {
        return implementationNameKey;
    }

    @Override
    public final String getImplementationName() {
        return implementationNameKey.getKey();
    }

    @Override
    public final int getImplementationId() {
        return implementationNameKey.hashCode();
    }

    @Override
    public final NameKey getNameKey() {
        return serviceNameKey;
    }

    @Override
    public final String getName() {
        return serviceNameKey.getKey();
    }

    @Override
    public final int getId() {
        return serviceNameKey.hashCode();
    }
}
