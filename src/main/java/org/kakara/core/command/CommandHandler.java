package org.kakara.core.command;

import java.util.List;

public interface CommandHandler {
    boolean execute(String command, String[] arguments, String fullCommand, CommandSender executor);

    List<String> getTabSuggestions(String command, String[] arguments, String fullCommand, CommandSender executor);
}
