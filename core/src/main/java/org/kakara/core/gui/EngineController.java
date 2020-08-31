package org.kakara.core.gui;

import org.kakara.core.gui.menu.items.MenuElement;
import org.kakara.core.resources.Texture;

import java.util.List;

public interface EngineController {
    void render(Inventory inventory, Texture inventoryBackground, List<MenuElement> elementList);

    void redraw(Inventory inventory, Texture inventoryBackground, List<MenuElement> elementList);

    void close();
}

