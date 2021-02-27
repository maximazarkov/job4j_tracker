package ru.job4j.tracker.input;

import ru.job4j.tracker.action.MenuOutException;

/**
 * Композиция...
 * класс ValidateInput, реализующий интерфейс Input. В нем переопределен метод ask таким образом,
 * что бы обрабатывались исключительные ситуации (при помощи блоков try { … } catch( … ) { … }).
 */
//public class ValidateInput extends ConsoleInput {
public class ValidateInput implements Input {
    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }
    public int ask(String question, int[] range) {

        /**
         * инициализируем условие выхода из цикла опроса клавиатуры. Если ошибок нет, то клавиатура опрашивается
         * без замечаний и возвращается номер нажато клавищи. Если допущен случай исключения, то возвращается ошибка -1.
         */
        boolean invalid = true;
        int value = -1;
        do {
           try {
                value = this.input.askToInt(question, range);
                invalid = false;
           } catch (MenuOutException moe) {
               //moe.printStackTrace();
               System.out.println("Please select key from menu.");
           } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again");
           }
        } while (invalid);
        return value;
    }

    @Override
    public String askToStr(String question) {
        return null;
    }

    @Override
    public int askToInt(String question, int[] range) {
        return 0;
    }

    @Override
    public int askToInt(String question) {
        return 0;
    }
}
