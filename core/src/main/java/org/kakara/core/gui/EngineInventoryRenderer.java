package org.kakara.core.gui;

import org.kakara.core.game.ItemStack;
import org.kakara.core.gui.menu.items.MenuElement;
import org.kakara.core.resources.Texture;

import java.util.List;
import java.util.UUID;

public class EngineInventoryRenderer implements InventoryRenderer {
    private EngineController engineController;
    private final Texture inventoryBackground;
    private final List<MenuElement> elementList;

    public EngineInventoryRenderer(Texture inventoryBackground, List<MenuElement> elementList) {
        this.inventoryBackground = inventoryBackground;
        this.elementList = elementList;
    }

    @Override
    public void render(ItemStack[] itemStacks) {
        if (engineController == null) {
            throw new IllegalStateException("Engine Controller is not ready");
        }
        engineController.render(itemStacks, inventoryBackground, elementList);
    }

    @Override
    public void closeInventory() {
        engineController.close();
    }

    public void setEngineController(EngineController engineController) {
        this.engineController = engineController;
    }
}
