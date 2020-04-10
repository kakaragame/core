package org.kakara.core.data;

import org.msgpack.core.MessageBufferPacker;
import org.msgpack.core.MessagePack;
import org.msgpack.core.MessageUnpacker;

import java.io.IOException;

public abstract class Serializer<T> {
    public abstract Entry disassembleObject(T item);

    public abstract T assembleObject(Entry entry);

    public byte[] serialize(T item) {
        MessageBufferPacker mbp = MessagePack.newDefaultBufferPacker();

        try {
            mbp.packValue(disassembleObject(item).value);
        } catch (IOException e) {
            throw new IllegalArgumentException("There was an issue interpreting the values of the inputted object in the serializer.");
        }

        return mbp.toByteArray();
    }

    public T deserialize(byte[] bytes) {
        MessageUnpacker unpacker = MessagePack.newDefaultUnpacker(bytes);

        try {
            return assembleObject(new Entry(unpacker.unpackValue()));
        } catch (IOException | ClassCastException e) {
            throw new IllegalArgumentException("The bytes inputted are not compatible with this deserializer.");
        }
    }
}
