package ru.job4j.tracker;

import java.util.function.Consumer;

public class CreateAction implements UserAction {


    @Override
    public int key() {
        return 0;
    }

    @Override
    public void execute(Input input, MemTracker tracker, Consumer<String> output) {
        // TODO Спросить у ментора, что в этом классе должно быть. При выполнении
    }

    @Override
    public String info() {
        return null;
    }
}