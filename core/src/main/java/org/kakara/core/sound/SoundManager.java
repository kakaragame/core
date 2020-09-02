package org.kakara.core.sound;

import org.kakara.core.mod.Mod;
import org.kakara.core.player.Player;
import org.kakara.core.world.Location;

public interface SoundManager {

    void playPublicSound(Location location, String soundFile, Mod mod);

    void playPrivateSound(Player player, String soundFile, Mod mod);
}
