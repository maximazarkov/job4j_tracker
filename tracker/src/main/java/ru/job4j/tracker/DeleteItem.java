package ru.job4j.tracker;

import java.util.function.Consumer;

/**
 * Класс реализует удаление заявки из хранилища.
 */
public class DeleteItem extends BaseAction {
    public DeleteItem(int key, String info) {
        super(key, info);
    }

    @Override
    public void execute(Input input, Tracker tracker, Consumer<String> output) {
        System.out.println("----------------- Удаление заявки -----------------");
        String id = input.ask("Введите Id заявки, для ее удаления :");
        if (tracker.delete(id)) {
            System.out.println("--------------- Заявка удалена ----------------");
        } else {
            System.out.println("-------------- Заявка НЕ УДАЛЕНА!--------------");
        }
    }
}