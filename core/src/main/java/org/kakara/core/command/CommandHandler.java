package org.kakara.core.command;

import java.util.List;

/**
 * This allows you to create custom commands for CommandSender execution.
 */
public interface CommandHandler {
    /**
     * Execute the command with the given arguments.
     * @param command the base command string. e.g. '/kick User', would have this be 'kick'
     * @param arguments the arguments after the command split by spaces.
     * @param fullCommand the full command string without the prefix.
     * @param executor the sender who executed the command.
     */
    void execute(String command, String[] arguments, String fullCommand, CommandSender executor);

    /**
     * Get possible auto-completion suggestions
     * @param command the base command string. e.g. '/kick User', would have this be 'kick'
     * @param arguments the arguments after the command split by spaces.
     * @param fullCommand the full command string without the prefix.
     * @param executor the sender who executed the command.
     * @return a list of possible auto-completion text with a given command.
     */
    List<String> getAutoCompletionSuggestions(String command, String[] arguments, String fullCommand, CommandSender executor);
}
