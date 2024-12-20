package com.khanhduzz.algorithm.array;

import com.khanhduzz.algorithm.utils.TimeComplexity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxChunkToSortedTest {

    private MaxChunkToSorted maxChunkToSorted;

    @BeforeEach
    void setUp() {
        maxChunkToSorted = new MaxChunkToSorted();
    }

    void generalTestTemplate(int[] candidates, int expected) {
        int actual1 = TimeComplexity.measureExecutionTime("Max chunks: ",
                () -> maxChunkToSorted.maxChunksToSorted(candidates));
        assertEquals(expected, actual1);
    }

    @Test
    void testBasicArray1() {
        int[] candidates = {5,4,3,2,1};
        int expected = 1;
        generalTestTemplate(candidates, expected);
    }

    @Test
    void testBasicArray2() {
        int[] candidates = {2,1,3,4,4};
        int expected = 4;
        generalTestTemplate(candidates, expected);
    }

    @Test
    void testSpecialCase() {
        int[] candidates = {1,0,1,3,2};
        int expected = 3;
        generalTestTemplate(candidates, expected);
    }
}
