package org.kakara.core.common;

import org.kakara.core.common.exceptions.IncompatibleEnvironmentException;

public class KValidate {
    public static boolean isEnvironmentServer() {
        return (Kakara.getEnvironmentInstance().getType() == EnvType.SERVER);
    }

    public static void environmentCheckServer() throws IncompatibleEnvironmentException {
        if (!isEnvironmentServer())
            throw new IncompatibleEnvironmentException(EnvType.SERVER);
    }

    public static boolean isEnvironmentClient() {
        return (Kakara.getEnvironmentInstance().getType() == EnvType.CLIENT);
    }

    public static void environmentCheckClient() throws IncompatibleEnvironmentException {
        if (!isEnvironmentClient())
            throw new IncompatibleEnvironmentException(EnvType.CLIENT);
    }

    public static boolean isGameInstanceServer() {
        return (Kakara.getEnvironmentInstance().getType() == EnvType.SERVER);
    }

    public static void gameInstanceCheckServer() throws IncompatibleEnvironmentException {
        if (!isGameInstanceServer())
            throw new IncompatibleEnvironmentException(EnvType.SERVER);
    }

    public static boolean isGameInstanceClient() {
        return (Kakara.getEnvironmentInstance().getType() == EnvType.CLIENT);
    }

    public static void gameInstanceCheckClient() throws IncompatibleEnvironmentException {
        if (!isGameInstanceClient())
            throw new IncompatibleEnvironmentException(EnvType.CLIENT);
    }
}
