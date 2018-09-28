package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MatrixTest {
    @Test
    public void whenSize0ThenEmptyArray() {
        Matrix matrix = new Matrix();
        int[][] table = matrix.multiple(0);
        int[][] expect = {};
        assertThat(table, is(expect));
    }

    @Test(expected = NegativeArraySizeException.class)
    public void whenSizeBelow0ThenEmptyArray() {
        Matrix matrix = new Matrix();
        matrix.multiple(-1);
    }

    @Test
    public void when2on2() {
        Matrix matrix = new Matrix();
        int[][] table = matrix.multiple(2);
        int[][] expect = {
                {1, 2},
                {2, 4}
        };
        assertThat(table, is(expect));
    }
}