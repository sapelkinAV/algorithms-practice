package com.sapelkinav;

import java.util.stream.IntStream;

public class BinarySearch {
    static int[] list = IntStream.rangeClosed(0, 60000).toArray();

    public static void runBinarySearch() {
        var result = binarySearch(list, 3560);
        System.out.println("result is " + result);
    }

    private static Integer binarySearch(int[] list, int item) {
        int low = 0;
        int high = list.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int guess = list[mid];
            if (guess == item) {
                return mid;
            }
            if (guess > item) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return null;
    }
}
