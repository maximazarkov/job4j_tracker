package ru.job4j.function;

public class StrategyUsage {
    public boolean empty(String s) {
        return s.isEmpty();
    }

    public boolean startWith(String s, String pref) {
        return s.startsWith(pref);
    }

    public boolean contains(String s, String key) {
        return s.contains(key);
    }
}
