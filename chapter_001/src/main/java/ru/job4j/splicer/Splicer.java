package ru.job4j.splicer;

public class Splicer {
    public int[] splice(int[] arr1, int[] arr2) {
        int[] answer = new int[arr1.length + arr2.length];
        int m = 0, n = 0, k = 0;
        while (m + n < answer.length) {
            if (m < arr1.length && n < arr2.length) {
                answer[k++] = arr1[m] < arr2[n] ? arr1[m++] : arr2[n++];
            } else if (m < arr1.length) {
                answer[k++] = arr1[m++];
            } else {
                answer[k++] = arr2[n++];
            }
        }
        return answer;
    }
}
