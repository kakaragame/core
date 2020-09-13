package org.kakara.core.gui.menu.items;

import com.google.gson.JsonObject;
import org.kakara.core.events.FunctionalEvent;
import org.kakara.core.gui.events.ItemGrabInventoryEvent;
import org.kakara.core.gui.events.ItemPlaceInventoryEvent;
import org.kakara.core.utils.ParsingUtils;

import java.awt.*;

public class ItemStackElement implements MenuElement {
    private final Point position;
    private final int slot;
    private FunctionalEvent<ItemGrabInventoryEvent> itemGrabEvent;
    private FunctionalEvent<ItemPlaceInventoryEvent> itemPlaceEvent;
    private final Point size;

    public ItemStackElement(Point position, int slot, Point size) {
        this.position = position;
        this.slot = slot;
        this.size = size;
    }

    public ItemStackElement(JsonObject jo) {
        position = ParsingUtils.parsePoint(jo.get("position").getAsString());
        size = ParsingUtils.parsePoint(jo.get("size").getAsString());
        slot = jo.get("slot").getAsInt();
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

    public int getSlot() {
        return slot;
    }

    public Point getSize() {
        return size;
    }
}
