package ru.job4j.oop;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class PointTest {

    @Test
    public void testDistance3d() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(4, 0, 0);
        double ab3d = a.distance3d(b);
        double rsl = 4;
        assertThat(rsl).isCloseTo((Double) ab3d, Percentage.withPercentage(0.001));
    }
}