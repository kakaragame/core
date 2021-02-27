package org.kakara.core.common.calculator;

import java.util.List;

public interface CalculatorRegistry {
    /**
     * Registers a new calculator to the system.
     * However, if the calculator has already been set the User will need to change it in the settings.
     *
     * @param calculator
     */
    void registerNewCalculator(Calculator calculator);

    /**
     * Returns the registered calculators for a given key.
     *
     * @param key the calculator key.
     * @return the list of registered calculators.
     */
    List<Calculator> getCalculators(CalculatorKey key);

    /**
     * Returns the set Calculator for a given key.
     *
     * @param key the key.
     * @return the calculator.
     */
    Calculator getSetCalculator(CalculatorKey key);
}
