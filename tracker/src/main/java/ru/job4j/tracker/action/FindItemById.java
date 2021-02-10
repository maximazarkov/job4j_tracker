package ru.job4j.tracker.action;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.tracker.MemTracker;
import ru.job4j.tracker.tracker.Store;

import java.util.function.Consumer;

/**
 * Класс реализует поиск заявки из хранилища по Id.
 * @deprecated. см.класс FindByIdAction
 */
public class FindItemById extends BaseAction {
    public FindItemById(int key, String info) {
        super(key, info);
    }

//    @Override
//    public void execute(Input input, MemTracker tracker, Consumer<String> output) {
//        System.out.println("---------------- Поиск заявки по Id ---------------");
//        String id = input.ask("Введите Id заявки:");
//        Item item = tracker.findById(id);
//        if (item != null) {
//            System.out.println(item);
//            System.out.println("---------------------------------------------------");
//        } else {
//            System.out.println("----------------- Заявки отсуствуют -----------------0");
//        }
//    }

    @Override
    public void execute(Input input, Store tracker, Consumer<String> output) {

    }
}