package org.kakara.core.common.game.entity;


import org.kakara.core.common.world.Location;

public final class PathFindingGoal {
    private Location startingLocation;
    private Location endingLocation;

    public PathFindingGoal(Location startingLocation, Location endingLocation) {
        this.startingLocation = startingLocation;
        this.endingLocation = endingLocation;
    }

    public Location getStartingLocation() {
        return startingLocation;
    }

    public void setStartingLocation(Location startingLocation) {
        this.startingLocation = startingLocation;
    }

    public Location getEndingLocation() {
        return endingLocation;
    }

    public void setEndingLocation(Location endingLocation) {
        this.endingLocation = endingLocation;
    }
}