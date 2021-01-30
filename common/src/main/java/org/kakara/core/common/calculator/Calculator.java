package org.kakara.core.common.calculator;

/**
 * The calculator API allows one to change how in game math is done.
 * Things you can change include Fall Damage, Entity Damage, Block Break Time, or damaging an item.
 * <p>
 * These instances are universal and take in information such as Charms, Entity Objects, Location, ECT
 */
public interface Calculator {
    /**
     * The key for this Calculator
     *
     * @return
     */
    CalculatorKey getCalculatorKey();
}
