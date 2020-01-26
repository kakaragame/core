package org.kakara.core.world.region;

import org.kakara.core.game.Item;

public class GenerationLayer {
    private double chance;
    private int height;
    private Item[] items;

    public GenerationLayer(double chance, int height, Item... items) {
        this.chance = chance;
        this.height = height;
        this.items = items;
    }

    public double getChance() {
        return chance;
    }

    public int getHeight() {
        return height;
    }

    public Item[] getItems() {
        return items;
    }
}
