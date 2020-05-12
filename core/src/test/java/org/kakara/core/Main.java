package org.kakara.core;

import com.google.gson.Gson;
import org.kakara.core.mod.Mod;
import org.kakara.core.mod.ModSetting;
import org.kakara.core.modinstance.ModInstance;
import org.kakara.core.modinstance.ModInstanceType;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class Main {
    private static Gson gson = new Gson();

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
