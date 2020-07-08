package org.kakara.core.world;

import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

public class ChunkLocation {
    @Nullable private World world;
    private int x;
    private int y;
    private int z;

    public ChunkLocation(@Nullable World world, int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.world = world;
    }

    public ChunkLocation(int x, int y, int z) {
        this(null, x, y, z);
    }

    public ChunkLocation(Location location) {
        this(location.getWorld().isPresent() ? location.getWorld().get() : null, (int) location.getX(), (int) location.getY(), (int) location.getZ());
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

    public Optional<World> getWorld() {
        return Optional.ofNullable(world);
    }

    public void setWorld(@Nullable World world) {
        this.world = world;
    }

    public void forEach(Consumer<ChunkLocation> consumer) {
        for (int a = x; a < x + 16; a++) {
            for (int b = x; b < x + 16; b++) {
                for (int c = x; c < x + 16; c++) {
                    consumer.accept(new ChunkLocation(world, a, b, c));
                }
            }
        }
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
        return Objects.hash(x, y, z);
    }
}
