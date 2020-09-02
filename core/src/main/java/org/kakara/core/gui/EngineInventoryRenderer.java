package org.kakara.core.gui;

import org.kakara.core.gui.menu.items.MenuElement;
import org.kakara.core.resources.Texture;

import java.util.Set;

public class EngineInventoryRenderer implements InventoryRenderer {
    private final Texture inventoryBackground;
    private final Set<MenuElement> elementList;
    private EngineController engineController;

    public EngineInventoryRenderer(Texture inventoryBackground, Set<MenuElement> elementList) {
        this.inventoryBackground = inventoryBackground;
        this.elementList = elementList;
    }

    @Override
    public void render(Inventory inventory) {
        if (engineController == null) {
            throw new IllegalStateException("Engine Controller is not ready");
        }
        engineController.render(inventory, inventoryBackground, elementList);
    }

    @Override
    public void closeInventory() {
        engineController.close();
    }

    @Override
    public void redraw(Inventory inventory) {
        if (engineController == null) {
            throw new IllegalStateException("Engine Controller is not ready");
        }
        engineController.redraw(inventory, inventoryBackground, elementList);
    }

    public void setEngineController(EngineController engineController) {
        this.engineController = engineController;
    }
}
