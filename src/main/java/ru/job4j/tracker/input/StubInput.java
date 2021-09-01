package ru.job4j.tracker.input;

import ru.job4j.tracker.action.MenuOutException;

/**
 * Класс, для имитации консольного ввода команд от пользователя
 * @author azarkov m.n.
 * @version v.0.1 11.04.2021
 */
public class StubInput implements Input {
    /**
     * Поле для хранения последовательности ответов пользователя.
     * Например, если пользователь хочет выбрать добавление новой заявки, ему в консоли нужно ввести:
     * 1 - выбор пункта меня "добавить новую заявку" (вызывается new CreateAction()).
     * Name - имя заявки
     * desc - описание заявки
     * 0 - выйти из трекера (new ExitAction()).
     * В массив достаточно передать String[]{"1", name, desc, "0"}
     */
    private final String[] value;

    /**
     * Поле считает количество вызовом метода ask.
     * При каждом вызове надо передвинуть указатель на новое число.
     */
    private int position;

    public StubInput(final String[] value) {
        this.value = value;
    }

    /**
     * Давайте рассмотрим, как работает этот метод.
     * У нас есть объект в котором содержатся заранее продуманные ответы.
     * При последовательном вызове метода ask нам надо возвращать соответствующие данные.
     * Как если бы мы симулировали поведение пользователя.
     * Для этого при каждом вызове метода ask мы увеличиваем счетчик и
     * при следующем вызове он вернет нам новое значение.
     *
     * @param question - вопрос от пользователя (выбор пункта меню). Но в версии StubInput он не используется
     *                 т.к. массив ответов заранее определен при инициализации класса и сохранен в value
     * @return - один из заранее определенных ответов пользователей, хранящихся в value[position++].
     */
    @Override
    public String askToStr(String question) {
        return this.value[this.position++];
    }

    /**
     * В текущем релизе данный метод является заглушкой для реализации наследования RuntimeExchange()
     * @param question - ...
     * @param range - ...
     * @return - ...
     */
    public int askToInt(String question, int[] range) {
        int key = Integer.valueOf(this.value[this.position++]);
        boolean exist = false; // по умолчанию считаем, что данные введены с ошибкой
        // прогоним значение через диапазон меню
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
