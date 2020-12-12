package org.kakara.core.common.mod.environment;

import org.kakara.core.common.mod.AbstractMod;
import org.kakara.core.common.mod.AbstractModLoader;

public class EnvironmentModLoader extends AbstractModLoader {

    @Override
    protected Class<?> requiredClass() {
        return EnvironmentMod.class;
    }

    @Override
    protected void postSetup(AbstractMod abstractMod) {
//TODO implement this method
    }
}
