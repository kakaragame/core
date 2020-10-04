package org.kakara.core.engine;

import org.kakara.core.gui.EngineController;

public class EngineCore {
    private static EngineController engineController;

    public static EngineController getEngineController() {
        return engineController;
    }

    public static void setEngineController(EngineController engineController) {
        EngineCore.engineController = engineController;
    }
}
