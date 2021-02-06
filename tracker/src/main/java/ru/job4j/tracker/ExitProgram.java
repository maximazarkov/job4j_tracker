package ru.job4j.tracker;

import java.util.function.Consumer;

public class ExitProgram extends BaseAction {
    public ExitProgram(int key, String info) {
        super(key, info);
    }

    @Override
    public void execute(Input input, Tracker tracker, Consumer<String> output) {
// ничего не делаем
    }
}
