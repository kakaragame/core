package org.kakara.core;

import com.google.gson.Gson;

public class Utils {
    public static final Gson GSON = new Gson();

    private Utils() {

    }

    public static final String ITEM_PATTERN = "[a-zA-Z0-9_]*:[a-zA-Z0-9_]*";

    public static boolean isValidItemPattern(String s) {
        return s.matches(ITEM_PATTERN);
    }

}
