package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.tracker.Store;

import java.util.function.Consumer;

public class MenuTracker {
    private final Input input;
    private final Store tracker;
    private UserAction[] actions;

    /**
     * Реализация вывода данных с помощью Consumer
     * @since 11.10.2019 0.2
     */
    private final Consumer<String> output;

    /**
     * Конструктор.
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     * @param output - лямбда выражение - определяет формат выводимой информации.
     */
    public MenuTracker(Input input, Store tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    /**
     * Метод для получения длинны массива меню.
     * @return длину массива
     * @deprecated - остался от прошлых версий класса. Не рекомендуется применять.
     */
    @Deprecated
    public int getActionsLength() {
        return this.actions.length;
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions(UserAction[] actions) {
        this.actions = actions;
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соответствующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) throws Exception {
        this.actions[key].execute(this.input, this.tracker, output);
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        for (int i = 1; i < actions.length; i++) {

            System.out.printf("%d. %s%n", i, actions[i].nameMenu());
        }
        System.out.printf("%d. %s%n", 0, actions[0].nameMenu());
    }
}
