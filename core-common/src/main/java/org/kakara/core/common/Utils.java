package org.kakara.core.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.kakara.core.common.serializers.gson.GsonSerializerRegistar;

public class Utils {
    public static final String ITEM_PATTERN = "[a-zA-Z0-9_]*:[a-zA-Z0-9_]*";
    private static final Gson gson;

    static {
        GsonBuilder js = new GsonBuilder();
        GsonSerializerRegistar.registerSerializers(js);
        gson = js.create();

    }

    private Utils() {

    }

    public static boolean isValidItemPattern(String s) {
        return s.matches(ITEM_PATTERN);
    }

    public static Gson getGson() {
        return gson;
    }
}
