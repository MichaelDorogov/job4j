package ru.job4j.converter;

/**
 * Корвертор валюты.
 */
public class Converter {
    private static final int EURO_RATE = 70;

    private static final int DOLLAR_RATE = 60;

    /**
     * Конвертируем рубли в евро.
     *
     * @param value рубли.
     * @return Евро.
     */
    public int rubleToEuro(int value) {
        return value / EURO_RATE;
    }

    /**
     * Конвертируем евро в рубли.
     *
     * @param value евро.
     * @return Евро.
     */
    public int euroToRuble(int value) {
        return value * EURO_RATE;
    }

    /**
     * Конвертируем рубли в доллары.
     *
     * @param value рубли.
     * @return Доллары
     */
    public int rubleToDollar(int value) {
        return value / DOLLAR_RATE;
    }

    /**
     * Конвертируем доллары в рубли.
     *
     * @param value рубли.
     * @return Доллары
     */
    public int dollarToRuble(int value) {
        return value * DOLLAR_RATE;
    }
}
