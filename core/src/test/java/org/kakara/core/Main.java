package org.kakara.core;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Gson gson = new Gson();

    public static void main(String[] args) {
        ControllerKey nameKey = new ControllerKey("bob", "key");
        ControllerKey nameKeyTwo = new ControllerKey("bob", "kesy");
        System.out.println(nameKey.hashCode());
        System.out.println(nameKeyTwo.hashCode());
        Map<Integer, String> map = new HashMap<>();
        long start = System.currentTimeMillis();
        System.out.println(start);
        for (int i = 0; i < 12000000; i++) {
            map.put(i, String.valueOf(i));
            ControllerKey one = new ControllerKey("bob", "key");
            one.hashCode();
            nameKey.equals(nameKeyTwo);
        }
        System.out.println(start - System.currentTimeMillis());

    }
}
