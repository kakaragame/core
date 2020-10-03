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

    /**
     * Set this location equal to another without mutation.
     * <p>This effectively makes a copy of the location provided.</p>
     *
     * @param location The location to set this location equal to.
     * @return The location after being set.
     */
    @NotNull
    public Location set(Location location) {
        this.world = location.world;
        this.x = location.x;
        this.y = location.y;
        this.z = location.z;
        this.pitch = location.pitch;
        this.yaw = location.yaw;
        return this;
    }

    /**
     * Set the x, y, and z value of the location.
     *
     * @param x The x value.
     * @param y The y value.
     * @param z The z value.
     * @return The instance of the location object.
     */
    @NotNull
    public Location set(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        return this;
    }

    /**
     * Set the x, y, z, pitch, and yaw value of the location.
     *
     * @param x     The x value.
     * @param y     The y value.
     * @param z     The z value.
     * @param pitch The pitch value.
     * @param yaw   The yaw value.
     * @return The instance of the location object.
     */
    @NotNull
    public Location set(double x, double y, double z, float pitch, float yaw) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.pitch = pitch;
        this.yaw = yaw;
        return this;
    }

    /**
     * Set the pitch and yaw of the location.
     *
     * @param pitch The pitch value.
     * @param yaw   The yaw value.
     * @return The instance of the location object.
     */
    @NotNull
    public Location set(float pitch, float yaw) {
        this.pitch = pitch;
        this.yaw = yaw;
        return this;
    }

    /**
     * Check to see if a location is similar to another.
     * <p>This method is similar to #equals but ignores the world of the location.</p>
     *
     * @param location The location to compare.
     * @return If the location is similar.
     */
    public boolean isSimilar(Location location) {
        if (this == location) return true;
        if (location == null) return false;
        return Double.compare(location.x, x) == 0 &&
                Double.compare(location.y, y) == 0 &&
                Double.compare(location.z, z) == 0 &&
                Float.compare(location.pitch, pitch) == 0 &&
                Float.compare(location.yaw, yaw) == 0;
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
