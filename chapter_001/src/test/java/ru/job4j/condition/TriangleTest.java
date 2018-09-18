package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

public class TriangleTest {
    @Test
    public void whenAreaSetThreePointsThenTriangleArea() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        Point c = new Point(2, 0);
        Triangle triangle = new Triangle(a, b, c);
        double result = triangle.area();
        double expected = 2D;
        assertThat(result, closeTo(expected, 0.1));
    }

    @Test
    public void whenExistsFalseThenAreaMinus1() {
        Point a = new Point(-2, 0);
        Point b = new Point(0, 0);
        Point c = new Point(2, 0);
        Triangle triangle = new Triangle(a, b, c);
        double result = triangle.area();
        double expected = -1D;
        assertThat(result, closeTo(expected, 0.1));
    }

    @Test
    public void whenTwoSideLesserThanOneThenFalse() {
        Triangle t = new Triangle();
        assertFalse(t.exist(6.0, 1.0, 4.0));
        assertFalse(t.exist(1.0, 4.0, 6.0));
        assertFalse(t.exist(4.0, 6.0, 1.0));
    }

    @Test
    public void whenTwoSideEqualsOneThenFalse() {
        Triangle t = new Triangle();
        assertFalse(t.exist(6.0, 2.0, 4.0));
        assertFalse(t.exist(2.0, 4.0, 6.0));
        assertFalse(t.exist(4.0, 6.0, 2.0));
    }
}