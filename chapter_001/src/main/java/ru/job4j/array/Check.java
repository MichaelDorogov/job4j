package ru.job4j.array;

public class Check {
    public boolean mono(boolean[] data) {
        boolean result = false;
        for (int i = 0; i < data.length - 1; i++) {
            result = data[i] == data[i + 1];
            if (!result) {
                break;
            }
        }
        return result;
    }
}