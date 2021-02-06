package ru.job4j.tracker;

import java.util.function.Consumer;

/**
 * Класс реализует вывод всеех заявок из хранилища.
 */
public class ShowAllItems extends BaseAction {

    public ShowAllItems(int key, String info) {
        super(key, info);
    }

    @Override
    public void execute(Input input, Tracker tracker, Consumer<String> output) {
        System.out.println("------------ Отображение всех заявки --------------");
        for (Item item : tracker.findAll()) {
//            System.out.println(item);  // @depricated v0.2
            output.accept(String.format("Name: %s| Desc: %s| Id: %s",
                    item.getName(), item.getDesc(), item.getId()));
        }
        System.out.println("---------------------------------------------------");
    }

}
