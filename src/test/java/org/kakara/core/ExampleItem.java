package org.kakara.core;

import org.kakara.core.annotations.Id;
import org.kakara.core.annotations.Name;
import org.kakara.core.annotations.Texture;
import org.kakara.core.crafting.CraftingRecipe;
import org.kakara.core.events.player.ClickEvent;
import org.kakara.core.game.Craftable;
import org.kakara.core.mod.game.ModItem;

import java.util.List;

@Id("wooden_stick")
@Name("Stick")
@Texture("items/stick")
public class ExampleItem extends ModItem implements Craftable {


    @Override
    public float getWeight() {
        return 0;
    }

    @Override
    public void onClick(ClickEvent clickEvent) {
    }

    @Override
    public List<CraftingRecipe> createCraftingRecipe() {
        return null;
    }
}
