package com.sapelkinav.binary_search;

import com.AlgorithmRunner;

public class RotatedIntegerBinarySearch implements AlgorithmRunner {
    @Override
    public void runAlgorithm() {
        int[] nums = {4,5,6,7,0,1,2};
        var result = search(nums, 5);
        System.out.println("result is " + result);
    }

    public int search(int[] nums, int target) {
        var peak = largest(nums);
        int left, right, pivot;
        if (target < nums[0]) {
            left = peak + 1;
            right = nums.length -1;
        } else {
            left = 0;
            right = peak;
        }

        while (left <= right) {
            pivot = left + (right-left)/2;
            if(nums[pivot] > target) {
                right = pivot -1;
            } else if (nums[pivot] < target) {
                left = pivot +1;
            } else if (nums[pivot] == target) {
                return pivot;
            }
        }
        return -1;

    }

    static int largest(int[] nums)
    {
        int i;
        int maxIndex = 0;

        // Initialize maximum element
        int max = nums[0];

        // Traverse array elements from second and
        // compare every element with current max
        for (i = 1; i < nums.length; i++)
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }


        return maxIndex;
    }

}
