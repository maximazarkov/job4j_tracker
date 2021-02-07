package ru.job4j.tracker.tracker;

import ru.job4j.tracker.Item;

import java.io.IOException;
import java.util.List;

public interface Store extends AutoCloseable {
    void init() throws IOException;
    Item add(Item item);
    boolean replace(String id, Item item);
    boolean delete(String id);
    List<Item> findAll();
    List<Item> findByName(String key);
    Item findById(String id);
}
