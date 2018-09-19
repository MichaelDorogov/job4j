package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BoardTest {
    @Test
    public void whenPaintBoardWithWidthThreeAndHeightThreeThenStringWithThreeColsAndThreeRows() {
        Board board = new Board();
        String result = board.paint(3, 3);
        final String line = System.getProperty("line.separator");
        String expected = String.format("x x%s x %sx x%s", line, line, line);
        assertThat(result, is(expected));
    }

    @Test
    public void whenPaintBoardWithWidthFiveAndHeightFourThenStringWithFiveColsAndFourRows() {
        Board board = new Board();
        String result = board.paint(5, 4);
        final String line = System.getProperty("line.separator");
        String expected = String.format("x x x%s x x %sx x x%s x x %s", line, line, line, line);
        assertThat(result, is(expected));
    }

    @Test
    public void whenPaintBoardWithWidthZeroAndHeightZeroThenEmptyString() {
        Board board = new Board();
        String result = board.paint(0, 0);
        assertThat(result, is(""));
    }

    @Test
    public void whenPaintBoardWithWidthPositiveNumberAndHeightZeroThenEmptyString() {
        Board board = new Board();
        String result = board.paint(5, 0);
        assertThat(result, is(""));
    }

    @Test
    public void whenPaintBoardWithWidthNegativeNumberAndHeightZeroThenEmptyString() {
        Board board = new Board();
        String result = board.paint(-5, 0);
        assertThat(result, is(""));
    }

    @Test
    public void whenPaintBoardWithWidthNegativeNumberAndHeightNegativeNumberThenEmptyString() {
        Board board = new Board();
        String result = board.paint(-5, -5);
        assertThat(result, is(""));
    }

    @Test
    public void whenPaintBoardWithWidthZeroAndHeightPositiveNumberThenEmptyString() {
        Board board = new Board();
        String result = board.paint(0, 5);
        final String line = System.getProperty("line.separator");
        String expected = String.format("%s%s%s%s%s", line, line, line, line, line);
        assertThat(result, is(expected));
    }

    @Test
    public void whenPaintBoardWithWidthZeroAndHeightNegativeNumberThenEmptyString() {
        Board board = new Board();
        String result = board.paint(0, -5);
        assertThat(result, is(""));
    }
}