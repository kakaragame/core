package org.kakara.core.server.world;

import org.jetbrains.annotations.NotNull;
import org.kakara.core.common.Serverable;
import org.kakara.core.common.exceptions.NoServerVersionAvailableException;
import org.kakara.core.common.game.ItemStack;
import org.kakara.core.common.world.GameBlock;
import org.kakara.core.common.world.Location;
import org.kakara.core.common.world.World;

import java.util.Optional;

public interface ServerWorld extends World {
    @Override
    default boolean isServerVersionAvailable() {
        return true;
    }

    @Override
    default <T extends Serverable> T getServerVersion() {
        return (T) this;
    }

    @Override
    default void requiresServerVersion() throws NoServerVersionAvailableException {

    }

    @NotNull
    Optional<GameBlock> setBlock(@NotNull ItemStack itemStack, @NotNull Location location);

    //@NotNull
    //Optional<GameBlock> setBlock(@Nullable Block block, @NotNull Location location);
}
