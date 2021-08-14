package ru.job4j.tracker.action;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.tracker.Store;

import java.util.function.Consumer;

public class CreateAction implements UserAction {
    public String nameMenu() {
        return "Add Item";
    }

    @Override
    public boolean execute(Input input, Store tracker, Consumer<String> output) {
        System.out.println("------------ Add Item --------------");
        String name = input.askToStr("Enter name Item :");
        String desc = input.askToStr("Enter description Item :");
        Item item = new Item(name, desc, System.currentTimeMillis());
        tracker.add(item);
        System.out.println("------------ Item has been successfully added with Id : " + item.getId() + "-----------");
//        output.accept("------------ Новая заявка с getId : " + item.getId() + "-----------");
        return true;
    }

    @Override
    public boolean execute(Input variable, Store tracker) throws Exception {
        return false;
    }
}
