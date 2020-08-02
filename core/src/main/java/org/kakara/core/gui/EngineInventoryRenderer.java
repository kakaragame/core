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
    private UUID uuid;

    public EngineInventoryRenderer(Texture inventoryBackground, List<MenuElement> elementList) {
        this.inventoryBackground = inventoryBackground;
        this.elementList = elementList;
    }

    @Override
    public void render(ItemStack[] itemStacks) {
        if (engineController == null) {
            throw new IllegalStateException("Engine Controller is not ready");
        }
        if (uuid == null) {
            throw new IllegalStateException("Inventory is already rendered");

        }
        uuid = engineController.render(itemStacks, inventoryBackground, elementList);
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    @Override
    public void closeInventory() {
        engineController.close(uuid);
        uuid = null;
    }

    public void setEngineController(EngineController engineController) {
        this.engineController = engineController;
    }
}
