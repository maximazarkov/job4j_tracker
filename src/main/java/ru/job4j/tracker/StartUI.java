package ru.job4j.tracker;

import ru.job4j.tracker.action.*;
import ru.job4j.tracker.input.ConsoleInput;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.ValidateInput;
import ru.job4j.tracker.tracker.MemTracker;
import ru.job4j.tracker.tracker.Store;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

/**
 * @author Azarkov Maxim
 * @version $Id$ 08.04.2021
 * @since 2.1
 */
public class StartUI {
    /**
     * основной цикл программы
     * @param validate - валидный пункт меню. Валидность должна быть проверена заранее.
     * @param tracker - модель трекера для сохранения данных
     * @param actions - список меню
     */
    void init(Input validate, Store tracker, UserAction[] actions) throws Exception {
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

    public static void main(String[] args) throws Exception {
        Input validate = new ValidateInput(
                new ConsoleInput()
        );
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        Item itemDate = new Item("123", "a", "b");

        System.out.println(itemDate.getLocalDataTime().format(formatter));

        System.out.println(itemDate);

        try (Store tracker = new MemTracker()) {
            // Инициализация трекера. Н-р, при работе с памятью нет действия;
            // при работе с БД, введен код по подключению к БД
            tracker.init();
            /* Зададим перечень пунктов меню по возрастанию.
            Пункт меню Exit program перенесем в позицию 0 для удобства*/
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
    }
}
