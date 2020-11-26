package org.kakara.core.game.gui.bnbi;

import org.kakara.core.game.gui.InventoryBuilder;

public class BasicNineBoxedInventoryBuilder implements InventoryBuilder<BasicNineBoxedInventory> {
    private int capacity;

    public BasicNineBoxedInventoryBuilder setCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    @Override
    public BasicNineBoxedInventory build() {
        switch (capacity) {
            case 9:
                return new Size9BoxedInventory();
            case 27:
                return new Size27BoxedInventory();
            //TODO add more sizes
        }

        throw new IllegalArgumentException("Capacity cannot be " + capacity);
    }
}
