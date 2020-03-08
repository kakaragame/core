package org.kakara.core;

public class Utils {
    private Utils() {

    }

    public static final String ITEM_PATTERN = "[a-zA-Z0-9_]*:[a-zA-Z0-9_]*";

    public static boolean isValidItemPattern(String s) {
        return s.matches(ITEM_PATTERN);
    }

}
