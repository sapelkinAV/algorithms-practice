package org.example;

import java.util.Arrays;
import java.util.stream.IntStream;

public class InsertionSort {


    static int[] list = {5, 3, 6, 2, 10};

    public static void launch() {
        var sortedArr = selectionSort(list);
        System.out.println(Arrays.toString(sortedArr));
    }

    private static int[] selectionSort(int[] arr) {
        int[] newArr = new int[]{arr.length};

        for (int i = 0; i < newArr.length; i++) {
            int smallest = findSmallest(arr, i);
            newArr[i] = arr[smallest];
        }

        return newArr;
    }

    private static int findSmallest(int[] arr, int low) {
        int smallest = arr[low];
        int smallestIndex = low;
        for (int i = low + 1; i < arr.length; i++) {
            if (arr[i] < smallest) {
                smallest = arr[i];
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

}