package org.kakara.core.common.exceptions;

public class ModLoadException extends Exception {
    public ModLoadException() {
    }

    public ModLoadException(String message) {
        super(message);
    }

    public ModLoadException(String message, Throwable cause) {
        super(message, cause);
    }

    public ModLoadException(Throwable cause) {
        super(cause);
    }

    public ModLoadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
