package org.kakara.core;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.kakara.core.serializers.gson.LocationSerializer;
import org.kakara.core.serializers.gson.WorldSerializer;
import org.kakara.core.world.Location;
import org.kakara.core.world.World;

public class Utils {
    private static Gson gson;

    static {
        gson = new GsonBuilder().registerTypeAdapter(Location.class, new LocationSerializer()).registerTypeAdapter(World.class, new WorldSerializer()).create();
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
