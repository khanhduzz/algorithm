package com.khanhduzz.algorithm.array;

/**
 * Leetcode - 768: Max Chunks To Make Sorted II
 *
 * <p>You can read the description in the Leetcode page.
 * <p>This is just my way to solve it.
 *
 * <p>Based on the problem:
 * <a href="https://leetcode.com/problems/max-chunks-to-make-sorted-ii/description/">Leetcode</a>.
 */

public class MaxChunkToSorted {
    /*
    - First loop to find the smallest number from right to left
    - Second loop to check:
        - At index: i we find the max number on left side, and min number on right side
        - Compare two of them, if maxLeft <= minRight -> able to slice
    * */
    public int maxChunksToSorted(int[] arr) {
        int count = 0;
        int min = Integer.MAX_VALUE;
        int[] minArr = new int[arr.length + 1];
        minArr[minArr.length - 1] = Integer.MAX_VALUE;
        int max = -1;

        for (int i = arr.length - 1; i >= 0; i--) {
            min = Math.min(min, arr[i]);
            minArr[i] = min;
        }

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max <= minArr[i + 1]) {
                count++;
            }
        }

        return count;
    }
}
