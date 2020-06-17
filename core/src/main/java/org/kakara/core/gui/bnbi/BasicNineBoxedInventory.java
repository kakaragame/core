package org.kakara.core.gui.bnbi;

import org.kakara.core.gui.AbstractBoxedInventory;

public class BasicNineBoxedInventory extends AbstractBoxedInventory {
    public BasicNineBoxedInventory(int capacity) {
        super(capacity);
    }

    @Override
    public int rowSize() {
        return 9;
    }
}
