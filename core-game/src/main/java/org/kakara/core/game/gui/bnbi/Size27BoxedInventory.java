package org.kakara.core.game.gui.bnbi;


import org.kakara.core.game.gui.InventoryRenderer;
import org.kakara.core.game.gui.annotations.BuilderClass;

@BuilderClass(BasicNineBoxedInventoryBuilder.class)
public class Size27BoxedInventory extends BasicNineBoxedInventory {

    private static InventoryRenderer renderer;

    public Size27BoxedInventory() {
        super(27);
    }

    @Override
    public void redraw() {
        renderer.redraw(this);
    }

    @Override
    public InventoryRenderer getRenderer() {
        return renderer;
    }

    public static void setRenderer(InventoryRenderer renderer) {
        if (Size27BoxedInventory.renderer != null) {
            throw new IllegalStateException("InventoryRenderer already set");
        }
        Size27BoxedInventory.renderer = renderer;
    }
}
