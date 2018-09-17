package ru.job4j.max;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.is;


public class MaxTest {
    @Test
    public void whenFirstGreaterThenFirst() {
        Max max = new Max();
        Assert.assertThat(max.max(7, 5), is(7));
    }

    @Test
    public void whenFirstLessThenSecond() {
        Max max = new Max();
        Assert.assertThat(max.max(1, 2), is(2));
    }
}