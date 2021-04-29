package ru.job4j.tracker.tracker;

import ru.job4j.tracker.Item;
import java.util.*;

/**
 * @author Azarkov Maxim
 * @version $Id$
 * @since 10.02.2021 v0.2
 */
public class MemTracker implements Store {
    private final List<Item> items = new ArrayList<>(); // массив для хранение заявок.
	private static final Random RN = new Random(); // ссылка на объект, для генерации случайных чисел.

	@Override
	public void init() {

	}

	/**
	 * Метод реализующий добавление заявки
	 * @param item - принимает обект, сохраняет его в памяти добавляя новые параметры и
	 *             возвращзает этот же объект но с присвоенным id.
	 * @return
	 */
	@Override
	public Item add(Item item) {
		item.setId(this.generateId());
		this.items.add(item);
		return item;
	}

	 /**
     * Метод реализаущий редактирование заявок в хранилище по уникальному ключу.
	 * @param id уникальный ключ заяки.
     * @param item новая заявка.
     */
	 @Override
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
	@Override
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
	@Override
    public List<Item> findAll() {
        List<Item>  findItems = new ArrayList<>();
        Iterator<Item> it = items.iterator();
        findItems.addAll(items);
        return findItems;
    }

	/**
     * Метод реализаущий получение списка по имени из хранилища.
	 * @param key - имя заявки, которую необходимо найти.
     */
	@Override
	public List<Item> findByName(String key) {
		List<Item> find = new ArrayList<>();
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
	@Override
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

	/**
	 * Данный класс при работе с памятью не требуется, по этому он не реализован. Наследует AutoClosable
	 * @throws Exception
	 */
	@Override
	public void close() throws Exception {

	}
}