package com.khanhduzz.algorithm.utils;

import java.util.function.Supplier;

public class TimeComplexity {

    /**
     * Calculate the time complexity for testing functions
     * @param methodName
     * @param function
     * @return functionResult
     * @param <T>
     */
    public static <T> T measureExecutionTime(String methodName, Supplier<T> function) {
        long startTime = System.nanoTime();
        T result = function.get();
        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1_000_000.0;
        System.out.println(methodName + " Took: " + duration + " milliseconds");
        return result;
    }
}
