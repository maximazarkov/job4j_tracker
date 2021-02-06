package ru.job4j.tracker;

import java.util.function.Consumer;

/**
 * Класс реализует редактирование заявки в хранилище.
 */
public class EditItem extends BaseAction {
    public EditItem(int key, String info) {
        super(key, info);
    }

    @Override
    public void execute(Input input, Tracker tracker, Consumer<String> output) {
        System.out.println("------------- Редактирование заявки ---------------");
        String id = input.ask("Введите Id заявки, для ее изменения :");
        String name = input.ask("Введите новое имя заявки :");
        String desc = input.ask("Введите новое описание заявки :");
        Item item = new Item(name, desc, System.currentTimeMillis());
        if (tracker.replace(id, item)) {
            System.out.println("------------- Заявка отредактирована --------------");
        } else {
            System.out.println("------------ Заявка НЕ ОТРЕДАКТИРОВАНА!------------");
        }
    }
}
