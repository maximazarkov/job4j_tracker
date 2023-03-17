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
//1.Statement: используется для простых случаев без параметров.
// Данный тип применен в методе findAll()
//2...
//3...

public class SqlTracker implements Store {
    private static final Logger LOG = LoggerFactory.getLogger(SqlTracker.class.getName());
    private static final String FINDALL_REQUEST = "select * from item;";
    private static final String ADD_REQUEST = "insert into item(name, descript) values(?, ?);";
    private static final String REPLACE_REQUEST =
            "update item set name=?, descript = ? where id_item = ?;";
    private static final String DELETE_REQUEST = "delete from item where id_item = ?;";
    private static final String FINDBYNAME_REQUEST = "select * from items where name like ?;";
    private static final String FINDBYID_REQUEST = "select * from items where id = ?;";
    private Connection cn;

    public SqlTracker() {
        init();
    }

    public SqlTracker(Connection cn) {
        this.cn = cn;
    }

    @Override
    public void init() {
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
                LOG.debug("Выводим statement");
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
                            String.valueOf(result.getLong("id_item")),
                            result.getString("name"),
                            result.getString("descript")
                    ));
                }
            }
        } catch (Exception e) {
            LOG.debug("Something went wrong", e);
        }
        return findItems;
    }

    @Override
    public Item add(Item item) {
        LOG.debug("Insert data, name: {}, descript: {}", item.getName(), item.getDesc());
        try (PreparedStatement ps = cn.prepareStatement(ADD_REQUEST)) {
            ps.setString(1, item.getName());
            ps.setString(2, item.getDesc());
            try (ResultSet result = ps.executeQuery()) {
                if (result.next()) {
                    LOG.debug("Inserting complete");
                    item.setId(String.valueOf(result.getInt(1)));
                    LOG.debug("Generated id: 9{}", item.getId());
                } else {
                    LOG.debug("Inserting is fallen");
                }
            }
        } catch (Exception e) {
            LOG.debug("Something went wrong", e);
        }
        return item;
    }

    @Override
    public boolean replace(String id, Item item) {
        boolean result = false;
        LOG.debug("Replace data. id: {}, name: {}, descript: {}",
                id,  item.getName(), item.getDesc());
        try (PreparedStatement ps = cn.prepareStatement(REPLACE_REQUEST)) {
            ps.setString(1, item.getName());
            ps.setString(2, item.getDesc());
            ps.setInt(3, Integer.parseInt(id));
            result = ps.executeUpdate() > 0;
            LOG.debug("Replace complete. Result: {}", result);
        } catch (Exception e) {
            LOG.debug("Something went wrong", e);
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        LOG.debug("Delete data. id: {}", id);
        try (PreparedStatement ps = cn.prepareStatement(DELETE_REQUEST)) {
            ps.setInt(1, Integer.parseInt(id));
            result = ps.executeUpdate() > 0;
            LOG.debug("Delete complete. Result: {}", result);
        } catch (Exception e) {
            LOG.debug("Something went wrong", e);
        }
        return result;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> findItems = new ArrayList<>();
        LOG.debug("Find by name {}", key);
        try (PreparedStatement ps = cn.prepareStatement(FINDBYNAME_REQUEST)) {
            ps.setString(1, "%" + key + "%");
            try (ResultSet result = ps.executeQuery()) {
                LOG.debug("Выводим statement");
                while (result.next()) {
                    findItems.add(new Item(
                            String.valueOf(result.getLong("id_item")),
                            result.getString("name"),
                            result.getString("descript")
                    ));
                }
            }
        } catch (Exception e) {
            LOG.debug("Something went wrong", e);
        }
        return findItems;
    }

    @Override
    public Item findById(String id) {
        LOG.debug("Find by id {}", id);
        Item result = null;
        try (PreparedStatement ps = cn.prepareStatement(FINDBYID_REQUEST)) {
            ps.setInt(1, Integer.parseInt(id));
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    result = new Item(
                            String.valueOf(rs.getLong("id_item")),
                            rs.getString("name"),
                            rs.getString("descript")
                    );
                }
            }
            LOG.debug("Selecting complete. Found {}", result);
        } catch (Exception e) {
            LOG.error("Something went wrong", e);
        }
        LOG.debug("Found {}", result);
        return result;
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }
}
