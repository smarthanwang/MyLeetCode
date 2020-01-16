package leetcode.common;

import leetcode.util.ArrayUtil;

public class MinHeap {

    public static void build(int[] nums) {
        int length = nums.length;
        if (length <= 1){
            return;
        }
        for (int i = length / 2; i >= 0; i --){
            siftDown(nums, i);
        }
    }

    public static void siftDown(int[] nums, int i) {
        int length = nums.length;
        int child = 2 * i + 1;
        while (child < length) {
            if (child + 1 < length && nums[child] > nums[child + 1]) {
                child = child + 1;
            }
            if (nums[child] < nums[i]) {
                int temp = nums[i];
                nums[i] = nums[child];
                nums[child] = temp;
            }
            i = child;
            child = 2 * i + 1;
        }
    }

    public static void main(String[] args) {
        int[] nums = ArrayUtil.createArray(10);
        ArrayUtil.printArray(nums);
        build(nums);
        ArrayUtil.printArray(nums);
    }

}
