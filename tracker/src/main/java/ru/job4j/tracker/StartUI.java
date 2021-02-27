package ru.job4j.tracker;

import ru.job4j.tracker.action.*;
import ru.job4j.tracker.input.ConsoleInput;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.ValidateInput;
import ru.job4j.tracker.tracker.MemTracker;
import ru.job4j.tracker.tracker.Store;

import java.io.IOException;
import java.util.function.Consumer;

/**
 * @author Azarkov Maxim
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
//    private final Input input; //  Получение данных от пользователя.
//    private final MemTracker tracker; // Хранилище заявок

    /**
     * Реализация вывода данных с помощью Consumer. С помощью лямбда будет передана функция println
     * @since 11.10.2019 0.2
     */
//    private final Consumer<String> output;

//    /**
//     * Конструтор инициализирующий поля.
//     * @param input ввод данных.
//     * @param tracker хранилище заявок.
//     * @param output ...
//     * @since 11.10.2019 0.2
//     * @deprecated
//     */
////    public StartUI(Input input, MemTracker tracker, Consumer<String> output) {
//        this.input = input;
//        this.tracker = tracker;
//        this.output = output;
//        init();
//    }

    public StartUI() {

    }

    public StartUI(Input input, MemTracker tracker, Consumer<String> output) {
    }

    /**
     * основной цикл программы
     * @param validate - валидный пункт меню. Валибность должна быть проверена заранее.
     * @param tracker - модель трекера для сохранения данных
     * @param actions - список меню
     */
    private void init(Input validate, Store tracker, UserAction[] actions) throws Exception {
        boolean exit = false;
        MenuTrackerMem menu = new MenuTrackerMem(validate, tracker, System.out::println);
        menu.fillActions(actions);
        menu.show();
        int select = validate.askToInt("Enter select: ");
        UserAction action = actions[select];
        exit = action.execute(validate, tracker);
    }

    /**
     * Основой цикл программы.
     * @depricated
     */
//    private void init() {
//        boolean exit = false;
//        MenuTracker menu = new MenuTracker(this.input, this.tracker, output);
//        menu.fillActions();
//        int[] range = new int[menu.getActionsLentgh()];
//        for (int i = 0; i < menu.getActionsLentgh(); i++) {
//            range[i] = i;
//        }
//        while (!exit) {
//            menu.show();
//            //String answer = input.ask("Введите пункт меню : ");
//            int answer = input.ask("Введите пункт меню : ", range);
//            menu.select(answer);
//            //menu.select(input.ask("select:", range));
//            if (EXIT == answer) {
//                exit = true;
//            }
//        }
//    }

    public static void main(String[] args) throws Exception {
        Input validate = new ValidateInput(
                new ConsoleInput()
        );

        /*
        * TODO преобразование MenuTracker начнем с того, что начнем перетаскивать и модифицировать меторы с него
        * в класс StartUI. Модифицировать будем относительно конструкции, заданной в задании.
        */
        try (Store tracker = new MemTracker()) {
            tracker.init(); // в данном варианте по сути бесполезный выход, но по заданию он должен быть.
            /*зададим перечень пунктов меню по возрастанию. пункт меню Exit program  перенесем в позицию 0 для удобства*/
            UserAction[] actions = {
                    new ExitAction(),
                    new CreateAction(),
                    new ReplaceAction(),
                    new DeleteAction(),
                    new FindAllAction(),
                    new FindByIdAction(),
                    new FindByNameAction()
            };
            new StartUI().init(validate, tracker, actions);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        new StartUI(validate, new MemTracker(), System.out::println);
    }
}
