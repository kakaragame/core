package org.kakara.core.exceptions;

import java.io.FileNotFoundException;

public class SaveLoadException extends Exception {
    public SaveLoadException(String worldName) {
        super("Unable to load " + worldName);
    }

    public SaveLoadException(String message, Throwable cause) {
        super(message, cause);
    }

    public SaveLoadException(Throwable throwable) {
        super(throwable);
    }

    public SaveLoadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public SaveLoadException() {
    }
}
