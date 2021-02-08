package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.tracker.SqlTracker;

import java.util.function.Consumer;

public interface UserActionSql {
    /**
     * Метод возвращает ключ опции.
     * @return ключ
     */
    int key();
    /**
     * Основной метод.
     * @param input объект типа Input
     * @param tracker объект типа Tracker
     * @param output методы вывода информации
     * @since 08.02.2021 0.1
     */
    void execute(Input input, SqlTracker tracker, Consumer<String> output);
    /**
     * Метод возвращает информацию о данном пункте меню.
     * @return Строка меню
     */
    String info();
}
