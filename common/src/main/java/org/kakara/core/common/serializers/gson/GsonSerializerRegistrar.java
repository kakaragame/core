package org.kakara.core.common.serializers.gson;

import com.google.gson.GsonBuilder;
import org.kakara.core.common.ControllerKey;

import java.util.ArrayList;
import java.util.List;

public class GsonSerializerRegistrar {
    public static List<GsonSubSerializerRegistrar> registrars = new ArrayList<>();

    static {
        registrars.add(new GsonSubSerializerRegistrar() {
            @Override
            public void registerSerializers(GsonBuilder builder) {
                builder.registerTypeAdapter(ControllerKey.class, new NameKeySerializer());
            }
        });
    }

    public static void registerSerializers(GsonBuilder builder) {
        registrars.forEach(gsonSubSerializerRegistrar -> gsonSubSerializerRegistrar.registerSerializers(builder));

    }

    public interface GsonSubSerializerRegistrar {
        void registerSerializers(GsonBuilder builder);
    }
}
