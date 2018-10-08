package ru.job4j.array;

import java.util.Arrays;

public class ArrayDuplicate {
    public String[] remove(String[] array) {
        int count = array.length;
        for (int i = 0, m; i != count; i++, count = m) {
            for (int j = m = i + 1; j != count; j++) {
                if (!array[j].equals(array[i])) {
                    if (m != j) array[m] = array[j];
                    m++;
                }
            }
        }
        return Arrays.copyOf(array, count);
    }
}
