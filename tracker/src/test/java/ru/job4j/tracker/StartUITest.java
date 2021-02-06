package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Consumer;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {


    private final ByteArrayOutputStream out = new ByteArrayOutputStream();  // буфер для результата
    private final Consumer<String> output = new Consumer<String>() {        //...
        // сохраним дефолный вывод на консоль, чтобы потом к нему вернуться
        private final PrintStream stdout = new PrintStream(out);
        @Override
        public void accept(String s) {
            stdout.println(s);
        }

        @Override
        public String toString() {
            return out.toString();
        }
    };

    public final static String LS = System.lineSeparator();
    public final static String MENU = new StringBuilder()
        .append("0. Add new Item").append(LS)
        .append("1. Show all items").append(LS)
        .append("2. Edit item").append(LS)
        .append("3. Delete item").append(LS)
        .append("4. Find item by Id").append(LS)
        .append("5. Find items by name").append(LS)
        .append("6. Exit Program").toString();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }
//
//    @After
//    public void backOutput() {
//        System.setOut(this.stdout);
//    }

    @Test
    public void whenShowAllItems() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Item item = new Item("a", "a", 123L);
        tracker.add(item);
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker, output);
        StringBuilder sb = new StringBuilder();
        sb.append(MENU).append(LS);
        sb.append("------------ Отображение всех заявки --------------").append(LS);
        sb.append(String.format("Name: %s| Desc: %s| Id: %s",
                item.getName(),
                item.getDesc(),
                item.getId())).append(LS);
        sb.append("---------------------------------------------------").append(LS);
        sb.append(MENU).append(LS);
        //assertThat(new String(out.toByteArray()), is(sb.toString()));
        assertThat(this.output.toString(), is(sb.toString()));
    }

    @Test
    public void whenFindItemsById() {
        Tracker tracker = new Tracker();
        Item item = new Item("a", "a", 123L);
        tracker.add(item);
//      new StartUI(new ValidateInput(new ConsoleInput()), new Tracker(), System.out::println).init();
        new StartUI(new StubInput(new String[]{"4", item.getId(), "6"}), tracker, output);
        //assertThat(new String(out.toByteArray()), is(sb.toString()));
        String sb = MENU + LS
                + "---------------- Поиск заявки по Id ---------------" + LS
                + String.format("Item{id='%S', name='%s', desc='%s', time=%s}",
                        item.getId(),
                        item.getName(),
                        item.getDesc(),
                        item.getTime())
                + LS
                + "---------------------------------------------------" + LS
                + MENU + LS;
        assertThat(this.output.toString(), is(sb));
    }

    @Test
    public void whenFindItemsByName() {
        Tracker tracker = new Tracker();
        Item item = new Item("a", "a", 123L);
        tracker.add(item);
        Input input = new StubInput(new String[]{"5", "a", "6"});
        new StartUI(input, tracker, output);
        StringBuilder sb = new StringBuilder();
        sb.append(MENU).append(LS);
        sb.append("-------------- Поиск заявки по имени --------------").append(LS);
        sb.append(String.format("Item{id='%S', name='%s', desc='%s', time=%s}",
                item.getId(),
                item.getName(),
                item.getDesc(),
                item.getTime())).append(LS);
        sb.append("---------------------------------------------------").append(LS);
        sb.append(MENU).append(LS);
        //assertThat(new String(out.toByteArray()), is(sb.toString()));
        assertThat(this.output.toString(), is(sb.toString()));
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker, output);     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll().get(0).getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = new Item("test name", "desc", System.currentTimeMillis());
        tracker.add(item);
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker, output);
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenDeleteThenNull() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = new Item("test name", "desc", System.currentTimeMillis());
        tracker.add(item);
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker, output);
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        Item delItem = null;
        assertThat(tracker.findById(item.getId()), is(delItem));
    }


}
