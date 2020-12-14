package org.kakara.core.common.settings;

import org.kakara.core.common.ControllerKey;

public class SettingsValue {
    private final Setting<?> settingKey;
    private String value;

    public SettingsValue(Setting<?> settingKey, String value) {
        this.settingKey = settingKey;
        this.value = value;
    }

    public Setting<?> getSettingKey() {
        return settingKey;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
