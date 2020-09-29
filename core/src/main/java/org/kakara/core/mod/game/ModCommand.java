package org.kakara.core.mod.game;

import org.kakara.core.ControllerKey;
import org.kakara.core.command.Command;
import org.kakara.core.command.CommandSender;
import org.kakara.core.command.TabCompleter;
import org.kakara.core.mod.Mod;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public abstract class ModCommand implements Command, TabCompleter {
    private final Set<String> aliases;
    private final String description;
    private Mod mod;
    private final ControllerKey nameKey;

    public ModCommand(Set<String> aliases, String description, Mod mod, String command) {
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
