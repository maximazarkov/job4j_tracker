package ru.job4j.tracker;

import java.util.function.Consumer;

public interface UserAction {
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
     * @since 11.10.2019 0.2
     */
    void execute(Input input, Tracker tracker, Consumer<String> output);
    /**
     * Метод возвращает информацию о данном пункте меню.
     * @return Строка меню
     */
    String info();
}
