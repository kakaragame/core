package org.kakara.core.mod;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.kakara.core.exceptions.IllegalModException;

public class JsonModRules implements ModRules {
    private final String name;
    private final String version;
    private final String description;
    private final String mainClass;
    private final String[] softDepends;
    private final String[] depends;
    private final String[] authors;
    private final ModType modType;

    public JsonModRules(JsonObject jsonObject) {
        name = jsonObject.get("name").getAsString();
        version = jsonObject.get("version").getAsString();
        description = tryToGet(jsonObject, "description", "");
        mainClass = jsonObject.get("main-class").getAsString();
        modType = ModType.valueOf(tryToGet(jsonObject, "mod-type", "REGULAR"));
        softDepends = getOrDefaultArray(jsonObject, "soft-depends", new String[0]);
        authors = getOrDefaultArray(jsonObject, "authors", new String[0]);
        depends = getOrDefaultArray(jsonObject, "depends", new String[0]);
    }

    public static void validate(JsonObject jsonObject) throws IllegalModException {
        if (!jsonObject.has("name")) throw new IllegalModException("Unable to find mod name");
        if (!jsonObject.has("version")) throw new IllegalModException("Unable to find mod version");
        if (!jsonObject.has("main-class")) throw new IllegalModException("Unable to find mod main-class");
    }

    public static String tryToGet(JsonObject jsonObj, String key, String defaultValue) {
        if (jsonObj.has(key))
            return jsonObj.get(key).getAsString();
        return defaultValue;
    }

    public static String[] getOrDefaultArray(JsonObject jsonObj, String key, String[] defaultValue) {
        if (jsonObj.has(key))
            return jsonArrayToStringArray(jsonObj.get(key).getAsJsonArray());
        return defaultValue;
    }

    private static String[] jsonArrayToStringArray(JsonArray asJsonArray) {
        if (asJsonArray == null) return null;
        String[] strings = new String[asJsonArray.size()];
        for (int i = 0; i <= asJsonArray.size(); i++) {
            strings[i] = asJsonArray.get(i).getAsString();
        }
        return strings;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public String[] getAuthors() {
        return authors;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public ModType getModType() {
        return modType;
    }

    @Override
    public String getMainClass() {
        return mainClass;
    }

    @Override
    public String[] getSoftDepends() {
        return softDepends;
    }

    @Override
    public String[] getDepends() {
        return depends;
    }
}
