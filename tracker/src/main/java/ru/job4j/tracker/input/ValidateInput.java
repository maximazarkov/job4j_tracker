package ru.job4j.tracker.input;

import ru.job4j.tracker.action.MenuOutException;

/**
 * Композиция...
 * класс ValidateInput, реализующий интерфейс Input. В нем переопределен метод ask таким образом,
 * что бы обрабатывались исключительные ситуации (при помощи блоков try { … } catch( … ) { … }).
 */
public class ValidateInput implements Input {
    private final Input input;

    /**
     * в конструктор передается класс, который реализует формирование данны, например - это класс для консольного ввода
     * или его имитация. Может даже некий переходной модуль для управления через помок или получения команд из
     * графической оболочки.
     * @param input
     */
    public ValidateInput(final Input input) {
        this.input = input;
    }

    @Override
    public int askToInt(String question, int[] range) {

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
        return this.input.askToStr(question);
    }

    @Override
    public int askToInt(String question) {
        return 0;
    }

    @Override
    public int askToInt(String question, int max) {
        int result = 0;
        int[] range = new int[max + 1];
        for (int i = 0; i <= max; i++) {
            range[i] = i;
        }
        result = askToInt(question, range);
        return result;
    }
}
