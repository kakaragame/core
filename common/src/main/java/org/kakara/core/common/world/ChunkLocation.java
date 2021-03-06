package org.kakara.core.common.world;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Consumer;

public class ChunkLocation {
    @Nullable
    private World world;
    private int x;
    private int y;
    private int z;
    private int hashValue;

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
        hashValue = 0;
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        hashValue = 0;
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        hashValue = 0;
        this.z = z;
    }

    private ChunkLocation set(int x, int y, int z) {
        hashValue = 0;
        this.x = x;
        this.y = y;
        this.z = z;
        return this;
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

    @NotNull
    public ChunkLocation addMut(int x, int y, int z) {
        return set(this.x + x, this.y + y, this.z + z);
    }

    @NotNull
    public ChunkLocation addMut(ChunkLocation chunkLocation) {
        return addMut(chunkLocation.getX(), chunkLocation.getY(), chunkLocation.z);
    }


    public ChunkLocation add(int x, int y, int z) {
        return add(new ChunkLocation(x, y, z));
    }

    @NotNull
    public ChunkLocation add(ChunkLocation location) {
        return new ChunkLocation(world, x + location.getX(), y + location.y, z + location.z);
    }

    @NotNull
    public ChunkLocation subtract(int x, int y, int z) {
        return subtract(new ChunkLocation(x, y, z));
    }

    @NotNull
    public ChunkLocation subtract(ChunkLocation location) {
        return new ChunkLocation(world, x - location.getX(), y - location.y, z - location.z);
    }

    @NotNull
    public ChunkLocation subtractMut(int x, int y, int z) {
        return set(this.x - x, this.y - y, this.z - z);
    }

    @NotNull
    public ChunkLocation subtractMut(ChunkLocation location) {
        return subtractMut(location.getX(), location.getY(), location.getZ());
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
                Double.compare(location.z, z) == 0;
    }

    @Override
    public int hashCode() {
        if (hashValue == 0) hashValue = Arrays.hashCode(new int[]{x, y, z});
        return hashValue;
    }

    public String toSimpleString() {
        return "x=" + x + " y=" + y + " z=" + z;
    }
}
