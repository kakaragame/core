package org.kakara.core.gui.loaders;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.kakara.core.Utils;
import org.kakara.core.gui.menu.items.ItemStackElement;
import org.kakara.core.gui.menu.items.MenuElement;
import org.kakara.core.resources.Resource;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class InventoryLoader {
    public static Set<MenuElement> loadElements(Resource resource) {
        try {
            Set<MenuElement> elements = new HashSet<>();
            JsonObject jsonObject = Utils.getGson().fromJson(new FileReader(resource.getFile()), JsonObject.class);
            for (JsonElement slot : jsonObject.get("slots").getAsJsonArray()) {
                if (slot.getAsJsonObject().get("type").getAsString().equals("slot")) {
                    elements.add(new ItemStackElement(slot.getAsJsonObject()));
                }else if(slot.getAsJsonObject().get("type").getAsString().equals("title")){

                }
            }
            return elements;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return Collections.emptySet();
    }
}
