package org.kakara.core.common.settings;

import org.kakara.core.common.ControllerKey;

public interface SettingManager {

    SettingsValue getSettingValue(ControllerKey controllerKey);

    void setSettingValue(SettingsValue value);

    void registerNewSetting(Setting<?> setting);
}
