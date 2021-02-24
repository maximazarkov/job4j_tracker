package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.tracker.Store;

import java.util.function.Consumer;

/**
 * @deprecated в новой версии трекера рекомендовано применять новый интерфейс UserAction
 */
public interface UserActionMem {
    /**
     * Метод возвращает ключ пункта меню.
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
    void execute(Input input, Store tracker, Consumer<String> output);
    /**
     * Метод возвращает информацию о данном пункте меню.
     * @return Строка меню
     */
    String info();
}
