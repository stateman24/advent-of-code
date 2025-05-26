package com.example;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvConfig {
    private static Dotenv env;

    static {
        env = Dotenv.configure().load();
    }

    public static String get(String key) {
        return env.get(key);
    }
}
