package ru.job4j.tracker.action;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.tracker.Store;

import java.util.List;
import java.util.function.Consumer;

/**
 * Класс реализует поиск заявки из хранилища по имени.
 */
public class FindByNameAction implements UserAction {

    @Override
    public String nameMenu() {
        return "Find Items By Name";
    }

    @Override
    public boolean execute(Input input, Store tracker, Consumer<String> output) {
        System.out.println("-------------- Find Item by Name --------------");
        String key = input.ask("Enter Item Name :");
        List<Item> items = tracker.findByName(key);
        if (items != null) {
            for (Item item : items) {
                System.out.println(item);
            }
        }
        System.out.println("---------------------------------------------------");
        return true;
    }
}