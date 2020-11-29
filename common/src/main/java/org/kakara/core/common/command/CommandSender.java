package org.kakara.core.common.command;

import org.jetbrains.annotations.NotNull;

/**
 * This represents an entity who has sent a command.
 */
public interface CommandSender {
    /**
     * Sends a message to the command sender
     *
     * @param message the message to be sent
     */
    void sendMessage(@NotNull String message);
}
