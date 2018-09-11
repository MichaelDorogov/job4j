package ru.job4j.calculate;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.is;

/**
 * Test.
 *
 * @author Michael Dorogov (mimeddo@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class CalculateTest {
    /**
     * Test echo.
     */
    @Test
    public void whenTakeNameThenTreeEchoPlusName() {
        String input = "Petr Arsentev";
        String expect = "Echo, echo, echo : Petr Arsentev";
        Calculate calc = new Calculate();
        String result = calc.echo(input);
        Assert.assertThat(result, is(expect));
    }
}