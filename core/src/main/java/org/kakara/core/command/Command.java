package org.kakara.core.command;

import org.kakara.core.ControllerKey;

import java.util.Set;

public interface Command {
    ControllerKey command();

    Set<String> getAliases();

    String getDescription();

    void execute(String command, String[] arguments, String fullCommand, CommandSender executor);

}
