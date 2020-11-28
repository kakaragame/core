package org.kakara.core.common.gui;


import org.kakara.core.common.engine.EngineCore;
import org.kakara.core.common.gui.menu.items.MenuElement;
import org.kakara.core.common.resources.Texture;

import java.util.Set;

public class EngineInventoryRenderer implements InventoryRenderer {
    private final Texture inventoryBackground;
    private final Set<MenuElement> elementList;
    private final InventoryProperties properties;

    public EngineInventoryRenderer(Texture inventoryBackground, Set<MenuElement> elementList, InventoryProperties properties) {
        this.inventoryBackground = inventoryBackground;
        this.elementList = elementList;
        this.properties = properties;
    }

    @Override
    public void render(Inventory inventory) {
        if (EngineCore.getEngineController() == null) {
            throw new IllegalStateException("Engine Controller is not ready");
        }
        EngineCore.getEngineController().render(inventory, inventoryBackground, elementList, properties);
    }

    @Override
    public void closeInventory() {
        EngineCore.getEngineController().close();
    }

    @Override
    public void redraw(Inventory inventory) {
        if (EngineCore.getEngineController() == null) {
            throw new IllegalStateException("Engine Controller is not ready");
        }
        EngineCore.getEngineController().redraw(inventory, inventoryBackground, elementList, properties);
    }

    @Override
    public InventoryProperties getProperties() {
        return properties;
    }

}
