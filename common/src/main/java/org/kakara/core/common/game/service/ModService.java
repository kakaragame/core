package org.kakara.core.common.game.service;


import org.kakara.core.common.ControllerKey;
import org.kakara.core.common.service.Service;

public abstract class ModService implements Service {
    private final ControllerKey implementationNameKey;
    private final ControllerKey serviceNameKey;

    public ModService(ControllerKey implementationNameKey, ControllerKey serviceNameKey) {
        this.implementationNameKey = implementationNameKey;
        this.serviceNameKey = serviceNameKey;
    }

    @Override
    public final ControllerKey getImplementationControllerKey() {
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
    public final ControllerKey getControllerKey() {
        return serviceNameKey;
    }

    @Override
    public final String getName() {
        return serviceNameKey.getKey();
    }

    @Override
    public String getKey() {
        return serviceNameKey.getKey();
    }

    @Override
    public final int getId() {
        return serviceNameKey.hashCode();
    }
}
