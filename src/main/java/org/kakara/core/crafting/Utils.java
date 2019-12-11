package org.kakara.core.crafting;

import org.kakara.core.game.Item;

import java.util.List;

public class Utils {
    public static boolean hasMatchingItem(List<Item> item, List<Item> item1) {
        for (Object o : item) {
            if (item1.contains(o)) return true;
        }
        return false;
    }
}
