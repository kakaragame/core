package org.kakara.core.gui.bnbi;


import org.kakara.core.gui.InventoryRenderer;
import org.kakara.core.gui.annotations.BuilderClass;

@BuilderClass(BasicNineBoxedInventoryBuilder.class)
public class Size27BoxedInventory extends BasicNineBoxedInventory {

    private static InventoryRenderer renderer;

    public Size27BoxedInventory() {
        super(27);
    }

    public static void setRenderer(InventoryRenderer renderer) {
        if (Size27BoxedInventory.renderer == null) {
            throw new IllegalStateException("InventoryRenderer already set");
        }
        Size27BoxedInventory.renderer = renderer;
    }


    @Override
    public InventoryRenderer getRenderer() {
        return renderer;
    }
}
