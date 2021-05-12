package ru.job4j.tracker.tracker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.tracker.Item;

import java.io.InputStream;
import java.sql.*;
import java.util.*;

/**
 * @author Azarkov Maxim
 * @version $Id$
 * @since 12.04.2021 v0.1
 */
//Для использования SQL запросов существуют 3 типа объектов:
//1.Statement: используется для простых случаев без параметров. Данный тип применен в методе findAll()
//2...
//3...

public class SqlTracker implements Store {
//    private final List<Item> items = new ArrayList<>(); // массив для хранение заявок.
//    private static final Random RN = new Random(); // ссылка на объект, для генерации случайных чисел.
    private Connection cn;

    private static final Logger LOG = LoggerFactory.getLogger(SqlTracker.class.getName());
    private static final String FINDALL_REQUEST = "select * from items;";
    private static final String ADD_REQUEST = "insert into items(name) values(?);";

    @Override
    public void init() {
        LOG.info("Init...");
        try (InputStream in = SqlTracker.
                class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            assert in != null;
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public List<Item> findAll() {
        List<Item> findItems = new ArrayList<>();

        try (Statement statement = cn.createStatement()) {
            //Выполним запрос
            try (ResultSet result = statement.executeQuery(FINDALL_REQUEST)) {
                //result это указатель на первую строку с выборки
                //чтобы вывести данные мы будем использовать
                //метод next() , с помощью которого переходим к следующему элементу
//        System.out.println("Выводим statement");
//        while (result.next()) {
//            System.out.println("Номер в выборке #" + result.getRow()
//                    + "\t Номер в базе #" + result.getInt("id")
//                    + "\t" + result.getString("username"));
//        }
//        // Вставить запись
//        statement.executeUpdate(
//                "INSERT INTO users(username) values('name')");
//        //Обновить запись
//        statement.executeUpdate(
//                "UPDATE users SET username = 'admin' where id = 1");
                while (result.next()) {
                    findItems.add(new Item(
//                            String.valueOf(result.getInt("id_item")),
                            result.getString("name"),
                            result.getString("descript"),
                            result.getLong("time")
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return findItems;
    }

    @Override
    public Item add(Item item) {
        LOG.debug("Insert data, name: {}", item.getName());
        try (PreparedStatement ps = cn.prepareStatement(ADD_REQUEST)) {
            ps.setString(1, item.getName());
            try (ResultSet result = ps.executeQuery()) {
                if (result.next()) {
                    LOG.debug("Inserting complete");
                    item.setId(String.valueOf(result.getInt(1)));
                    LOG.debug("Generated id: {}", item.getId());
                } else {
                    LOG.debug("Inserting is fallen");
                }
            }
        } catch (Exception e) {
            LOG.debug("Something went wrong", e);
        }
        return item;
//        item.setId(this.generateId());
//        this.items.add(item);
//        return item;
    }

    @Override
    public boolean replace(String id, Item item) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }



    @Override
    public List<Item> findByName(String key) {
        return null;
    }

    @Override
    public Item findById(String id) {
        return null;
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }
}
