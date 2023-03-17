package ru.job4j.oop;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class TriangleTest {
    @Test
    public void whenExistIsTrueThenOk() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(0, 4);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        assertThat(rsl).isCloseTo(8, Percentage.withPercentage(0.001));
    }

    @Test
    public void whenExistFalseThenFailure() {
        Point a = new Point(0, 0);
        Point b = new Point(1, 1);
        Point c = new Point(2, 2);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        assertThat(rsl).isCloseTo(-1, Percentage.withPercentage(0.001));
    }
}