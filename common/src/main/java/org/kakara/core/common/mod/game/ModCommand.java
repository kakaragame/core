package org.kakara.core.common.mod.game;


import org.kakara.core.common.ControllerKey;
import org.kakara.core.common.command.Command;
import org.kakara.core.common.command.CommandSender;
import org.kakara.core.common.command.TabCompleter;
import org.kakara.core.common.mod.Mod;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public abstract class ModCommand implements Command, TabCompleter {
    private final Set<String> aliases;
    private final String description;
    private GameMod mod;
    private final ControllerKey nameKey;

    public ModCommand(Set<String> aliases, String description, GameMod mod, String command) {
        this.aliases = aliases;
        this.description = description;
        nameKey = new ControllerKey(mod, command);
    }

    @Override
    public List<String> getAutoCompletionSuggestions(String command, String[] arguments, String fullCommand, CommandSender executor) {
        //TODO auto send list of online players
        return Collections.emptyList();
    }

    @Override
    public Set<String> getAliases() {
        return aliases;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public ControllerKey command() {
        return nameKey;
    }
}
