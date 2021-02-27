package ru.job4j.tracker;

import ru.job4j.tracker.action.MenuTrackerSql;
import ru.job4j.tracker.input.ConsoleInput;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.ValidateInput;
import ru.job4j.tracker.tracker.SqlTracker;

import java.util.function.Consumer;

/**
 * @author Azarkov Maxim
 * @version $Id$
 * @since 0.1
 */
public class StartUISQL {
    private static final int EXIT = 6; //Константа для выхода из цикла.
    private final Input input; //  Получение данных от пользователя.
    private final SqlTracker tracker; // Хранилище заявок

    /**
     * Реализация вывода данных с помощью Consumer. С помощью лямбда будет передана функция println
     * @since 11.10.2019 0.2
     */
    private final Consumer<String> output;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     * @param output ...
     * @since 11.10.2019 0.2
     */
    public StartUISQL(Input input, SqlTracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
//        init();
    }

    /**
     * Основой цикл программы.
     */
    private void init() throws Exception {
        boolean exit = false;
        MenuTrackerSql menu = new MenuTrackerSql(this.input, this.tracker, output);
        menu.fillActions();
        int[] range = new int[menu.getActionsLentgh()];
        for (int i = 0; i < menu.getActionsLentgh(); i++) {
            range[i] = i;
        }
        while (!exit) {
            menu.show();
            //String answer = input.ask("Введите пункт меню : ");
            int answer = input.askToInt("Введите пункт меню : ", range);
            menu.select(answer);
            //menu.select(input.ask("select:", range));
            if (EXIT == answer) {
                exit = true;
            }
        }
    }

    /**
     * Главный метод для запуска серсиии SQL
     * @author Azarkov Maxim
     * @since 08.02.2021 v.0.1
     */
    public static void main(String[] args) {
        Input validate = new ValidateInput(
                new ConsoleInput()
        );
//        try (Store tracker = new SqlTracker()) {
//            tracker.init();
//            UserAction[] actions = {
//                 new CreateAction();
//            }
//            new StartUISQL().init(validate, tracker, actions);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}
