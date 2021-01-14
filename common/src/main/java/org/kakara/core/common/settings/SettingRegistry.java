package org.kakara.core.common.settings;

import org.kakara.core.common.ControllerKey;

public interface SettingRegistry {

    SettingsValue getSettingValue(ControllerKey controllerKey);

    void setSettingValue(SettingsValue value);

    void registerNewSetting(Setting<?> setting);
}
