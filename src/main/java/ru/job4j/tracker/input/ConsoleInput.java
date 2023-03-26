package ru.job4j.tracker.input;

import ru.job4j.tracker.action.MenuOutException;

import java.util.Scanner;
/**
 * Класс, для организации работы консольного ввода команд от пользователя
 * @author azarkov m.n.
 * @version v.0.1 11.04.2021
 */
public class ConsoleInput implements Input {
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Метод для получения данных с клавиатуры через консоль
     * @param question - Вопрос пользователю
     * @return - возвращает введенное пользователем значение в формате String
     */
    @Override
    public String askToStr(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    /**
     * Метод проверки введенного значения меню на вхождение его в диапазоне допустимых значений.
     * @param question - Вопрос пользователю;
     * @param range - диапазон допустимых значений меню;
     * @return - возвращаем числовое значение меню.
     */
    @Override
    @Deprecated
    public int askToInt(String question, int[] range) {
        int key = Integer.parseInt(this.askToStr(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new MenuOutException("Out of menu range.");
        }
        return key;
    }

    @Override
    public int askToInt(String question) {
        return 0;
    }

    @Override
    public int askToInt(String question, int max) {
        return 0;
    }
}
