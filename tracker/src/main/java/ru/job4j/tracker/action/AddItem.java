package ru.job4j.tracker.action;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.tracker.Store;

import java.util.function.Consumer;

/**
 * Класс реализует добавление новой заявки в хранилище.
 * @deprecated. Используйте для работы новый класс CreateAction
 */
public class AddItem extends BaseAction {

    public AddItem(int key, String info) {
        super(key, info);
    }

    @Override
    public void execute(Input input, Store tracker, Consumer<String> output) {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = input.ask("Введите имя заявки :");
        String desc = input.ask("Введите описание заявки :");
        Item item = new Item(name, desc, System.currentTimeMillis());
        tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
        output.accept("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }
}
