package org.kakara.core.exceptions;

public class MissingItemException extends Throwable {
    private String item;

    public MissingItemException(String type) {
        super("Unable to find " + type);
        this.item = type;

    }
}
