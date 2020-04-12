package org.kakara.core.crafting;

import org.kakara.core.game.ItemStack;

import java.util.List;
import java.util.Objects;

/**
 * This represents a crafting recipe in Kakara.
 */
public class CraftingRecipe {
    private List<CraftingItem> ingredients;
    private ItemStack result;
    private boolean shaped;

    /**
     * In shaped recipes, null represents an empty slot.
     * @param ingredients the ingredients needed to craft the item. Null represents no item.
     * @param result the result of the crafting recipe.
     * @param shaped does the recipe have a specific shape and order?
     */
    public CraftingRecipe(List<CraftingItem> ingredients, ItemStack result, boolean shaped) {
        this.ingredients = ingredients;
        this.result = result;
        this.shaped = shaped;

        if (!shaped && ingredients.contains(null)) throw new IllegalArgumentException("Shapeless recipes cannot contain null values.");
    }

    /**
     * @return the ingredients of the CraftingRecipe.
     */
    public List<CraftingItem> getIngredients() {
        return ingredients;
    }

    /**
     * @return the result of the CraftingRecipe.
     */
    public ItemStack getResult() {
        return result;
    }

    /**
     * Set the result of the crafting recipe.
     * @param result the result to replace the current one
     */
    public void setResult(ItemStack result) {
        this.result = result;
    }

    /**
     * Set the ingredients of the crafting recipe.
     * @param ingredients the list of ingredients to replace the current one
     */
    public void setIngredients(List<CraftingItem> ingredients) {
        if (!shaped && ingredients.contains(null))
            throw new IllegalArgumentException("Shapeless recipes cannot contain null values.");
        else {
            this.ingredients = ingredients;
        }
    }

    /**
     * @return does the recipe have a specific shape and order?
     */
    public boolean isShaped() {
        return shaped;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CraftingRecipe that = (CraftingRecipe) o;
        return Objects.equals(ingredients, that.ingredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredients, result);
    }
}
