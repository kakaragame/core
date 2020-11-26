package org.kakara.core.game.game;

import org.kakara.core.crafting.CraftingRecipe;

import java.util.List;

public interface Craftable {
    List<CraftingRecipe> createCraftingRecipe();
}
