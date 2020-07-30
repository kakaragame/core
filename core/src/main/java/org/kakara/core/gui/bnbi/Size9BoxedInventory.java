package org.kakara.core.gui.bnbi;

import org.kakara.core.gui.InventoryRenderer;
import org.kakara.core.gui.annotations.BuilderClass;

@BuilderClass(BasicNineBoxedInventoryBuilder.class)
public class Size9BoxedInventory extends BasicNineBoxedInventory {

    private static InventoryRenderer renderer;

    public Size9BoxedInventory() {
        super(9);
    }

    public static void setRenderer(InventoryRenderer renderer) {
        if (Size9BoxedInventory.renderer == null) {
            throw new IllegalStateException("InventoryRenderer already set");
        }
        Size9BoxedInventory.renderer = renderer;
    }


    @Override
    public InventoryRenderer getRenderer() {
        return renderer;
    }
}
