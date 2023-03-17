package ru.job4j.tracker;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;
import ru.job4j.tracker.input.StubInput;
import ru.job4j.tracker.input.ValidateInput;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class ValidateInputTest {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;

    @BeforeEach
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @AfterEach
    public void loadSys() {
        System.setOut(this.out);
    }

    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"invalid", "1"})
        );
        input.askToInt("Enter", new int[] {1});
        assertThat(this.mem.toString())
                .isEqualTo(String.format("Please enter validate data again%n"));
    }

    @Test
    public void whenInvalidInputKey() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"-1", "1"})
        );
        input.askToInt("Enter", new int[] {1});
        assertThat(this.mem.toString())
                .isEqualTo(String.format("Please select key from menu.%n"));
    }
}
