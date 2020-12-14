package org.kakara.core.common.settings;

import org.kakara.core.common.Identifiable;

public interface Setting<T> extends Identifiable {
    String getDescription();


    T parseValue(SettingsValue value);
}
