package ru.job4j.array;

public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = true;
        int size = data.length;
        for (int i = 0; i < size; i++) {
            if (data[0][0] != data[i][i] || data[size - 1][size - 1] != data[i][size - 1 - i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
