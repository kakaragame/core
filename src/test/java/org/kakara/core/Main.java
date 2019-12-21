package org.kakara.core;

import org.kakara.core.mod.Mod;

import java.util.concurrent.ExecutorService;

public class Main {
    public static void main(String[] args) {
        Mod mod = new ExampleMod();
        System.out.println(mod.getName());
    }
}
