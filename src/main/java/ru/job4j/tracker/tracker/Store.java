package ru.job4j.tracker.tracker;

import ru.job4j.tracker.Item;

import java.sql.SQLException;
import java.util.List;

/**
 * Интерфейс для описания функциональности системы работы со статьями замечаний.
 * Предназначена для возможно реализовать объекты для подключения к разным системам
 * ввода/вывода и хранения статей без изменения основного кода программы.
 */
public interface Store extends AutoCloseable {
    /**
     * Метод необходим для настройки модулей, реализующих интерфейс Store,
     * при необходимости. Например, предварительная настройка при подключении
     * базы данных.
     */
    default void init() {

    }

    /**
     * Метод добавляет объект Item.
     * @param item объект статьи для добавления.
     * @return возвращает объект статьи для дальнейшего использования.
     */
    Item add(Item item);

    /**
     * Метод для замены (обновления) статьи.
     * @param id id статьи
     * @param item статья
     * @return возвращает true, если данные удалось заменить; false - в случае неудачи
     * @throws SQLException возможны исключения при работе с внешними системами.
     */
    boolean replace(String id, Item item) throws SQLException;

    boolean delete(String id);

    List<Item> findAll() throws SQLException;

    List<Item> findByName(String key);

    Item findById(String id);
}
