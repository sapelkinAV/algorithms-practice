package com.sapelkinav.binary_search;

import com.AlgorithmRunner;

public class BadVersions implements AlgorithmRunner {
    @Override
    public void runAlgorithm() {
        var result = firstBadVersion(10);
        System.out.println("first bad version is "+ result);
    }

    public int firstBadVersion(int n) {
        int left = 0, pivot, right = n;
        while (left <= right) {
            pivot = left + (right - left)/2;
            var isBad = isBadVersion(pivot);
            if(isBad) {
                if(!isBadVersion(pivot -1)){
                    return pivot;
                }
                right = pivot -1;
            } else {
                if(isBadVersion(pivot + 1)){
                    return pivot +1;
                }
                left = pivot +2;
            }
        }
        return -1;

    }

    boolean isBadVersion(int guess){
        return guess >= 7;
    }
}
