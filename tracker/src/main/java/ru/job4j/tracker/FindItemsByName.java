package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * Класс реализует поиск заявки из хранилища по имени.
 */
public class FindItemsByName extends BaseAction {
    public FindItemsByName(int key, String info) {
        super(key, info);
    }

    @Override
    public void execute(Input input, Tracker tracker, Consumer<String> output) {
        System.out.println("-------------- Поиск заявки по имени --------------");
        String key = input.ask("Введите имя заявки:");
        ArrayList<Item> items = tracker.findByName(key);
        if (items != null) {
            for (Item item : items) {
                System.out.println(item);
            }
        }
        System.out.println("---------------------------------------------------");
    }
}