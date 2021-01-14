package org.kakara.core.common.command;


import org.kakara.core.common.ControllerKey;

import java.util.List;
import java.util.Set;

public interface TabCompleter {
    ControllerKey command();

    Set<String> getAliases();

    String getDescription();

    List<String> getAutoCompletionSuggestions(String command, String[] arguments, String fullCommand, CommandSender executor);
}
