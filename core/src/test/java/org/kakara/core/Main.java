package org.kakara.core;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Gson gson = new Gson();

    public static void main(String[] args) {
        NameKey nameKey = new NameKey("bob", "key");
        NameKey nameKeyTwo = new NameKey("bob", "kesy");
        System.out.println(nameKey.hashCode());
        System.out.println(nameKeyTwo.hashCode());
        Map<Integer, String> map = new HashMap<>();
        long start = System.currentTimeMillis();
        System.out.println(start);
        for (int i = 0; i < 12000000; i++) {
            map.put(i, String.valueOf(i));
            NameKey one = new NameKey("bob", "key");
            one.hashCode();
            nameKey.equals(nameKeyTwo);
        }
        System.out.println(start - System.currentTimeMillis());

    }
}
