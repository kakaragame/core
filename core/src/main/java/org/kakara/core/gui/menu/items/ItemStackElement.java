package org.kakara.core.gui.menu.items;

import org.kakara.core.events.FunctionalEvent;
import org.kakara.core.gui.events.ItemGrabInventoryEvent;
import org.kakara.core.gui.events.ItemPlaceInventoryEvent;

import java.awt.*;

public class ItemStackElement implements MenuElement {
    private final Point position;
    private FunctionalEvent<ItemGrabInventoryEvent> itemGrabEvent;
    private FunctionalEvent<ItemPlaceInventoryEvent> itemPlaceEvent;

    public ItemStackElement(Point position) {
        this.position = position;
    }

    public FunctionalEvent<ItemGrabInventoryEvent> getItemGrabEvent() {
        return itemGrabEvent;
    }

    public void setItemGrabEvent(FunctionalEvent<ItemGrabInventoryEvent> itemGrabEvent) {
        this.itemGrabEvent = itemGrabEvent;
    }

    public FunctionalEvent<ItemPlaceInventoryEvent> getItemPlaceEvent() {
        return itemPlaceEvent;
    }

    public void setItemPlaceEvent(FunctionalEvent<ItemPlaceInventoryEvent> itemPlaceEvent) {
        this.itemPlaceEvent = itemPlaceEvent;
    }

    @Override
    public Point getPosition() {
        return position;
    }
}
