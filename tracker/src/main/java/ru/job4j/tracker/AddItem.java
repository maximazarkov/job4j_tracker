package ru.job4j.tracker;

import java.util.function.Consumer;

/**
 * Класс реализует добавленяи новый заявки в хранилище.
 */
public class AddItem extends BaseAction {

//    private int key;
//    private String info;

    public AddItem(int key, String info) {
        //this.key = key;
        //this.info = info;
        super(key, info);
    }

//    @Override
//    public int key() {
//        return this.key;
//    }

//    @Override
//    public String info() {
//        return String.format("%s. %s", this.key(), this.info);
//    }

    @Override
    public void execute(Input input, Tracker tracker, Consumer<String> output) {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = input.ask("Введите имя заявки :");
        String desc = input.ask("Введите описание заявки :");
        Item item = new Item(name, desc, System.currentTimeMillis());
        tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
        output.accept("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }
}
