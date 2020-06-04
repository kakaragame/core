package org.kakara.core.events.entity;

import org.kakara.core.events.Cancellable;
import org.kakara.core.events.HandlerList;
import org.kakara.core.world.GameEntity;
import org.kakara.core.world.Location;

public class EntityTeleportEvent extends EntityEvent implements Cancellable {
    private Location oldLocation;
    private Location newLocation;
    private static HandlerList handlerList = new HandlerList(EntityTeleportEvent.class);

    /**
     * @param gameEntity  the GameEntity used by the event.
     * @param oldLocation
     * @param newLocation
     */
    public EntityTeleportEvent(GameEntity gameEntity, Location oldLocation, Location newLocation) {
        super(gameEntity);
        this.oldLocation = oldLocation;
        this.newLocation = newLocation;
    }

    public Location getOldLocation() {
        return oldLocation;
    }

    public Location getNewLocation() {
        return newLocation;
    }

    public void setNewLocation(Location newLocation) {
        this.newLocation = newLocation;
    }

    @Override
    public HandlerList getHandlerList() {
        return handlerList;
    }

    public static HandlerList getHandlers() {
        return handlerList;
    }
}
