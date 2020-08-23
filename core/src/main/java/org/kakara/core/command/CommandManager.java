package org.kakara.core.command;

import org.jetbrains.annotations.NotNull;
import org.kakara.core.mod.LoadStage;
import org.kakara.core.mod.annotations.LoadingStage;

import java.util.Set;

public interface CommandManager extends LoadStage {
    /**
     * Executes a command.
     * <b>Do not include command prefix</b>
     *
     * @param command command message
     * @param sender  the sender of command.
     */
    void executeCommand(@NotNull String command, @NotNull CommandSender sender);

    /**
     * Registers a new command to the system
     *
     * @param command the command object
     */
    void registerCommand(@NotNull Command command);

    /**
     * Registers a new TabCompleter to the system
     *
     * @param completer the completer
     */
    void registerAutoCompleter(@NotNull TabCompleter completer);

    /**
     * A set of Registered tab Completers
     *
     * @return a set of registered tab Completers
     */
    Set<TabCompleter> getRegisterTabCompleters();

    /**
     * A set of Registered commands
     *
     * @return a set of registered commands
     */
    Set<Command> getRegisteredCommands();
}
