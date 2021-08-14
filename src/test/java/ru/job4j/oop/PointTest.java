package ru.job4j.oop;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;

public class PointTest {

    @Test
    public void testDistance3d() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(4, 0, 0);
        double ab3d = a.distance3d(b);
        double rsl = 4;
        assertThat(rsl, closeTo(ab3d, 0.001));
    }
}