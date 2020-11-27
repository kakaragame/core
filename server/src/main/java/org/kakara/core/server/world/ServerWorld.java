package org.kakara.core.server.world;

import org.jetbrains.annotations.NotNull;
import org.kakara.core.common.game.ItemStack;
import org.kakara.core.common.world.GameBlock;
import org.kakara.core.common.world.Location;
import org.kakara.core.common.world.World;

import java.util.Optional;

public interface ServerWorld extends World {
    @NotNull
    Optional<GameBlock> setBlock(@NotNull ItemStack itemStack, @NotNull Location location);

    //@NotNull
    //Optional<GameBlock> setBlock(@Nullable Block block, @NotNull Location location);
}
