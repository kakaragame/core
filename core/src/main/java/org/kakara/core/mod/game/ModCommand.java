package org.kakara.core.mod.game;

import org.kakara.core.command.Command;
import org.kakara.core.command.CommandSender;
import org.kakara.core.command.TabCompleter;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public abstract class ModCommand implements Command, TabCompleter {
    private Set<String> aliases;
    private String description;

    public ModCommand(Set<String> aliases, String description) {
        this.aliases = aliases;
        this.description = description;
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
}
