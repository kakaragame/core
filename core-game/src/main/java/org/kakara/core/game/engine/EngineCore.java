package org.kakara.core.game.engine;

import org.kakara.core.game.gui.EngineController;

/**
 * This is where all instances of engine core interaction.
 */
public class EngineCore {
    private static EngineController engineController;

    public static EngineController getEngineController() {
        return engineController;
    }

    public static void setEngineController(EngineController engineController) {
        EngineCore.engineController = engineController;
    }
}
