package org.kakara.core.client.parsers;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.stream.JsonWriter;
import org.kakara.core.Utils;
import org.kakara.core.client.SaveSettings;
import org.kakara.core.client.SaveSettingsBuilder;
import org.kakara.core.client.SaveSettingsParser;
import org.kakara.core.exceptions.SaveLoadException;
import org.kakara.core.modinstance.ModInstance;
import org.kakara.core.utils.CoreFileUtils;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class JsonSaveSettingParser implements SaveSettingsParser {
    @Override
    public SaveSettings fromFile(File file) throws SaveLoadException {
        if (!file.exists()) throw new SaveLoadException(new FileNotFoundException("Bad Mono"));
        try {
            JsonObject jsonObject = Utils.getGson().fromJson(new FileReader(file), JsonObject.class);
            JsonArray mods = jsonObject.get("mods").getAsJsonArray();
            Set<ModInstance> instanceSet = new HashSet<>();
            for (JsonElement mod : mods) {
                instanceSet.add(Utils.getGson().fromJson(mod, ModInstance.class));
            }

            Set<String> worlds = new HashSet<>();
            for (JsonElement element : jsonObject.get("worlds").getAsJsonArray()) {
                worlds.add(element.getAsString());
            }
            SaveSettingsBuilder builder = new SaveSettingsBuilder();
            builder.setDefaultWorld(UUID.fromString(jsonObject.get("default-world").getAsString()));
            builder.setModInstances(instanceSet);
            builder.setWorlds(worlds);
            builder.setName(jsonObject.get("name").getAsString());
            return builder.createSaveSettings();
        } catch (FileNotFoundException | JsonParseException e) {
            throw new SaveLoadException(e);
        }
    }

    @Override
    public void toFile(File file, SaveSettings saveSettings) throws SaveLoadException {
        if (file.exists()) {
            try {
                CoreFileUtils.backupAndDelete(file);
            } catch (IOException e) {
                throw new SaveLoadException("Unable to backup old file", e);
            }
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("default-world", saveSettings.getDefaultWorld().toString());
        jsonObject.addProperty("name", saveSettings.getName());
        jsonObject.add("worlds", Utils.getGson().toJsonTree(saveSettings.getWorlds()));
        jsonObject.add("mods", Utils.getGson().toJsonTree(saveSettings.getModInstances()));
        try {
            Utils.getGson().toJson(jsonObject, new FileWriter(file));
        } catch (IOException e) {
            throw new SaveLoadException(e);
        }
    }
}
