package ru.job4j.tracker;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;
import ru.job4j.tracker.action.*;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.StubInput;
import ru.job4j.tracker.input.ValidateInput;
import ru.job4j.tracker.tracker.MemTracker;
import ru.job4j.tracker.tracker.Store;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.format.DateTimeFormatter;
import java.util.function.Consumer;

public class StartUITest {

    private final static String LS = System.lineSeparator();
    private final static String MENU = new StringBuilder()
            .append("1. Add Item").append(LS)
            .append("2. Edit Item").append(LS)
            .append("3. Delete Item").append(LS)
            .append("4. Show all Items").append(LS)
            .append("5. Find action by Id").append(LS)
            .append("6. Find Items By Name").append(LS)
            .append("0. Exit program").toString();
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final Consumer<String> output = new Consumer<>() {
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

    private final UserAction[] actions = {
            new ExitAction(),
            new CreateAction(),
            new ReplaceAction(),
            new DeleteAction(),
            new FindAllAction(),
            new FindByIdAction(),
            new FindByNameAction()
    };

    @BeforeEach
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @Test
    public void whenShowAllItemsMem() throws Exception {
        Store tracker = new MemTracker();
        Item item = new Item("a", "a");
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
        assertThat(sb.toString()).isEqualTo(this.output.toString());
    }

    @Test
    public void whenFindItemsById() throws Exception {
        Store tracker = new MemTracker();
        Item item = new Item("a", "a");
        tracker.add(item);
        String idItem = item.getId();
        Input validate = new ValidateInput(
                new StubInput(new String[]{"5", idItem, "0"})
        );
        new StartUI().init(validate, tracker, actions);
        StringBuilder sb = new StringBuilder();
        sb.append(MENU).append(LS);
        sb.append("---------------- Search Item by Id ---------------").append(LS);
        sb.append(String.format("Item{id='%S', name='%s', desc='%s', created=%s}",
                        item.getId(),
                        item.getName(),
                        item.getDesc(),
                        item.getLocalDataTime().format(FORMATTER))).append(LS);
        sb.append("---------------------------------------------------").append(LS);
        sb.append(MENU).append(LS);
        assertThat(sb.toString()).isEqualTo(new String(out.toByteArray()));
    }

    @Test
    public void whenFindItemsByName() throws Exception {
        Store tracker = new MemTracker();
        Item item = new Item("a", "a");
        tracker.add(item);
        Input validate = new ValidateInput(
                new StubInput(new String[]{"6", "a", "0"})
        );
        new StartUI().init(validate, tracker, actions);
        StringBuilder sb = new StringBuilder();
        sb.append(MENU).append(LS);
        sb.append("-------------- Find Item by Name --------------").append(LS);
        sb.append(String.format("Item{id='%S', name='%s', desc='%s', created=%s}",
                item.getId(),
                item.getName(),
                item.getDesc(),
                item.getLocalDataTime().format(FORMATTER))).append(LS);
        sb.append("---------------------------------------------------").append(LS);
        sb.append(MENU).append(LS);
        assertThat(sb.toString()).isEqualTo(this.output.toString());
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() throws Exception {
        Store tracker = new MemTracker();
        Input validate = new ValidateInput(
                new StubInput(new String[]{"1",  "test name", "desc", "0"})
        );
        new StartUI().init(validate, tracker, actions);
        StringBuilder sb = new StringBuilder();
        sb.append(MENU).append(LS);
        assertThat("test name").isEqualTo(tracker.findAll().get(0).getName());
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() throws Exception {
        Store tracker = new MemTracker();
        Item item = new Item("test name", "desc");
        tracker.add(item);
        Input validate = new ValidateInput(
                new StubInput(
                        new String[]{"2", item.getId(), "test replace", "заменили заявку", "0"})
        );
        new StartUI().init(validate, tracker, actions);
        StringBuilder sb = new StringBuilder();
        sb.append(MENU).append(LS);
        assertThat("test replace").isEqualTo(tracker.findById(item.getId()).getName());
    }

    @Test
    public void whenDeleteThenNull() throws Exception {
        Store tracker = new MemTracker();
        Item item = new Item("test name", "desc");
        tracker.add(item);
        Input validate = new ValidateInput(
                new StubInput(new String[]{"3", item.getId(), "0"})
        );
        new StartUI().init(validate, tracker, actions);
        StringBuilder sb = new StringBuilder();
        sb.append(MENU).append(LS);
        Item delItem = null;
        assertThat(delItem).isEqualTo(tracker.findById(item.getId()));
    }
}
