package org.kakara.core;

import org.kakara.core.bases.DirtBase;
import org.kakara.core.crafting.DynamicCraftingItem;
import org.kakara.core.crafting.ShapedRecipe;
import org.kakara.core.crafting.StaticCraftingItem;
import org.kakara.core.game.Block;
import org.kakara.core.game.Item;
import org.kakara.core.mod.ModType;
import org.kakara.core.mod.annotations.ModInfo;
import org.kakara.core.mod.annotations.OnDisable;
import org.kakara.core.mod.annotations.OnEnable;
import org.kakara.core.mod.annotations.Reload;
import org.kakara.core.mod.game.GameMod;
import org.kakara.core.resources.ResourceType;

import java.util.Collections;
import java.util.List;

@ModInfo(modType = ModType.REGULAR, name = "TestMod", version = "0.0.1")
public class ExampleMod extends GameMod {


    @OnEnable
    private void enable() {
        registerResources();

    }

    private void registerResources() {
        registerResource("/models/block.obj", ResourceType.MODEL);
        registerResource("/textures/blocks/grass.png", ResourceType.TEXTURE);
        registerResource("/textures/blocks/dirt.png", ResourceType.TEXTURE);
        registerResource("/audio/blocks/step-on-grass.mp3", ResourceType.AUDIO);
        registerResource("/config.yml", ResourceType.OTHER);
    }

    @OnDisable
    private void disable() {

    }

    @Reload
    private void reload() {

    }
}
