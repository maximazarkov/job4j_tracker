package ru.job4j.tracker.tracker;

import ru.job4j.tracker.Item;

import java.sql.SQLException;
import java.util.List;

public interface Store extends AutoCloseable {
    void init();
    Item add(Item item);
    boolean replace(String id, Item item);
    boolean delete(String id);
    List<Item> findAll() throws SQLException;
    List<Item> findByName(String key);
    Item findById(String id);
}
