package org.kakara.core.gui.menu.items;

import java.awt.*;

public class ItemStackElement implements MenuElement {
    private final Point position;

    public ItemStackElement(Point position) {
        this.position = position;
    }

    @Override
    public Point getPosition() {
        return position;
    }
}
