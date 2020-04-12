package org.kakara.core.mod;

import java.util.HashMap;
import java.util.Map;

public class ModSetting {
    private Map<String, Object> settings = new HashMap<>();

    public void setSetting(String key, Object value) {
        settings.put(key, value);
    }

    public Object getSetting(String key) {
        return settings.get(key);
    }
}
