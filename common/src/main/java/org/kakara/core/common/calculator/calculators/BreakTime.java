package org.kakara.core.common.calculator.calculators;

import org.kakara.core.common.calculator.Calculator;
import org.kakara.core.common.calculator.CalculatorKey;
import org.kakara.core.common.calculator.GameCalculatorKeys;
import org.kakara.core.common.game.ItemStack;
import org.kakara.core.common.player.Player;

/**
 * The block breaktime calculutor.
 * <p>
 * This will decide the time it will take to break a given block.
 */
public interface BreakTime extends Calculator {
    /**
     * Calculates the the break time.
     *
     * @param player the player doing the breaking.
     * @param tool   the tool used in said breaking.
     * @param block  the block being broken.
     * @return the time it will take to break. This is how much percentage per frame.
     */
    double calculate(Player player, ItemStack tool, ItemStack block);

    @Override
    default CalculatorKey getCalculatorKey() {
        return GameCalculatorKeys.BLOCK_BREAK_TIME;
    }
}
