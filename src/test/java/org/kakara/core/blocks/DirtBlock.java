package org.kakara.core.blocks;

import org.kakara.core.annotations.Id;
import org.kakara.core.annotations.Name;
import org.kakara.core.annotations.Texture;
import org.kakara.core.bases.DirtBase;
import org.kakara.core.events.entity.StepOnEvent;
import org.kakara.core.events.player.ClickEvent;
import org.kakara.core.events.player.PlaceEvent;

@Id("dirt")
@Name("Dirt")
@Texture("blocks/dirt.png")
public class DirtBlock extends DirtBase {
    @Override
    public void onStep(StepOnEvent event) {

    }

    @Override
    public void onPlace(PlaceEvent event) {

    }

    @Override
    public float getHardness() {
        return 0;
    }

    @Override
    public float getWeight() {
        return 0;
    }

    @Override
    public void onClick(ClickEvent clickEvent) {

    }
}
