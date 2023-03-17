package ru.job4j.ex;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactTest {

    @Test
    public void whenNIsNegativeThenFinish() {
        assertThrows(IllegalArgumentException.class, () -> Fact.calc(-1));
    }
}