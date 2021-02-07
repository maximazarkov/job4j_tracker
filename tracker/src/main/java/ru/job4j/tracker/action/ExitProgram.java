package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.tracker.MemTracker;

import java.util.function.Consumer;

public class ExitProgram extends BaseAction {
    public ExitProgram(int key, String info) {
        super(key, info);
    }

    @Override
    public void execute(Input input, MemTracker tracker, Consumer<String> output) {
// ничего не делаем
    }
}
