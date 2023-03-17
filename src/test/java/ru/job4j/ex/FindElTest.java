package ru.job4j.ex;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FindElTest {
    @Test
    public void whenNotElementThenFinish() throws ElementNotFoundException {
        String[] array = new String[] {"aaa", "bbb", "ccc"};
        assertThrows(ElementNotFoundException.class, () -> FindEl.indexOf(array, "ddd"));
    }

    @Test
    public void whenFindElementThenOk() throws ElementNotFoundException {
        String[] array = new String[] {"aaa", "bbb", "ccc"};
        assertThat(1).isEqualTo(FindEl.indexOf(array, "bbb"));
    }
}