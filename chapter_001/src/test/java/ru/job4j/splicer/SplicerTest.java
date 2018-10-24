package ru.job4j.splicer;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class SplicerTest {
    @Test
    public void whenFirstArrayEmptyThenSecondArray() {
        Splicer splicer = new Splicer();
        int[] expected = {0, 3, 4, 6, 6, 7, 8};
        int[] result = splicer.splice(new int[0], expected);
        Assert.assertThat(expected, is(result));
    }

    @Test
    public void whenSecondArrayEmptyThenFirstArray() {
        Splicer splicer = new Splicer();
        int[] expected = {0, 3, 4, 6, 6, 7, 8};
        int[] result = splicer.splice(new int[0], expected);
        Assert.assertThat(expected, is(result));
    }

    @Test
    public void whenBothArrayEmptyThenEmptyArray() {
        Splicer splicer = new Splicer();
        int[] empty = {};
        int[] result = splicer.splice(empty, empty);
        Assert.assertThat(empty, is(result));
    }

    @Test
    public void whenSpliceTwoSortedArraysThenSplicedSortedArray() {
        Splicer splicer = new Splicer();
        int[] first = {1, 3, 5, 7, 9};
        int[] second = {2, 4, 6, 8};
        int[] result = splicer.splice(first, second);
        Assert.assertThat(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, is(result));
    }
}