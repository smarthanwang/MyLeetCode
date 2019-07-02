package leetcode.solution.array;

import java.util.HashMap;

import leetcode.util.ArrayUtil;

/**
 * 1. Two Sum
 *
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 *
 * Example:
 *
 *  Given nums = [2, 7, 11, 15], target = 9,
 *
 *  Because nums[0] + nums[1] = 2 + 7 = 9,
 *  return [0, 1].
 */

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        if (nums == null || nums.length < 2) {
            return new int[0];
        }

        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null) {
                result[0] = map.get(nums[i]);
                result[1] = i;
                return result;
            } else {
                map.put(target - nums[i], i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {2, 7, 8, 9, 3, 11, 15};
        ArrayUtil.printArray(new TwoSum().twoSum(a, 19));
    }

}
