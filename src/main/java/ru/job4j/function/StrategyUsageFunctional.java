package ru.job4j.function;

import java.util.function.Function;
import java.util.function.Predicate;

public class StrategyUsageFunctional {
    public boolean empty(String s) {
        return check(String::isEmpty, s);
    }

    public boolean startWith(String s, String pref) {
        return check(str -> str.startsWith(pref), s);
    }

    public boolean contains(String s, String key) {
        return check(str -> str.contains(key), s);
    }

    public boolean check(Predicate<String> predicate, String s) {
        return predicate.test(s);
    }

    public String transform(Function<String, String> fun, String s) {
        return fun.apply(s);
    }
}
