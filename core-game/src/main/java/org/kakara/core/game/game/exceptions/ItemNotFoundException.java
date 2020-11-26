package org.kakara.core.game.game.exceptions;

import org.kakara.core.game.game.ItemManager;

/**
 * Thrown whenever an Item is not found
 *
 * @see ItemManager For Infomation about pulling items
 */
public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException() {
    }

    public ItemNotFoundException(String message) {
        super(message);
    }

    public ItemNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ItemNotFoundException(Throwable cause) {
        super(cause);
    }

    public ItemNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public static ItemNotFoundException create(String item) {
        return new ItemNotFoundException(String.format("Unable to locate Item: %s", item));
    }
}
