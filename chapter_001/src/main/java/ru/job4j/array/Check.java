package ru.job4j.array;

public class Check {
    public boolean mono(boolean[] data) {
        if (data.length == 0) {
            return false;
        }
        boolean result = true;
        boolean first = data[0];
        for (boolean item : data) {
            if (first != item) {
                result = false;
                break;
            }
        }
        return result;
    }
}