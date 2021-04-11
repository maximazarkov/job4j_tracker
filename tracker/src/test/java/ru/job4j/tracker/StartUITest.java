package ru.job4j.tracker;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.tracker.action.*;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.StubInput;
import ru.job4j.tracker.input.ValidateInput;
import ru.job4j.tracker.tracker.MemTracker;
import ru.job4j.tracker.tracker.Store;

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

    private final static String LS = System.lineSeparator();
    private final static String MENU = new StringBuilder()
        .append("1. Add Item").append(LS)
        .append("2. Edit Item").append(LS)
        .append("3. Delete Item").append(LS)
        .append("4. Show all Items").append(LS)
        .append("5. Find action by Id").append(LS)
        .append("6. Find Items By Name").append(LS)
        .append("0. Exit program").toString();

    private final UserAction[] actions = {
            new ExitAction(),
            new CreateAction(),
            new ReplaceAction(),
            new DeleteAction(),
            new FindAllAction(),
            new FindByIdAction(),
            new FindByNameAction()
    };

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
    public void whenShowAllItemsMem() throws Exception {
        Store tracker = new MemTracker();     // создаём Tracker
        Item item = new Item("a", "a", 123L);
        tracker.add(item);
        /*вызовем FindAllAction() и выйдем из программы*/
        Input validate = new ValidateInput(
                new StubInput(new String[]{"4", "0"})
        );
        new StartUI().init(validate, tracker, actions);
        StringBuilder sb = new StringBuilder();
        sb.append(MENU).append(LS);
        sb.append("------------ Show all Items --------------").append(LS);
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
    public void whenFindItemsById() throws Exception {
        Store tracker = new MemTracker();
        Item item = new Item("a", "a", 123L);
        tracker.add(item);
        String idItem = item.getId();
        Input validate = new ValidateInput(
                new StubInput(new String[]{"5", idItem, "0"})
        );
        new StartUI().init(validate, tracker, actions);
        StringBuilder sb = new StringBuilder();
        sb.append(MENU).append(LS);
        sb.append("---------------- Search Item by Id ---------------").append(LS);
        sb.append(String.format("Item{id='%S', name='%s', desc='%s', time=%s}",
                        item.getId(),
                        item.getName(),
                        item.getDesc(),
                        item.getTime())).append(LS);
        sb.append("---------------------------------------------------").append(LS);
        sb.append(MENU).append(LS);
        // TODO .... необходимо добиться работы исполняемых методов, воторые возвращают текст ответов на команду,
        // соответственно откорректировать и раскомментарий текст ниже
        assertThat(new String(out.toByteArray()), is(sb.toString()));
    }

    @Test
    public void whenFindItemsByName() throws Exception {
        Store tracker = new MemTracker();
        Item item = new Item("a", "a", 123L);
        tracker.add(item);
//        Input input = new StubInput(new String[]{"6", "a", "0"});
        Input validate = new ValidateInput(
                new StubInput(new String[]{"6", "a", "0"})
        );
        new StartUI().init(validate, tracker, actions);
//        new StartUI(input, tracker, output);
        StringBuilder sb = new StringBuilder();
        sb.append(MENU).append(LS);
        // TODO .... необходимо добиться работы исполняемых методов, воторые возвращают текст ответов на команду,
        // соответственно откорректировать и раскомментарий текст ниже
        sb.append("-------------- Find Item by Name --------------").append(LS);
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
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() throws Exception {
        Store tracker = new MemTracker();     // создаём Tracker
//        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
//        new StartUI(input, tracker, output);     //   создаём StartUI и вызываем метод init()
        Input validate = new ValidateInput(
                new StubInput(new String[]{"1",  "test name", "desc", "0"})
        );
        new StartUI().init(validate, tracker, actions);
        StringBuilder sb = new StringBuilder();
        sb.append(MENU).append(LS);
        // TODO .... необходимо добиться работы исполняемых методов, воторые возвращают текст ответов на команду,
        // соответственно откорректировать и раскомментарий текст ниже
        assertThat(tracker.findAll().get(0).getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() throws Exception {
        // создаём Tracker
        Store tracker = new MemTracker();
        //Напрямую добавляем заявку
        Item item = new Item("test name", "desc", System.currentTimeMillis());
        tracker.add(item);
//        //создаём StubInput с последовательностью действий(производим замену заявки)
//        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
//        // создаём StartUI и вызываем метод init()
//        new StartUI(input, tracker, output);
        Input validate = new ValidateInput(
                new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "0"})
        );
        new StartUI().init(validate, tracker, actions);
        StringBuilder sb = new StringBuilder();
        sb.append(MENU).append(LS);
        // TODO .... необходимо добиться работы исполняемых методов, воторые возвращают текст ответов на команду,
        // соответственно откорректировать и раскомментарий текст ниже
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenDeleteThenNull() throws Exception {
        // создаём Tracker
        Store tracker = new MemTracker();
        //Напрямую добавляем заявку
        Item item = new Item("test name", "desc", System.currentTimeMillis());
        tracker.add(item);
//        //создаём StubInput с последовательностью действий(производим замену заявки)
//        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
//        // создаём StartUI и вызываем метод init()
//        new StartUI(input, tracker, output);
        Input validate = new ValidateInput(
                new StubInput(new String[]{"3", item.getId(), "0"})
        );
        new StartUI().init(validate, tracker, actions);
        StringBuilder sb = new StringBuilder();
        sb.append(MENU).append(LS);
        // TODO .... необходимо добиться работы исполняемых методов, воторые возвращают текст ответов на команду,
        // соответственно откорректировать и раскомментарий текст ниже
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        Item delItem = null;
        assertThat(tracker.findById(item.getId()), is(delItem));
    }


}
