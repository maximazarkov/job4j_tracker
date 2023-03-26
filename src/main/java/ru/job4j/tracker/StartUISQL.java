package ru.job4j.tracker;

import ru.job4j.tracker.action.*;
import ru.job4j.tracker.input.ConsoleInput;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.ValidateInput;
import ru.job4j.tracker.tracker.SqlTracker;
import ru.job4j.tracker.tracker.Store;

import java.io.IOException;
import java.util.function.Consumer;

/**
 * @author Azarkov Maxim
 * @version $Id$
 * @since 0.1
 */
public class StartUISQL {

    /**
     * Инициализация трекера. Н-р, при работе с памятью нет действия; при работе с БД,
     * введен код по подключению к БД
     */
    private void init(Input validate, Store tracker, UserAction[] actions) throws Exception {
        boolean exit = false;
        MenuTracker menu = new MenuTracker(validate, tracker, System.out::println);
        menu.fillActions(actions);
        while (!exit) {
            menu.show();
            int select = validate.askToInt("Enter select: ", actions.length);
            menu.select(select);
            UserAction action = actions[select];
            exit = action.execute(validate, tracker);
            if (select == 0) {
                exit = true;
            }
        }
    }

    /**
     * Главный метод для запуска серсиии SQL
     * @author Azarkov Maxim
     * @since 15.04.2021 v.0.2
     */
    public static void main(String[] args) {
        Input validate = new ValidateInput(
                new ConsoleInput()
        );
        try (Store tracker = new SqlTracker()) {
            tracker.init();

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
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
