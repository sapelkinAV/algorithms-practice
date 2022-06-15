package com.sapelkinav.dynamicprogramming;

import com.AlgorithmRunner;

import java.util.HashMap;
import java.util.Map;

public class FibonacciMemorization implements AlgorithmRunner {
    private Map<Integer, Integer> memo = new HashMap();


    @Override
    public void runAlgorithm() {
        var n = 50;
        var fibonacci = fib(n);
        System.out.println("n is "+ n + " fib is " + fibonacci);
    }

    private int fib(int n) {
        if(memo.containsKey(n)) {
            return memo.get(n);
        }
        int result;
        if (n <= 1) {
            result = n;
        } else {
            result = Math.addExact(fib(n-1), fib(n-2));
        }
        memo.put(n, result);
        return result;
    }

}
