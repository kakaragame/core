package org.kakara.core.common;

import org.kakara.core.common.exceptions.IncompatibleEnvironmentException;

public class KValidate {
    public static boolean isServer() {
        return (Kakara.getEnvironmentInstance().getType() == EnvType.SERVER);
    }

    public static void checkServer() throws IncompatibleEnvironmentException {
        if (isServer())
            throw new IncompatibleEnvironmentException(EnvType.SERVER);
    }
}
