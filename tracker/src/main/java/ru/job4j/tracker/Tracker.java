package ru.job4j.tracker;

import java.util.*;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    private final List<Item> items = new ArrayList<>(); // массив для хранение заявок.
	private static final Random RN = new Random(); // ссылка на объект, для генерации случайных чисел.
	
    /**
     * Метод реализаущий добавление заявки в хранилище.
	 * @param item новая заявка
	 */
    public void add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
	}

	 /**
     * Метод реализаущий редактирование заявок в хранилище по уникальному ключу.
	 * @param id уникальный ключ заяки.
     * @param item новая заявка.
     */
	public boolean replace(String id, Item item) {
		boolean result = false;
        System.out.println(id);
        int index = 0;
		for (Item it : items) {
			if (it != null && it.getId().equals(id)) {
				item.setId(id);
				items.set(index, item);
				result = true;
				break;
			}
			index++;
		}
		return result;
	}

	/**
     * Метод реализаущий удаление заявок в хранилище.
	 * @param id уникальный ключ заяки.
     */
	public boolean delete(String id) {
		boolean result = false;
		int index = 0;
		for (Item it : items) {
			if (it != null && it.getId().equals(id)) {
				items.remove(index);
				result = true;
				break;
			}
			index++;
		}
		return result;
	}
	
	/**
     * Метод реализаущий получение списка всех заявок из хранилища.
	 * @return - all elements by Tracker
     */
    public ArrayList<Item> findAll() {
        ArrayList<Item>  findItems = new ArrayList<>();
        Iterator<Item> it = items.iterator();
        findItems.addAll(items);
        return findItems;
    }

	/**
     * Метод реализаущий получение списка по имени из хранилища.
	 * @param key - ...
     */
	public ArrayList<Item> findByName(String key) {
		ArrayList<Item> find = new ArrayList<>();
		Iterator<Item> it = items.iterator();
		while (it.hasNext()) {
			Item i = it.next();
			if (i.getName().equals(key)) {
				find.add(i);
			}
		}
		return find;
	}


	/**
     * Метод реализаущий получение заявки по id из хранилища.
	 * @param id - уникальный ключ заявки.
     */
	public Item findById(String id) {
		Item result = null;
		for (Item item : items) {
			if (item != null && item.getId().equals(id)) {
				result = item;
				break;
			}
		}
		return result;
	}
	
    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
		return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
}