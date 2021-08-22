package ru.job4j.ex;

import org.junit.Assert;
import org.junit.Test;

public class FindElTest {
    @Test (expected = ElementNotFoundException.class)
    public void whenNotElementThenFinish() throws ElementNotFoundException {
        String[] array = new String[] {"aaa", "bbb", "ccc"};
        FindEl.indexOf(array, "ddd");
    }

    @Test
    public void whenFindElementThenOk() throws ElementNotFoundException {
        String[] array = new String[] {"aaa", "bbb", "ccc"};
        Assert.assertEquals(1, FindEl.indexOf(array, "bbb"));
    }
}