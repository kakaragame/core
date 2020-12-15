package org.kakara.core.common.settings;

import org.kakara.core.common.ControllerKey;
import org.kakara.core.common.Kakara;
import org.kakara.core.common.service.Service;

import java.io.File;

public abstract class SettingControllerService implements Service {
    public static final ControllerKey SERVICE_KEY = Kakara.getEnvironmentInstance().createSystemKey("SETTINGS_CONTROLLER");


    public abstract void writeSetting(SettingsValue value, File folder);

    public abstract SettingsValue getSetting(Setting<?> setting, File folder);


    //Overide Methods
    @Override
    public String getName() {
        return "Settings Controller";
    }

    @Override
    public int getId() {
        return SERVICE_KEY.hashCode();
    }

    @Override
    public ControllerKey getControllerKey() {
        return SERVICE_KEY;
    }

    @Override
    public String getKey() {
        return SERVICE_KEY.getKey();
    }


    @Override
    public Class<? extends Service> getServiceClass() {
        return SettingControllerService.class;
    }
}
