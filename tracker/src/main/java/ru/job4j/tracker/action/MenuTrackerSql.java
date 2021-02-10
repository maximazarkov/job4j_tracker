package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.tracker.SqlTracker;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class MenuTrackerSql {
    private Input input; // хранит ссылку на объект
    private SqlTracker tracker; // хранит ссылку на объект
    private List<UserAction> actions = new ArrayList<>(); // хранит ссылку на массив типа UserAction

    /**
     * Реализация вывода данных с помощью Consumer
     * @since 08.02.2021 0.1
     */
    private final Consumer<String> output;

    /**
     * Конструктор.
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     * @param output
     */
    public MenuTrackerSql(Input input, SqlTracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    /**
     * Метод для получения длинны массива меню.
     * @return длину массива
     */
    public int getActionsLentgh() {
        return this.actions.size();
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions() {
//        this.actions.add(new AddItem(0, "Add new Item"));
//        this.actions.add(new ShowAllItems(1, "Show all items"));
//        this.actions.add(new EditItem(2, "Edit item"));
//        this.actions.add(new DeleteItem(3, "Delete item"));
//        this.actions.add(new FindItemById(4, "Find item by Id"));
//        this.actions.add(new FindItemsByName(5, "Find items by name"));
//        this.actions.add(new ExitProgram(6, "Exit Program"));
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) throws Exception {
        this.actions.get(key).execute(this.input, this.tracker, output);
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
//                System.out.println(action.info());
            }
        }
    }
}
