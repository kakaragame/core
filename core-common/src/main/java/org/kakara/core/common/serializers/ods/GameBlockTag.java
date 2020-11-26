package org.kakara.core.common.serializers.ods;

import me.ryandw11.ods.tags.ObjectTag;
import org.kakara.core.game.world.GameBlock;

public class GameBlockTag extends ObjectTag {
    public GameBlockTag(GameBlock block) {
        super(block.getLocation().getX() + "-" + block.getLocation().getZ() + "-" + block.getLocation().getY());
        addTag(new LocationTag("location", block.getLocation()));
        addTag(new ItemStackTag("itemstack", block.getItemStack()));
    }

    public static GameBlock getGameBlock(ObjectTag tag) {
        return new GameBlock(LocationTag.getLocation((ObjectTag) tag.getTag("location")), ItemStackTag.getItemStack((ObjectTag) tag.getTag("itemstack")));
    }

    public GameBlock getGameBlock() {
        return getGameBlock(this);
    }
}
