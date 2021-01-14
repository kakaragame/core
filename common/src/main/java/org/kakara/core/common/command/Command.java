package org.kakara.core.common.command;


import org.kakara.core.common.ControllerKey;

import java.util.Set;

public interface Command {
    ControllerKey command();

    Set<String> getAliases();

    String getDescription();

    void execute(String command, String[] arguments, String fullCommand, CommandSender executor);

}
