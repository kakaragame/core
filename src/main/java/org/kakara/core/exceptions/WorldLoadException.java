package org.kakara.core.exceptions;

public class WorldLoadException extends Exception {
    public WorldLoadException(String worldName) {
        super("Unable to load " + worldName);
    }
}
