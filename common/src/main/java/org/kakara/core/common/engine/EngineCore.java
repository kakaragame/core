package org.kakara.core.common.engine;


import org.kakara.core.common.gui.EngineController;
import org.kakara.core.common.gui.dynamic.DynamicEngineInventoryRenderer;

/**
 * This is where all instances of engine core interaction.
 */
public class EngineCore {
    private static EngineController engineController;
    private static DynamicEngineInventoryRenderer dynamicEngineInventoryRenderer;

    public static EngineController getEngineController() {
        return engineController;
    }

    public static void setEngineController(EngineController engineController) {
        EngineCore.engineController = engineController;
    }

    public static DynamicEngineInventoryRenderer getDynamicEngineInventoryRenderer() {
        return dynamicEngineInventoryRenderer;
    }

    public static void setDynamicEngineInventoryRenderer(DynamicEngineInventoryRenderer engineController) {
        EngineCore.dynamicEngineInventoryRenderer = engineController;
    }

}
