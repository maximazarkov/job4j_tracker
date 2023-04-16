package ru.job4j.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SelectionExample {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Один", "Два", "Три", "Четыре", "Пять");
        List<String> rsl = strings.stream()
                .skip(2)
                .collect(Collectors.toList());
        System.out.println(rsl);
        rsl = strings.stream()
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(rsl);
        rsl = strings.stream()
                .skip(2)
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(rsl);
        rsl = Collections.singletonList(strings.stream()
                .skip(2)
                .limit(2)
                .findFirst()
                .orElse("По умолчанию"));
        System.out.println(rsl);
        rsl = Collections.singletonList(strings.stream()
                .skip(5)
                .findFirst()
                .orElse("По умолчанию"));
        System.out.println(rsl);
        rsl = Collections.singletonList(strings.stream()
                .skip(strings.size() - 1)
                .findFirst()
                .orElse("По умолчанию"));
        System.out.println(rsl);
    }
}
