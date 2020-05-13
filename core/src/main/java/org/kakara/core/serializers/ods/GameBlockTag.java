package org.kakara.core.serializers.ods;

import me.ryandw11.ods.tags.ObjectTag;
import org.kakara.core.game.ItemStack;
import org.kakara.core.world.GameBlock;
import org.kakara.core.world.Location;

public class GameBlockTag extends ObjectTag {
    public GameBlockTag(GameBlock block){
        super(block.getLocation().getX() + "-" + block.getLocation().getZ() + "-" + block.getLocation().getY());
        addTag(new LocationTag("location", block.getLocation()));
        addTag(new ItemStackTag("itemstack", block.getItemStack()));
    }

    public GameBlock getGameBlock(){
        return new GameBlock(((LocationTag) getTag("location")).getLocation(), ((ItemStackTag) getTag("itemstack")).getItemStack());
    }
}
