package org.kakara.core;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.kakara.core.serializers.gson.GsonSerializerRegistar;

public class Utils {
    private static Gson gson;

    static {
        GsonBuilder js = new GsonBuilder();
        GsonSerializerRegistar.registerSerializers(js);
        gson = js.create();

    }

    private Utils() {

    }

    public static final String ITEM_PATTERN = "[a-zA-Z0-9_]*:[a-zA-Z0-9_]*";

    public static boolean isValidItemPattern(String s) {
        return s.matches(ITEM_PATTERN);
    }

    public static Gson getGson() {
        return gson;
    }
}
