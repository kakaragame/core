package org.kakara.core.gui;

import org.kakara.core.game.ItemStack;
import org.kakara.core.gui.menu.items.MenuElement;
import org.kakara.core.resources.Texture;

import java.util.List;

public interface EngineController {
    void render(ItemStack[] itemStacks, Texture inventoryBackground, List<MenuElement> elementList);
}
