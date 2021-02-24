package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.tracker.Store;

import java.util.function.Consumer;

/**
 * @deprecated Используйте для работы новый класс ExitAction
 */
public class ExitProgram extends BaseAction {
    public ExitProgram(int key, String info) {
        super(key, info);
    }

    @Override
    public void execute(Input input, Store tracker, Consumer<String> output) {
        // ничего не делаем
    }
}
