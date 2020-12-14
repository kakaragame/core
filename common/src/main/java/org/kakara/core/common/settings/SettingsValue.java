package org.kakara.core.common.settings;

import org.kakara.core.common.ControllerKey;

public class SettingsValue {
    private ControllerKey settingKey;
    private String value;

    public SettingsValue(ControllerKey settingKey, String value) {
        this.settingKey = settingKey;
        this.value = value;
    }

    public ControllerKey getSettingKey() {
        return settingKey;
    }

    public void setSettingKey(ControllerKey settingKey) {
        this.settingKey = settingKey;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
