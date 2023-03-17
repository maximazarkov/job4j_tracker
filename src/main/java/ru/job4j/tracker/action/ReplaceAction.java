package ru.job4j.tracker.action;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.tracker.Store;

import java.sql.SQLException;
import java.util.function.Consumer;

/**
 * Класс реализует редактирование заявки в хранилище.
 */
public class ReplaceAction implements UserAction {

    @Override
    public String nameMenu() {
        return "Edit Item";
    }

    @Override
    public boolean execute(Input input, Store tracker, Consumer<String> output)
            throws SQLException {
        System.out.println("------------- Edit Item ---------------");
        String id = input.askToStr("Enter the Id Item to change it :");
        String name = input.askToStr("Enter new name Item :");
        String desc = input.askToStr("Enter new Description :");
        Item item = new Item(name, desc);
        if (tracker.replace(id, item)) {
            System.out.println("------------- The Item has been edited --------------");
            return true;
        } else {
            System.out.println("------------ The Item has not been edited------------");
            return false;
        }
    }

    @Override
    public boolean execute(Input variable, Store tracker) throws Exception {
        return false;
    }
}
