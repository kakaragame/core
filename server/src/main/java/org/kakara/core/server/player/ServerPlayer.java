package org.kakara.core.server.player;

import org.kakara.core.common.gui.Menu;
import org.kakara.core.common.player.Player;

public interface ServerPlayer extends Player {

    void openMenu(Menu menu);
}
