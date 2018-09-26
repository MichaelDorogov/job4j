package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.is;

/**
 * @author Michael Dorogov (mimeddo@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class PointTest {
    @Test(expected = NullPointerException.class)
    public void whenPointNullWhenNullPointerException() {
        Point point = new Point(3, 4);
        point.distanceTo(null);
    }

    @Test
    public void whenFirstPointCoordinatesIs30SecondPointCoordinates04ThenDistance5() {
        Point point1 = new Point(3, 0);
        Point point2 = new Point(0, 4);
        Assert.assertThat(point1.distanceTo(point2), is(5d));
    }

}