package ru.job4j.tracker.input;

import ru.job4j.tracker.action.MenuOutException;

import java.util.Scanner;
/**
 * Класс, для организации работы консольного ввода каманд от пользователя
 * @author azarkov m.n.
 * @version v.0.1 11.04.2021
 */
public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    /**
     * метод для получения данных с клавиатуры через консоль
     * @param question - Вопрос пользователю
     * @return - возвращает введенное пользователем значение  в формате String
     */
    @Override
    public String askToStr(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    /**
     * метод проверки введенного значени меню на вхождение его в диапазоно допустимых значений
     * @param question - Вопрос пользователю
     * @param range - диапазон допустимых занчений меню
     * @return - возвращаем числовое значение меню
     */
    @Override
    public int askToInt(String question, int[] range) {
        int key = Integer.parseInt(this.askToStr(question));
        boolean exist = false; // по умолчанию считаем, что данные введены с ошибкой
        // провгоним значние через диапазон меню
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
