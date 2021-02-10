package ru.job4j.tracker.action;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.tracker.MemTracker;
import ru.job4j.tracker.tracker.Store;

import java.util.function.Consumer;

/**
 * Класс реализует вывод всеех заявок из хранилища.
 * @deprecated. см.класс FindAllAction
 */
public class ShowAllItems extends BaseAction {

    public ShowAllItems(int key, String info) {
        super(key, info);
    }

//    @Override
//    public void execute(Input input, MemTracker tracker, Consumer<String> output) {
//        System.out.println("------------ Отображение всех заявки --------------");
//        for (Item item : tracker.findAll()) {
////            System.out.println(item);  // @depricated v0.2
//            output.accept(String.format("Name: %s| Desc: %s| Id: %s",
//                    item.getName(), item.getDesc(), item.getId()));
//        }
//        System.out.println("---------------------------------------------------");
//    }

    @Override
    public void execute(Input input, Store tracker, Consumer<String> output) {

    }
}
