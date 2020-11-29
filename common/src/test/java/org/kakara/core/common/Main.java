package org.kakara.core.common;

import org.kakara.core.common.test.ItemTest;

public class Main {
    public static void main(String[] args) {
        ItemTest itemTest = new ItemTest("ITEM ONE", "", "", new ControllerKey("TEST", "one_item"));
        ItemTest two = new ItemTest("ITEM TWO", "", "", new ControllerKey("TEST", "two_item"));
        ItemTest three = new ItemTest("ITEM THREE", "", "", new ControllerKey("TEST", "three_item"));
        ItemTest four = new ItemTest("ITEM FOUR", "", "", new ControllerKey("TEST", "four_item"));
        ItemTest five = new ItemTest("ITEM FIVE", "", "", new ControllerKey("TEST", "five_item"));
        //CALL ItemManager(Currently unavailable)
    }
}
