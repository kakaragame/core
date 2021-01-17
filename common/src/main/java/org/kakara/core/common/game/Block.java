package org.kakara.core.common.game;


import java.util.Set;

public interface Block extends Item {
    /**
     * Required ToolTypes to break the block
     *
     * @return the required ToolTypes
     */
    Set<ToolType> requiredToolTypes();

    /**
     * Hardness is used inside the game to calculate how long it will take to break.
     *
     * @return the hardness.
     */
    float getHardness();

    /**
     * Resistance is used is how hard it is to breaking due to explosions.
     *
     * @return the resistance.
     */
    float getResistance();

    /**
     * The HarvestLevel.
     * Harvest level must be equal or greater on the tool or the block will not break.
     *
     * @return the harvest level.
     */
    int getHarvestLevel();
}
