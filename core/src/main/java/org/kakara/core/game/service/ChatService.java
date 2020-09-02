package org.kakara.core.game.service;

import org.kakara.core.NameKey;
import org.kakara.core.command.CommandSender;

public abstract class ChatService extends ModService {

    public ChatService(NameKey implementationNameKey) {
        super(implementationNameKey, new NameKey("kakara", "chat"));
    }

    abstract void formatMessage(CommandSender sender, String message);


}
