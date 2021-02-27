package org.kakara.core.common.calculator;

public enum GameCalculatorKeys implements CalculatorKey {
    BLOCK_BREAK_TIME;

    @Override
    public String getName() {
        return name();
    }
}
