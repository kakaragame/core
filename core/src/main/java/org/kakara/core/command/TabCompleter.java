package org.kakara.core.command;

import org.kakara.core.NameKey;

import java.util.List;
import java.util.Set;

public interface TabCompleter {
    NameKey command();

    Set<String> getAliases();

    String getDescription();

    List<String> getAutoCompletionSuggestions(String command, String[] arguments, String fullCommand, CommandSender executor);
}
