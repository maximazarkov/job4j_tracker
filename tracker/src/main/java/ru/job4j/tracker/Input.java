package ru.job4j.tracker;

public interface Input {
    String ask(String quastion);

    int ask(String quastion, int[] range);
}
