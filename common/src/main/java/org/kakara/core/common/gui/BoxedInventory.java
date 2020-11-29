package org.kakara.core.common.gui;

import org.kakara.core.common.gui.container.BoxedInventoryContainer;
import org.kakara.core.common.gui.container.InventoryContainer;

//This could be renamed
public interface BoxedInventory extends Inventory {

    BoxedInventoryContainer getContainer();

}
