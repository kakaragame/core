package org.kakara.core.world.region;

import org.kakara.core.game.ItemStack;

public class GenerationLayer {
    private double chance;
    private int height;
    private ItemStack[] itemStacks;

    public GenerationLayer(double chance, int height, ItemStack... itemStacks) {
        this.chance = chance;
        this.height = height;
        this.itemStacks = itemStacks;
    }

    public double getChance() {
        return chance;
    }

    public int getHeight() {
        return height;
    }

    public ItemStack[] getItemStacks() {
        return itemStacks;
    }
}
