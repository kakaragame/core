package org.kakara.core.data;

import java.util.HashMap;
import java.util.Map;

public class SerializerManager {
    private Map<Class, Serializer> serializers;

    public SerializerManager() {
        serializers = new HashMap<>();
    }

    public <C> void register(Class<C> cClass, Serializer<C> serializer) {
        serializers.put(cClass, serializer);
    }

    public byte[] serialize(Object object) {
        for (Map.Entry<Class, Serializer> entry : serializers.entrySet()) {
            if (entry.getKey() == object.getClass()) {
                return entry.getValue().serialize(object);
            }
        }

        throw new IllegalArgumentException("The inputted object does not have an associated serializer in this SerializerManager and therefore cannot be serialized.");
    }

    public <T> T deserialize(Class<T> aClass, byte[] bytes) {
        for (Map.Entry<Class, Serializer> entry : serializers.entrySet()) {
            if (entry.getKey() == aClass) {
                return (T) entry.getValue().deserialize(bytes);
            }
        }

        throw new IllegalArgumentException("The inputted object does not have an associated serializer in this SerializerManager and therefore cannot be serialized.");
    }

    public Entry createEntry(Object serializableObject) {
        for (Map.Entry<Class, Serializer> entry : serializers.entrySet()) {
            if (entry.getKey() == serializableObject.getClass()) {
                return entry.getValue().disassembleObject(serializableObject);
            }
        }

        throw new IllegalArgumentException("The inputted object does not have an associated serializer in this SerializerManager and therefore cannot be made into an Entry.");
    }
}
