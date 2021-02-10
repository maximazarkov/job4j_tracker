package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.tracker.Store;

import java.util.function.Consumer;

/**
 * В отличии от UserActionMem UserAction не принимает параметров и предназначен для формирования меню
 * только на основе названия пункта. Номера пунктов необходимо формировать с помощью внешнего цикла.
 *
 * @author Maxim Azarkov
 * @version 0.1 10.02.2021
 */
public interface UserAction {

    /**
     * Метод возвращающий название пункта меню
     * @return - имя пункта меню
     */
    String nameMenu();

    /**
     * Основной метод.
     * @param variable - заранее проверенный номер пункта меню, который ввел пользователь
     * @param tracker объект модели Store (MemTracker, SqlTracker e.t.c.)
     * @param output методы вывода информации, реализован с помощью лямбда
     * @since 10.02.2021 0.2
     */
    boolean execute(Input variable, Store tracker, Consumer<String> output) throws Exception;
}
