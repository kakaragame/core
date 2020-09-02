package org.kakara.core.events;

import org.kakara.core.GameInstance;
import org.kakara.core.mod.LoadStage;
import org.kakara.core.mod.Mod;

/**
 * This is used to manage events on a GameInstance.
 */
public interface EventManager extends LoadStage {
    /**
     * Registers an EventHandler.
     *
     * @param handler The object containing the event listeners.
     * @param mod     The mod of the EventHandler.
     */
    void registerEventHandler(Object handler, Mod mod);

    /**
     * Calls EventHandlers which are instances of the inputted event.
     *
     * @param event the event to call the handlers.
     */
    void callEvent(Event event);

    /**
     * Loads the EventManager.
     *
     * @param GameInstance the GameInstance to load to.
     */
    void load(GameInstance GameInstance);
}
