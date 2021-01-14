package org.kakara.core.common.world;

import org.kakara.core.common.ControllerKey;
import org.kakara.core.common.Kakara;
import org.kakara.core.common.service.Service;

import java.io.File;

public abstract class ChunkWriterService implements Service {
    public static final ControllerKey SERVICE_KEY = Kakara.getEnvironmentInstance().createSystemKey("CHUNK_WRITER");


    abstract ChunkWriter createChunkWriter(File worldFolder, World world);

    //Overide Methods
    @Override
    public String getName() {
        return "Chunk Writer Controller";
    }

    @Override
    public int getId() {
        return SERVICE_KEY.hashCode();
    }

    @Override
    public ControllerKey getControllerKey() {
        return SERVICE_KEY;
    }

    @Override
    public String getKey() {
        return SERVICE_KEY.getKey();
    }


    @Override
    public Class<? extends Service> getServiceClass() {
        return ChunkWriterService.class;
    }
}
