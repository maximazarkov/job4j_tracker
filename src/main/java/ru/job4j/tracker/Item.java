package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
*@author Azarkov Maxim
*@version $Id$.
*@since 0.1
*/
public class Item {
	private String id;
	private String name;
	private String desc;
	private final LocalDateTime created = LocalDateTime.now();
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");

	/**
	 * метод определяет текущее время
	 * @return - текущее время
	 */
	public LocalDateTime getLocalDataTime() {
		return created;
	}

	/**
	 * Конструктор. Создает элемент типа Item - заявка.
	 * @param id - id заявки
	 * @param name - название заявки
	 * @param desc - описание заявки
	 * @since 0.3 16.08.2021 TrackerUI
	 */
	public Item(String id, String name, String desc) {
		this.id = id;
		this.name = name;
		this.desc = desc;
	}

	/**
	 * Конструктор. Создает элемент типа Item - заявка.
	 * @param name - название заявки
	 * @param desc - описание заявки
	 * @since 0.3 16.08.2021 TrackerUI
	 */
	public Item(String name, String desc) {
		this.name = name;
		this.desc = desc;
	}

	/**
	 * setId - принимает значение уникального ключа заявки. Уникальный ключ заявки - id элемента массива Item.
	 * Генерируется с помощью hash-функции.
	 * @param id - значение уникального ключа заявки типа String.
	 * @since 0.1.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	*getId - возвращает уникального ключа заявки.
	*@return значение уникального ключа заявки
	*@since 0.1
	*/
	public String getId() {
		return this.id;
	}
	
	/**
	*setName - принимает название заявки.
	*@param name - значение названия заявки типа String.
	*@since 0.1
	*/
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	*getId - возвращает названия заявки.
	*@return значение названия заявки типа String.
	*@since 0.1.
	*/
	public String getName() {
		return this.name;
	}

	/**
	*setDesc - принимает описание заявки.
	*@param desc - Значение описания заявки типа String.
	*@since 0.1.
	*/
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	/**
	*getDesc - возвращает описание заявки.
	*@return значение описания заявки типа String.
	*@since 0.1.
	*/
	public String getDesc() {
		return this.desc;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Item item = (Item) o;
		return created == item.created && Objects.equals(id, item.id) && Objects.equals(name, item.name) && Objects.equals(desc, item.desc);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, desc, created);
	}

	@Override
	public String toString() {
		return "Item{"
				+ "id='" + id
				+ "', name='" + name
				+ '\'' + ", desc='" + desc
				+ '\'' + ", created=" + created.format(FORMATTER) + '}';
	}

}