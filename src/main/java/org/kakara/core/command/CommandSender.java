package org.kakara.core.command;

/**
 * This represents an entity who has sent a command.
 */
public interface CommandSender {
    /**
     * Sends a message to the command sender
     * @param message the message to be sent
     */
    void sendMessage(String message);
}
