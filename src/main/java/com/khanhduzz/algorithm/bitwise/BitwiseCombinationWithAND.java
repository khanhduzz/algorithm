package com.khanhduzz.algorithm.bitwise;

/**
 * Leetcode - 2275: Largest Combination With Bitwise AND greater than 0
 *
 * <p>You can read the description in the Leetcode page.
 * <p>This is just my way to solve it.
 *
 * <p>Based on the problem:
 * <a href="https://leetcode.com/problems/largest-combination-with-bitwise-and-greater-than-zero/description/?envType=daily-question&envId=2024-11-07">Leetcode</a>.
 */

public class BitwiseCombinationWithAND {
    /*
      READ THIS BEFORE CODE:
      - How AND work:
                    1 AND 1 = 1
                    1 AND 0 = 0
                    0 AND 1 = 0
                    0 AND 0 = 0
      So, for example:
                    1100 AND 0110 = 0100
                    1100 AND 0011 = 0000
      - The intuitive is: to make the final combination is bigger than 0
      we have to find the combination has a place with the most 1 in total.
     */

    /**
     * This is my first way, not brute force, but not fast.
     * We just loop through all the candidates, with each candidate we convert it to a String
     * Then loop through that String, if the character equals '1'
     */
     public int largestCombination1(int[] candidates) {
         int[] arr = new int[24];
         int max = 0;
         for (int candidate : candidates) {
             updateCount(arr, candidate);
         }
         for (int i = 0; i < 24; i++) {
             max = Math.max(max, arr[i]);
         }
         return max;
     }

     public void updateCount(int[] arr, int num) {
         String n = Integer.toBinaryString(num);
         for (int i = 0; i < n.length(); i++) {
             if (n.charAt(i) == '1') arr[24-n.length()+i]++;
         }
     }

    /**
     * And the second way, better than a lot.
     */
    public int largestCombination2(int[] candidates) {
        int max = 0;
        for (int i = 0; i < 24; i++) {
            int t = 0;
            for (int candidate : candidates) {
                if ((candidate & (1 << i)) != 0) t++;
            }
            max = Math.max(max, t);
        }
        return max;
    }
}
