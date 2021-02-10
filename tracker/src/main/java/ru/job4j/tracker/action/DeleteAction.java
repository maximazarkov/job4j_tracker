package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.tracker.Store;

import java.util.function.Consumer;

/**
 * Класс реализует удаление заявки из хранилища.
 */
public class DeleteAction implements UserAction {

    @Override
    public String nameMenu() {
        return "Delete Item";
    }

    @Override
    public boolean execute(Input input, Store tracker, Consumer<String> output) {
        System.out.println("----------------- Delete Item -----------------");
        String id = input.ask("Enter Id Item, for deleted it :");
        if (tracker.delete(id)) {
            System.out.println("--------------- Item deleted ----------------");
            return true;
        } else {
            System.out.println("------------- Item not deleted!--------------");
            return false;
        }
    }
}