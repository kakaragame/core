package org.kakara.core.exceptions;

public class SaveLoadException extends Exception {
    public SaveLoadException(String worldName) {
        super("Unable to load " + worldName);
    }
}
