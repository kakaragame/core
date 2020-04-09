package org.kakara.core.game;

public interface Tool extends Item {
    /**
     * A number between
     * 0.0-9.9
     * If set to 10. It will be at the max. and Unbreakable.
     *
     * @return the number the hardness is at
     */
    float getHardness();

    /**
     * Can be the actual block. Or a parent class or interface of a block.
     * SO for example
     * OakPlanks extends Wood
     * and you can add the value Wood.class to it
     * and it will apply to all classes that extend Wood.
     * <p>
     * Blocks to apply to the set hardness to. If a player doesnt use this tool against that block or block parent type.
     * <p>
     * The hardness will be lowered to 0.1 lower than that target block hardness. So it wont be able to break it.
     * Unless the blocks hardness is less than 1.1. THen it will be .1 higher than the blocks hardness it.
     * <p>
     * If you want it to work on all Block types just keep the array empty.
     *
     * @return the targeted block types
     */
    Class<?>[] targetedBlocks();
}
