package ru.job4j.ex;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CountTest {

    @Test
    public void whenStartGreaterThenFinish() {
        assertThrows(IllegalArgumentException.class, () -> Count.add(10, 2));
    }
}