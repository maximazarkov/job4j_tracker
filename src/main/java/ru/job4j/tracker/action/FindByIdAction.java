package ru.job4j.tracker.action;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.tracker.Store;

import java.util.function.Consumer;

/**
 * Класс реализует поиск заявки из хранилища по Id.
 */
public class FindByIdAction implements UserAction {

    @Override
    public String nameMenu() {
        return "Find action by Id";
    }

    public boolean execute(Input input, Store tracker, Consumer<String> output) {
        System.out.println("---------------- Search Item by Id ---------------");
        String id = input.askToStr("Enter Id Item:");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
            System.out.println("---------------------------------------------------");
            return true;
        } else {
            System.out.println("----------------- Item not found ------------------");
            return false;
        }
    }

    @Override
    public boolean execute(Input variable, Store tracker) throws Exception {
        return false;
    }
}