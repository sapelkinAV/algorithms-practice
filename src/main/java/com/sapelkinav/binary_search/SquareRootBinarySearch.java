package com.sapelkinav.binary_search;

import com.AlgorithmRunner;

public class SquareRootBinarySearch implements AlgorithmRunner {
    @Override
    public void runAlgorithm() {
        System.out.println("sqrt of 81 is " + mySqrt2(81));
    }

    public int mySqrt(int x) {
        if (x < 2) return x;



        long num;
        int pivot, left = 2, right = x / 2;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            num = (long)pivot * pivot;
            if (num > x) {
                right = pivot - 1;
            }
            else if (num < x) {
                left = pivot + 1;
            }
            else return pivot;
        }

        return right;
    }

    public int mySqrt2(int x) {
        if (x < 2) return x;

        int left = mySqrt2(x >> 2) << 1;
        int right = left + 1;
        var possibleResult = (long) right * right;
        if (possibleResult > x) {
            return left;
        } else {
            return right;
        }
    }

    private static int binarySearch(int[] list, int item) {
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

        return -1;
    }

    public static int[] generateSortedArray(int length) {
        if (length <= 0) {
            return new int[] {};
        }
        int[] arr = new int[length];
        int data = 1;
        for (int i = 0; i < length; i++) {
            arr[i] = data++;
            //            data += RandomUtil.randomIntIn(3);
        }
        return arr;
    }
}
