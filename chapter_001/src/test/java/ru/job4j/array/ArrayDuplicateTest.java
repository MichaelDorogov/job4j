package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] result = arrayDuplicate.remove(new String[]{"Привет", "Мир", "Привет", "Супер", "Мир"});
        String[] expected = {"Привет", "Мир", "Супер"};
        assertThat(result, is(expected));
    }

    @Test
    public void whenAllItemsEqualsThenArrayWithoutDuplicate() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] result = arrayDuplicate.remove(new String[]{"Привет", "Привет", "Привет"});
        String[] expected = {"Привет"};
        assertThat(result, is(expected));
    }

    @Test
    public void whenOneItemThenArrayWithoutDuplicate() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] result = arrayDuplicate.remove(new String[]{"Привет"});
        String[] expected = {"Привет"};
        assertThat(result, is(expected));
    }

    @Test
    public void whenZeroItemThenArrayWithoutDuplicate() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] result = arrayDuplicate.remove(new String[0]);
        String[] expected = {};
        assertThat(result, is(expected));
    }
}