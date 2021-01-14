package org.kakara.core.common.exceptions;

import org.kakara.core.common.EnvType;

public class IncompatibleEnvironmentException extends RuntimeException {
    public IncompatibleEnvironmentException(EnvType envNeeded) {
        super("The current environment must be: " + envNeeded.name());
    }
}
