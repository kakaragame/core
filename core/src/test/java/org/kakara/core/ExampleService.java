package org.kakara.core;

import org.kakara.core.game.service.ModService;

public abstract class ExampleService extends ModService {
    public ExampleService(ControllerKey implementationNameKey) {
        super(implementationNameKey, new ControllerKey("EXAMPLE", "SERVICE"));
    }

    public abstract void doStuff();
}
