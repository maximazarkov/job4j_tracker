package ru.job4j.tracker;

import java.util.function.Consumer;

/**
 * Класс реализует поиск заявки из хранилища по Id.
 */
public class FindItemById extends BaseAction {
    public FindItemById(int key, String info) {
        super(key, info);
    }

    @Override
    public void execute(Input input, Tracker tracker, Consumer<String> output) {
        System.out.println("---------------- Поиск заявки по Id ---------------");
        String id = input.ask("Введите Id заявки:");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
            System.out.println("---------------------------------------------------");
        } else {
            System.out.println("----------------- Заявки отсуствуют -----------------0");
        }
    }
}