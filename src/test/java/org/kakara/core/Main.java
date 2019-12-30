package org.kakara.core;

import com.google.gson.Gson;
import org.kakara.core.mod.Mod;
import org.kakara.core.mod.ModSetting;
import org.kakara.core.modinstance.ModInstance;
import org.kakara.core.modinstance.ModInstanceType;

import java.util.concurrent.ExecutorService;

public class Main {
    private static Gson gson  = new Gson();
    public static void main(String[] args) {
        Mod mod = new ExampleMod();
        System.out.println(mod.getName());
        ModSetting setting = new ModSetting();

        for (int i = 0; i < 56; i++) {
            setting.setSetting(String.valueOf(i), i);
        }
        ModInstance instance = new ModInstance("Vanilla_Mod", "https://kakara/mods", "1.0",setting, ModInstanceType.FILE);
        System.out.println(gson.toJson(instance).getBytes().length);
        System.out.println(gson.toJson(instance));

    }
}
