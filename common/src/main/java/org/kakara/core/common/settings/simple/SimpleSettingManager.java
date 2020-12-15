package org.kakara.core.common.settings.simple;

import org.apache.commons.lang3.Validate;
import org.kakara.core.common.ControllerKey;
import org.kakara.core.common.Kakara;
import org.kakara.core.common.mod.ModRules.ModTarget;
import org.kakara.core.common.service.ServiceManager;
import org.kakara.core.common.settings.Setting;
import org.kakara.core.common.settings.SettingControllerService;
import org.kakara.core.common.settings.SettingManager;
import org.kakara.core.common.settings.SettingsValue;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class SimpleSettingManager implements SettingManager {
    private final Map<ControllerKey, Setting<?>> settings = new HashMap<>();
    private SettingControllerService settingControllerService;
    private final File folder;

    public SimpleSettingManager(File folder) {
        this.folder = folder;

    }

    @Override
    public SettingsValue getSettingValue(ControllerKey controllerKey) {
        Validate.notNull(settingControllerService);
        return settingControllerService.getSetting(getSetting(controllerKey), folder);
    }

    private Setting<?> getSetting(ControllerKey controllerKey) {
        return settings.get(controllerKey);
    }

    @Override
    public void setSettingValue(SettingsValue value) {
        Validate.notNull(settingControllerService);
        settingControllerService.writeSetting(value, folder);
    }

    public void init(ModTarget modTarget) {
        ServiceManager serviceManager;
        if (modTarget == ModTarget.ENVIRONMENT) {
            serviceManager = Kakara.getEnvironmentInstance().getServiceManager();
        } else {
            serviceManager = Kakara.getGameInstance().getServiceManager();
        }
        serviceManager.executeOnceServiceIsFound(service -> settingControllerService = (SettingControllerService) service, SettingControllerService.SERVICE_KEY);
    }

    @Override
    public void registerNewSetting(Setting<?> setting) {
        settings.put(setting.getControllerKey(), setting);
    }
}
