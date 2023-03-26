package ru.job4j.tracker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import ru.job4j.tracker.tracker.MemTracker;
import java.util.List;

/**
*  добавление заявок - public Item add(Item item);
*  редактирование заявок - public boolean replace(String id, Item item);
*  удаление заявок - public boolean delete(String id);
*  получение списка всех заявок - public Item[] findAll();
*  получение списка по имени - public Item[] findByName(String key);
*  получение заявки по id - public Item findById(String id);
*/

public class TrackerTest {

	private MemTracker tracker;

	@BeforeEach
	public void loadOutputBefore() {
		tracker = new MemTracker();
	}

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Item item = new Item("test1", "testDescription");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(item.getName()).isEqualTo(result.getName());
    }

	@Test
	public void whenReplaceNameThenReturnNewName() {
		Item previous = new Item("test1", "testDescription");
		tracker.add(previous);
		Item next = new Item("test2", "testDescription2");
		tracker.replace(previous.getId(), next);
		assertThat("test2").isEqualTo(tracker.findById(previous.getId()).getName());
	}

	@Test
	public void whenDelete2ndItemNameThenReturn1stAnd3rdItem() {
		Item item = new Item("test1", "testDescription");
		tracker.add(item);
		item = new Item("test2", "testDescription2");
		tracker.add(item);
		String idForDelete = item.getId();
		item = new Item("test3", "testDescription3");
		tracker.add(item);
		assertThat(tracker.delete(idForDelete)).isTrue();
	}

	@Test
	public void whenFindAllThenAllItems() {
		Item item = new Item("test1", "testDescription");
		tracker.add(item);
		item = new Item("test2", "testDescription2");
		tracker.add(item);
		item = new Item("test3", "testDescription3");
		tracker.add(item);
		List<Item> result  = tracker.findAll();
		assertThat(result).isEqualTo(tracker.findAll());
	}

	@Test
	public void whenFindByNameThenReturn2Items() {
		Item item = new Item("test1", "testDescription");
		tracker.add(item);
		item = new Item("test2", "testDescription2");
		tracker.add(item);
		item = new Item("test1", "testDescription3");
		tracker.add(item);
		List<Item> allItem  = tracker.findByName("test1");
		assertThat(allItem).isEqualTo(tracker.findByName("test1"));
	}

	@Test
	public void whenFindByIdThenReturn2Items() {
		Item item = new Item("test1", "testDescription");
		tracker.add(item);
		item = new Item("test2", "testDescription2");
		tracker.add(item);
		String idForFindId = item.getId();
		item = new Item("test1", "testDescription3");
		tracker.add(item);
		Item result  = tracker.findById(idForFindId);
		assertThat(result).isEqualTo(tracker.findById(idForFindId));
	}
}