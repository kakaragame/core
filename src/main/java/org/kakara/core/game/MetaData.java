package org.kakara.core.game;

import java.util.List;
import java.util.Map;

public interface MetaData {

    String getName();

    void setName(String name);

    void setLore(List<String> lore);

    List<String> getLore();

    Map<String, String> getItemData();

    void setItemData(String key, String value);
}
