package org.kakara.core.gui.menu.items;

import org.kakara.core.events.FunctionalEvent;
import org.kakara.core.gui.events.ItemGrabEvent;
import org.kakara.core.gui.events.ItemPlaceEvent;

import java.awt.*;

public class ItemStackElement implements MenuElement {
    private final Point position;
    private FunctionalEvent<ItemGrabEvent> itemGrabEvent;
    private FunctionalEvent<ItemPlaceEvent> itemPlaceEvent;

    public ItemStackElement(Point position) {
        this.position = position;
    }

    public FunctionalEvent<ItemGrabEvent> getItemGrabEvent() {
        return itemGrabEvent;
    }

    public void setItemGrabEvent(FunctionalEvent<ItemGrabEvent> itemGrabEvent) {
        this.itemGrabEvent = itemGrabEvent;
    }

    public FunctionalEvent<ItemPlaceEvent> getItemPlaceEvent() {
        return itemPlaceEvent;
    }

    public void setItemPlaceEvent(FunctionalEvent<ItemPlaceEvent> itemPlaceEvent) {
        this.itemPlaceEvent = itemPlaceEvent;
    }

    @Override
    public Point getPosition() {
        return position;
    }
}
