package ru.job4j.tracker.input;

public interface Input {
    /**
     * Метод выводит значение меню в формате String.
     * @param question - вопрос, который выводится пользователю.
     * @return - возвращает введенное пользователем значение  в формате String.
     * @deprecated заменена на String askStr(String question).
     */
    String ask(String question);

    /**
     * Метод выводит значение меню в формате String.
     * @param question - вопрос, который выводится пользователю.
     * @return - возвращает введенное пользователем значение  в формате String.
     */
    String askToStr(String question);

    /**
     * Метод проверки введенного значени меню на вхождение его в диапазоно допустимых значений.
     * @param question - вопрос, который выводится пользователю.
     * @param range - диапазон допустимых занчений меню.
     * @return - возвращаем числовое значение меню.
     */
    int askToInt(String question, int[] range);

    /**
     * Возвращает значение меню в формате int без проверки на вхождение его в диапазон допустимых значений.
     * Рекомендуется применять int askInt(String question, int[] range).
     * @param question - вопрос, который выводится пользователю.
     * @return - возвращаем числовое значение меню.
     */
    int askToInt(String question);
}
