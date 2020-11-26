package org.kakara.core.game.gui.bnbi;

import org.kakara.core.game.gui.AbstractBoxedInventory;
import org.kakara.core.game.gui.annotations.BuilderClass;

@BuilderClass(BasicNineBoxedInventoryBuilder.class)
public abstract class BasicNineBoxedInventory extends AbstractBoxedInventory {


    public BasicNineBoxedInventory(int capacity) {
        super(capacity);
    }

    @Override
    public int rowSize() {
        return 9;
    }

}
