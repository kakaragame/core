package org.kakara.core;

import org.kakara.core.mod.ModType;
import org.kakara.core.mod.annotations.ModInfo;
import org.kakara.core.mod.annotations.OnDisable;
import org.kakara.core.mod.annotations.OnEnable;
import org.kakara.core.mod.annotations.Reload;
import org.kakara.core.mod.game.GameMod;

@ModInfo(modType = ModType.REGULAR, name = "TestMod", version = "0.0.1")
public class ExampleMod extends GameMod {


    @OnEnable
    private void enable() {

    }

    @OnDisable
    private void disable() {

    }

    @Reload
    private void reload() {

    }
}
