package org.kakara.core.common.exceptions;

public class MissingItemException extends Throwable {
    private final String item;

    public MissingItemException(String type) {
        super("Unable to find " + type);
        this.item = type;

    }
}
