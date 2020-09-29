package org.kakara.core.command;

import org.kakara.core.ControllerKey;

import java.util.List;
import java.util.Set;

public interface TabCompleter {
    ControllerKey command();

    Set<String> getAliases();

    String getDescription();

    List<String> getAutoCompletionSuggestions(String command, String[] arguments, String fullCommand, CommandSender executor);
}
