package org.kakara.core.common.game.service;


import org.kakara.core.common.ControllerKey;

public abstract class ChatService extends ModService {

    public ChatService(ControllerKey implementationNameKey) {
        super(implementationNameKey, new ControllerKey("kakara", "chat"));
    }

    // abstract void formatMessage(CommandSender sender, String message);


}
