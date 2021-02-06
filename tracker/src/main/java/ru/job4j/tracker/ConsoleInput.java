package ru.job4j.tracker;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String ask(String quastion) {
        System.out.print(quastion);
        return scanner.nextLine();
    }

    /**
     * метод проверки введенного значени меню на вхождение его в диапазоно допустимых значений
     * @param quastion - ответ пользователя
     * @param range - диапазон допустимых занчений меню
     * @return - возвращаем числовое значение меню
     */
    @Override
    public int ask(String quastion, int[] range) {
        int key = Integer.valueOf(this.ask(quastion));
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
}
