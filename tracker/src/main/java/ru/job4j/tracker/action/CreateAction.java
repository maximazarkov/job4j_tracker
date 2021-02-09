package ru.job4j.tracker.action;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.tracker.Store;

import java.util.function.Consumer;

public class CreateAction implements UserAction {
    public String nameMenu() {
        return "Exit program";
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
