package org.kakara.core.common.gui;

public class InventoryProperties {
    private int scale;

    public InventoryProperties(int scale) {
        this.scale = scale;
    }

    public InventoryProperties() {
        this.scale = 1;
    }

    /**
     * Get the scale of the inventory.
     *
     * @return The scale of the inventory.
     */
    public int getScale() {
        return scale;
    }

    /**
     * Set the scale of the inventory.
     * <p>The default is 1.</p>
     *
     * @param scale The scale.
     */
    public void setScale(int scale) {
        this.scale = scale;
    }
}
