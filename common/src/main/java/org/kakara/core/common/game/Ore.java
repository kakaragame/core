package org.kakara.core.common.game;

public interface Ore extends Block {
    int getVeinSize();

    int getDepth();

    int getSparsity();

    int getRarity();
}