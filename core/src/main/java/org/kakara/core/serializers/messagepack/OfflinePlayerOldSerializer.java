package org.kakara.core.serializers.messagepack;

import org.kakara.core.Kakara;
import org.kakara.core.data.Entry;
import org.kakara.core.data.OldSerializer;
import org.kakara.core.player.OfflinePlayer;

public class OfflinePlayerOldSerializer extends OldSerializer<OfflinePlayer> {
    @Override
    public Entry disassembleObject(OfflinePlayer offlinePlayer) {
        return new Entry(offlinePlayer.getUUID());
    }

    @Override
    public OfflinePlayer assembleObject(Entry entry) {
        return Kakara.getOfflinePlayer(entry.uuid());
    }
}
