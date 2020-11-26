package org.kakara.core.common.serializers.ods;

import me.ryandw11.ods.tags.ListTag;
import me.ryandw11.ods.tags.ObjectTag;
import org.kakara.core.world.ChunkContent;
import org.kakara.core.world.ChunkLocation;
import org.kakara.core.world.GameBlock;

import java.util.ArrayList;
import java.util.List;

public class ChunkContentTag extends ObjectTag {

    public ChunkContentTag(ChunkContent chunk) {
        super(chunk.getLocation().getX() + "-" + chunk.getLocation().getY() + "-" + chunk.getLocation().getZ());
        addTag(new ChunkLocationTag("location", chunk.getLocation()));
        List<GameBlockTag> gameBlocks = new ArrayList<>();
        chunk.getGameBlocks().forEach((block) -> {
            //Why do I need this?
            if (block != null)
                gameBlocks.add(new GameBlockTag(block));
        });
        addTag(new ListTag<>("blocks", gameBlocks));
    }

    public static ChunkContent getChunk(ObjectTag tag) {
        ChunkLocation loc = ChunkLocationTag.getChunkLocation((ObjectTag) tag.getTag("location"));
        ListTag<ObjectTag> blocks = (ListTag<ObjectTag>) tag.getTag("blocks");
        List<GameBlock> gameBlocks = new ArrayList<>();
        blocks.getValue().forEach(block -> {
            gameBlocks.add(GameBlockTag.getGameBlock(block));
        });

        return new ChunkContent(gameBlocks, loc);
    }
}
