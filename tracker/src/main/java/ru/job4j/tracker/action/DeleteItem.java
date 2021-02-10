package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.tracker.MemTracker;
import ru.job4j.tracker.tracker.Store;

import java.util.function.Consumer;

/**
 * Класс реализует удаление заявки из хранилища.
 * @deprecated см. класс DeleteAction
 */
public class DeleteItem extends BaseAction {
    public DeleteItem(int key, String info) {
        super(key, info);
    }

//    @Override
//    public void execute(Input input, MemTracker tracker, Consumer<String> output) {
//        System.out.println("----------------- Удаление заявки -----------------");
//        String id = input.ask("Введите Id заявки, для ее удаления :");
//        if (tracker.delete(id)) {
//            System.out.println("--------------- Заявка удалена ----------------");
//        } else {
//            System.out.println("-------------- Заявка НЕ УДАЛЕНА!--------------");
//        }
//    }

    @Override
    public void execute(Input input, Store tracker, Consumer<String> output) {

    }
}