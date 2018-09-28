package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CheckTest {
    @Test(expected = NullPointerException.class)
    public void whenDataNullThenNPE() {
        Check check = new Check();
        check.mono(null);
    }

    @Test
    public void whenDataDoesNotContainsItemsThenFalse() {
        Check check = new Check();
        boolean result = check.mono(new boolean[0]);
        assertThat(result, is(false));
    }

    @Test
    public void whenDataContainsOneItemThenTrue() {
        Check check = new Check();
        boolean result = check.mono(new boolean[]{true});
        assertThat(result, is(true));
    }

    @Test
    public void whenDataMonoByTrueThenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[]{true, true, true};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    @Test
    public void whenDataNotMonoByTrueThenFalse() {
        Check check = new Check();
        boolean[] input = new boolean[]{true, false, true};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }
}