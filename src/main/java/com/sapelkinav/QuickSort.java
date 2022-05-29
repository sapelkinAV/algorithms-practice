package com.sapelkinav;

public class QuickSort {

    public static void launch() {
        var array = new int[]{8, 12, 43, 2, 3, 98, 2, 4, 223, 123, 1, 3, 5, 6};
        quicksortDescending(array, 0, array.length - 1);
        printArray(array, array.length);
    }

    private static void quicksortDescending(int[] array, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            return;
        }
        var pivot = array[highIndex];
        int leftPointer = partition(array, lowIndex, highIndex, pivot);

        quicksortDescending(array, lowIndex, leftPointer - 1);
        quicksortDescending(array, leftPointer, highIndex);
    }

    private static int partition(int[] array, int lowIndex, int highIndex, int pivot) {
        var leftPointer = lowIndex;
        var rightPointer = highIndex;

        while (leftPointer < rightPointer) {
            while (array[leftPointer] >= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }
            while (array[rightPointer] <= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }
            swap(array, leftPointer, rightPointer);

        }
        swap(array, leftPointer, highIndex);
        return leftPointer;
    }

    private static void quicksort(int[] array, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            return;
        }
        var pivot = array[highIndex];
        var leftPointer = lowIndex;
        var rightPointer = highIndex;

        while (leftPointer < rightPointer) {
            while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }
            while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }
            swap(array, leftPointer, rightPointer);

        }
        swap(array, leftPointer, highIndex);

        quicksort(array, lowIndex, leftPointer - 1);
        quicksort(array, leftPointer, highIndex);
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
    // Function to print an array
    static void printArray(int[] arr, int size)
    {
        for(int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

}
