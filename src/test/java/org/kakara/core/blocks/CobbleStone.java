package org.kakara.core.blocks;

import org.kakara.core.ExampleMod;
import org.kakara.core.annotations.Id;
import org.kakara.core.annotations.Name;
import org.kakara.core.annotations.Texture;

@Id("cobble_stone")
@Name("Cobble Stone")
@Texture("blocks/cobblestone.png")
public class CobbleStone extends Stone {
    public CobbleStone(ExampleMod mod) {
        super(mod);
    }
}
