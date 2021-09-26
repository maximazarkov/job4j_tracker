package ru.job4j.stream;

import java.util.stream.Stream;

public class DoubleLoop {
    public static void main(String[] args) {
        String[] tasks = {"task 1", "task 2", "task 3"};
        String[] levels = {"Level 1", "Level 2", "Level 3"};
        for (String level : levels) {
            for (String task : tasks) {
                System.out.println(level + " " + task);
            }
        }
        System.out.println("*** Stream API ***");
        Stream.of(levels)
                .flatMap(level -> Stream.of(tasks)
                        .map(task -> level + " " + task))
                .forEach(System.out::println);
    }
}
