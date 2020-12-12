package org.kakara.core.common.mod.environment;

import org.kakara.core.common.EnvironmentInstance;
import org.kakara.core.common.Kakara;
import org.kakara.core.common.mod.AbstractMod;

public class EnvironmentMod extends AbstractMod {
    public EnvironmentInstance getEnvironment() {
        return Kakara.getEnvironmentInstance();
    }
}
