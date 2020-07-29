package org.kakara.core.gui.bnbi;

import org.kakara.core.gui.InventoryBuilder;

public class BasicNineBoxedInventoryBuilder implements InventoryBuilder<BasicNineBoxedInventory> {
    private int capacity;

    public BasicNineBoxedInventoryBuilder setCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    @Override
    public BasicNineBoxedInventory build() {
        return new BasicNineBoxedInventory(capacity);
    }
}
