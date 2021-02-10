package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.tracker.Store;

import java.util.function.Consumer;

/**
 * Класс реализует поиск заявки из хранилища по имени.
 * @deprecated. см.класс FindByNameAction
 */
public class FindItemsByName extends BaseAction {
    public FindItemsByName(int key, String info) {
        super(key, info);
    }

    //    @Override
//    public void execute(Input input, MemTracker tracker, Consumer<String> output) {
//        System.out.println("-------------- Поиск заявки по имени --------------");
//        String key = input.ask("Введите имя заявки:");
//        List<Item> items = tracker.findByName(key);
//        if (items != null) {
//            for (Item item : items) {
//                System.out.println(item);
//            }
//        }
//        System.out.println("---------------------------------------------------");
//    }

    @Override
    public void execute(Input input, Store tracker, Consumer<String> output) {

    }
}