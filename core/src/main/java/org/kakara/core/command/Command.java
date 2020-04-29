package org.kakara.core.command;

import java.util.Set;

public interface Command {
    Set<String> getAliases();

    String getDescription();

    void execute(String command, String[] arguments, String fullCommand, CommandSender executor);

}
