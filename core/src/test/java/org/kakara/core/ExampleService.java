package org.kakara.core;

import org.kakara.core.game.service.ModService;
import org.kakara.core.service.Service;

public abstract class ExampleService extends ModService {
    public ExampleService(ControllerKey implementationNameKey) {
        super(implementationNameKey, new ControllerKey("EXAMPLE", "SERVICE"));
    }

    public abstract void doStuff();

    @Override
    public final Class<? extends Service> getServiceClass() {
        return ExampleService.class;
    }
}
