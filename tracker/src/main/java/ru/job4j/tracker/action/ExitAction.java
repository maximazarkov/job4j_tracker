package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.tracker.Store;

import java.util.function.Consumer;

public class ExitAction implements UserAction {

    public String nameMenu() {
        return "Exit program";
    }

    @Override
    public void execute(Input input, Store tracker, Consumer<String> output) {
        // ничего не делаем
    }

}
