package ru.job4j.tracker.action;

/**
 * Класс представляет некий общий интерфейс для вывода информации о заявке. Т.е. при
 * @deprecated в новой версии трекера рекомендовано применять новый интерфейс UserAction
 */
public abstract class BaseAction implements UserActionMem {

    private final int key;
    private final String name;

    /**
     * Конструктор абстрактного класса. при старте "просит" номер меню и нач\звание меню
     * */
    protected BaseAction(final int key, final String name) {
        this.key = key;
        this.name = name;
    }

    @Override
    public int key() {
        return this.key;
    }

    @Override
    public String info() {
        return String.format("%s. %s", this.key, this.name);
    }

}
