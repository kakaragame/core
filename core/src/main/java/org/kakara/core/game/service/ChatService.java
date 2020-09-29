package org.kakara.core.game.service;

import org.kakara.core.ControllerKey;
import org.kakara.core.command.CommandSender;

public abstract class ChatService extends ModService {

    public ChatService(ControllerKey implementationNameKey) {
        super(implementationNameKey, new ControllerKey("kakara", "chat"));
    }

    abstract void formatMessage(CommandSender sender, String message);


}
