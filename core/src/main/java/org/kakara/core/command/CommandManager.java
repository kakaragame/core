package org.kakara.core.command;

public interface CommandManager {

    void executeCommand(String command, CommandSender sender);

    void registerCommand(Command command);

    void registerTabCompleter(TabCompleter completer);
}
