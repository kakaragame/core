package org.kakara.core.common.exceptions;

public class WorldLoadException extends Exception {
    public WorldLoadException(String message) {
        super(message);
    }

    public WorldLoadException(String message, Throwable cause) {
        super(message, cause);
    }

    public WorldLoadException(Throwable cause) {
        super(cause);
    }

    public WorldLoadException() {
    }
}
