package com.khanhduzz.algorithm.bitwise;

import com.khanhduzz.algorithm.utils.ReadJSONData;
import com.khanhduzz.algorithm.utils.TimeComplexity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BitwiseCombinationWithANDTest {

    private static final Logger log = LoggerFactory.getLogger(BitwiseCombinationWithANDTest.class);
    private BitwiseCombinationWithAND bitwiseCombination;

    @BeforeEach
    void setUp() {
        bitwiseCombination = new BitwiseCombinationWithAND();
    }

    void generalTestTemplate(int[] candidates, int expected) {
        int actual1 = TimeComplexity.measureExecutionTime("Largest Combination 1: ",
                () -> bitwiseCombination.largestCombination1(candidates));
        assertEquals(expected, actual1);

        int actual2 = TimeComplexity.measureExecutionTime("Largest Combination 2: ",
                () -> bitwiseCombination.largestCombination1(candidates));
        assertEquals(expected, actual2);
    }

    @Test
    void testBasicCandidates() {
        int[] candidates = {16,17,71,62,12,24,14};
        int expected = 4;
        generalTestTemplate(candidates, expected);
    }

    @Test
    void testBasicCandidates2() {
        int[] candidates = {8, 8};
        int expected = 2;
        generalTestTemplate(candidates, expected);
    }

    @Test
    void testLargeData() throws IOException {
        String filePath = "src/test/java/com/khanhduzz/algorithm/bitwise/BitwiseCombinationWithAND.json";
        int[] candidates = ReadJSONData.readLargeArrayFromFile(filePath);
        int expected = 50280;
        generalTestTemplate(candidates, expected);
    }
}
