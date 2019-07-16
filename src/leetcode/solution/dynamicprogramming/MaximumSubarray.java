package leetcode.solution.dynamicprogramming;

import leetcode.util.ArrayUtil;

/**
 * 53. Maximum Subarray
 *
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which
 * has the largest sum and return its sum.
 *
 * Example:
 *
 * Input:
 * [-2,1,-3,4,-1,2,1,-5,4],
 * Output:
 * 6
 * Explanation:
 * [4,-1,2,1] has the largest sum = 6.
 *
 * Follow up:
 *
 * If you have figured out the O(n) solution, try coding another solution using the divide and
 * conquer approach, which is more subtle.
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {

        int maxValue = nums[0];
        int tempSum = 0;

        for (int num : nums) {
            tempSum += num;

            if (maxValue < tempSum) {
                maxValue = tempSum;
            }

            if (tempSum < 0) {
                tempSum = 0;
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        int[] a = {-2, -1, -3, 4, -1, 2, 1, -7, 8};
        ArrayUtil.printArray(a);
        System.out.println(new MaximumSubarray().maxSubArray(a));
    }

}
