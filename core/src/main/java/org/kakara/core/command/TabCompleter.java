package org.kakara.core.command;

import java.util.List;
import java.util.Set;

public interface TabCompleter {
    Set<String> getAliases();

    String getDescription();

    List<String> getAutoCompletionSuggestions(String command, String[] arguments, String fullCommand, CommandSender executor);
}
