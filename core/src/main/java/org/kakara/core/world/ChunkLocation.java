package org.kakara.core.world;

import java.util.Objects;

public class ChunkLocation {
    private int x;
    private int y;
    private int z;
    private World world;

    public ChunkLocation(int x, int y, int z, World world) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.world = world;
    }

    public ChunkLocation(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public ChunkLocation(Location location) {
        this.x = (int) location.getX();
        this.y = (int) location.getY();
        this.z = (int) location.getY();
        this.world = location.getWorld();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    @Override
    public String toString() {
        String worldName = world == null ? "null" : world.getName();
        return "ChunkLocation{" +
                "world=" + worldName +
                ", x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChunkLocation location = (ChunkLocation) o;
        return Double.compare(location.x, x) == 0 &&
                Double.compare(location.y, y) == 0 &&
                Double.compare(location.z, z) == 0 &&
                Objects.equals(world, location.world);
    }

    @Override
    public int hashCode() {
        return Objects.hash(world, x, y, z);
    }
}
