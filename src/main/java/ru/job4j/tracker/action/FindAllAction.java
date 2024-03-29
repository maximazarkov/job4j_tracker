package ru.job4j.tracker.action;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.tracker.Store;

import java.sql.SQLException;
import java.util.function.Consumer;

/**
 * Класс реализует вывод всеех заявок из хранилища.
 */
public class FindAllAction implements UserAction {

    @Override
    public String nameMenu() {
        return "Show all Items";
    }

    @Override
    public boolean execute(Input input, Store tracker, Consumer<String> output)
            throws SQLException {
        System.out.println("------------ Show all Items --------------");
        for (Item item : tracker.findAll()) {
            output.accept(String.format("Name: %s| Desc: %s| Id: %s",
                    item.getName(), item.getDesc(), item.getId()));
        }
        System.out.println("---------------------------------------------------");
        return true;
    }

    @Override
    public boolean execute(Input variable, Store tracker) throws Exception {
        return false;
    }
}
