package org.kakara.core.common.game;

import java.util.Set;

/**
 * Represents a Tool.
 * Tools are extensions of Items. They have extra properties.
 */
public interface Tool extends Item {

    /**
     * Hardness is used inside the game to calculate how long it will take to break.
     *
     * @return the hardness.
     */
    float getHardness();

    /**
     * The HarvestLevel.
     * Harvest level must be equal or greater on the tool or the block will not break.
     *
     * @return the harvest level.
     */
    int getHarvestLevel();

    /**
     * What is the ToolType of this object
     * <p>
     * A Tool can be multiple tool types. Allowing more advance tools
     *
     * @return what type of tool is this?
     */
    Set<ToolType> getToolType();
}
