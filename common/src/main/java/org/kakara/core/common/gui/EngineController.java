package org.kakara.core.common.gui;


import org.kakara.core.common.gui.menu.items.MenuElement;
import org.kakara.core.common.resources.Texture;

import java.util.Set;

/**
 * The EngineController for handling GUIs
 */
public interface EngineController {
    void render(Inventory inventory, Texture inventoryBackground, Set<MenuElement> elementList, InventoryProperties properties);

    void redraw(Inventory inventory, Texture inventoryBackground, Set<MenuElement> elementList, InventoryProperties properties);

    void close();
}

