package ru.job4j.calculator;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.is;

public class CalculatorTest {
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        Assert.assertThat(result, is(expected));
    }

    @Test
    public void whenSubtractOneMinusOneThenZero() {
        Calculator calc = new Calculator();
        calc.subtract(1D, 1D);
        double result = calc.getResult();
        double expected = 0D;
        Assert.assertThat(result, is(expected));
    }

    @Test
    public void whenDivFourOnTwoThenTwo() {
        Calculator calc = new Calculator();
        calc.div(4D, 2D);
        double result = calc.getResult();
        double expected = 2D;
        Assert.assertThat(result, is(expected));
    }

    @Test
    public void whenMultipleTwoOnTwoThenFour() {
        Calculator calc = new Calculator();
        calc.multiple(2D, 2D);
        double result = calc.getResult();
        double expected = 4D;
        Assert.assertThat(result, is(expected));
    }
}