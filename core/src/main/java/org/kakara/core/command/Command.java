package org.kakara.core.command;

import org.kakara.core.NameKey;

import java.util.Set;

public interface Command {
    NameKey command();

    Set<String> getAliases();

    String getDescription();

    void execute(String command, String[] arguments, String fullCommand, CommandSender executor);

}
