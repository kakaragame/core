package org.kakara.core.gui.bnbi;

import org.kakara.core.Kakara;
import org.kakara.core.gui.AbstractBoxedInventory;
import org.kakara.core.gui.EngineInventoryRenderer;
import org.kakara.core.gui.Inventory;
import org.kakara.core.gui.InventoryRenderer;
import org.kakara.core.gui.annotations.BuilderClass;
import org.kakara.core.gui.menu.items.MenuElement;

import java.util.ArrayList;
import java.util.List;

@BuilderClass(BasicNineBoxedInventoryBuilder.class)
public class BasicNineBoxedInventory extends AbstractBoxedInventory {
    private static InventoryRenderer renderer;

    public static void setRenderer(InventoryRenderer renderer) {
        if (BasicNineBoxedInventory.renderer == null) {
            throw new IllegalStateException("InventoryRenderer already set");
        }
        BasicNineBoxedInventory.renderer = renderer;
    }

    public BasicNineBoxedInventory(int capacity) {
        super(capacity);
    }

    @Override
    public int rowSize() {
        return 9;
    }

    @Override
    public InventoryRenderer getRenderer() {
        return renderer;
    }
}
