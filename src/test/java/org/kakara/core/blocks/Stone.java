package org.kakara.core.blocks;

import org.kakara.core.ExampleMod;
import org.kakara.core.annotations.Id;
import org.kakara.core.annotations.Name;
import org.kakara.core.annotations.Texture;

import org.kakara.core.events.entity.StepOnEvent;
import org.kakara.core.events.player.ClickEvent;
import org.kakara.core.events.player.PlaceEvent;
import org.kakara.core.mod.game.ModBlock;

@Id("stone")
@Name("Stone")
@Texture("blocks/stone.png")
public class Stone extends ModBlock {
    private ExampleMod mod;

    public Stone(ExampleMod mod) {
        this.mod = mod;
    }

    @Override
    public float getWeight() {
        return 0;
    }

    @Override
    public void onClick(ClickEvent clickEvent) {
        mod.getKakaraCore().getSoundManager().playPublicSound(clickEvent.getPlayer().getLocation(), "sounds/stone_click.mp3", mod);

    }

    @Override
    public void onStep(StepOnEvent event) {
        mod.getKakaraCore().getSoundManager().playPublicSound(event.getGameEntity().getLocation(), "sounds/stone_step.mp3", mod);
    }

    @Override
    public void onPlace(PlaceEvent event) {
        mod.getKakaraCore().getSoundManager().playPublicSound(event.getPlayer().getLocation(), "sounds/block_place.mp3", mod);
    }

    @Override
    public float getHardness() {
        return 10f;
    }
}
