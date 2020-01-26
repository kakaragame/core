package org.kakara.core.world.region;

import org.kakara.core.game.Item;

public class GenerationLayer {
    private double chance;
    private int highY;
    private int lowY;
    private Item[] items;

    public GenerationLayer(double chance, int highY, int lowY, Item... items) {
        this.chance = chance;
        this.highY = highY;
        this.lowY = lowY;
        this.items = items;
    }

    public double getChance() {
        return chance;
    }

    public int getHighY() {
        return highY;
    }

    public int getLowY() {
        return lowY;
    }

    public Item[] getItems() {
        return items;
    }
}
