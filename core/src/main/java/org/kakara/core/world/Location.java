package org.kakara.core.world;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.Optional;

public class Location {
    @Nullable
    private World world;
    private double x;
    private double y;
    private double z;
    private float pitch;
    private float yaw;

    public Location(double x, double y, double z) {
        this(null, x, y, z);
    }

    public Location(@Nullable World world, double x, double y, double z) {
        this(world, x, y, z, 0, 0);
    }

    public Location(double x, double y, double z, float pitch, float yaw) {
        this(null, x, y, z, pitch, yaw);
    }

    public Location(@Nullable World world, double x, double y, double z, float pitch, float yaw) {
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
        this.pitch = pitch;
        this.yaw = yaw;
    }

    public Optional<World> getWorld() {
        return Optional.ofNullable(world);
    }

    public void setWorld(@Nullable World world) {
        this.world = world;
    }

    @Nullable
    public World getNullableWorld() {
        return world;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public float getPitch() {
        return pitch;
    }

    public void setPitch(float pitch) {
        this.pitch = pitch;
    }

    public float getYaw() {
        return yaw;
    }

    public void setYaw(float yaw) {
        this.yaw = yaw;
    }

    public ChunkLocation getAsChunkLocation() {
        return new ChunkLocation(this);
    }

    @NotNull
    public Location add(double x, double y, double z) {
        return add(new Location(x, y, z));
    }

    @NotNull
    public Location add(Location location) {
        return new Location(world, x + location.getX(), y + location.y, z + location.z, pitch + location.pitch, yaw + location.yaw);
    }

    @NotNull
    public Location subtract(double x, double y, double z) {
        return subtract(new Location(x, y, z));
    }

    @NotNull
    public Location subtract(Location location) {
        return new Location(world, x - location.getX(), y - location.y, z - location.z, pitch - location.pitch, yaw - location.yaw);
    }


    @Override
    public String toString() {
        String worldName = world == null ? "null" : world.getName();
        return "Location{" +
                "world=" + worldName +
                ", x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", pitch=" + pitch +
                ", yaw=" + yaw +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Double.compare(location.x, x) == 0 &&
                Double.compare(location.y, y) == 0 &&
                Double.compare(location.z, z) == 0 &&
                Float.compare(location.pitch, pitch) == 0 &&
                Float.compare(location.yaw, yaw) == 0 &&
                Objects.equals(world, location.world);
    }

    @Override
    public int hashCode() {
        return Objects.hash(world, x, y, z, pitch, yaw);
    }
}
