package org.kakara.core.data;

import org.msgpack.value.Value;
import org.msgpack.value.ValueFactory;

import java.util.*;

public class Entry {
    final Value value;

    Entry(Value value) {
        this.value = value;
    }

    public Entry(Map<String, Entry> map) {
        Map<Value, Value> valueMap = new HashMap<>();

        map.forEach((s, entry) -> {
            valueMap.put(ValueFactory.newString(s), entry.value);
        });

        this.value = ValueFactory.newMap(valueMap);
    }

    public Entry(List<Entry> list) {
        Value[] values = new Value[list.size()];

        for (int i = 0; i < list.size(); i++) {
            values[i] = list.get(i).value;
        }

        this.value = ValueFactory.newArray(values);
    }

    public Entry(Entry[] array) {
        List<Value> values = new ArrayList<>();

        for (Entry entry : array) {
            values.add(entry.value);
        }

        this.value = ValueFactory.newArray(values);
    }

    public Entry(String string) {
        this.value = ValueFactory.newString(string);
    }

    public Entry(int integer) {
        this.value = ValueFactory.newInteger(integer);
    }

    public Entry(float floatNumber) {
        this.value = ValueFactory.newFloat(floatNumber);
    }

    public Entry(double doubleNumber) {
        this.value = ValueFactory.newFloat(doubleNumber);
    }

    public Entry(long longNumber) {
        this.value = ValueFactory.newInteger(longNumber);
    }

    public Entry(boolean bool) {
        this.value = ValueFactory.newBoolean(bool);
    }

    public Entry(UUID uuid) {
        this.value = ValueFactory.newString(uuid.toString());
    }

    public Map<String, Entry> map() {
        Map<String, Entry> map = new HashMap<>();

        value.asMapValue().map().forEach((value, value2) ->
                map.put(value.asStringValue().toString(), new Entry(value2))
        );

        return map;
    }

    public List<Entry> list() {
        List<Entry> entries = new ArrayList<>();

        for (Value v : value.asArrayValue().list()) {
            entries.add(new Entry(v));
        }

        return entries;
    }

    public Entry[] array() {
        List<Entry> list = list();
        Entry[] entries = new Entry[list.size()];

        for (int i = 0; i < list.size(); i++) {
            entries[i] = list.get(i);
        }

        return entries;
    }

    public String string() {
        return value.asStringValue().asString();
    }

    public int integer() {
        return value.asNumberValue().toInt();
    }

    public float floatNumber() {
        return value.asNumberValue().toFloat();
    }

    public double doubleNumber() {
        return value.asNumberValue().toDouble();
    }

    public long longNumber() {
        return value.asNumberValue().toLong();
    }

    public boolean bool() {
        return value.asBooleanValue().getBoolean();
    }

    public UUID uuid() {
        return UUID.fromString(string());
    }
}
