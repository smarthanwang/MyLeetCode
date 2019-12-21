package leetcode.solution.dynamicprogramming;

import leetcode.util.ArrayUtil;

public class CountBits {

    public int[] countBits(int num) {
        int[] count = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            count[i] = count[i / 2] + i % 2 ;
        }
        return count;
    }

    public static void main(String[] args) {
        CountBits countBits = new CountBits();
        ArrayUtil.printArray(countBits.countBits(1));
        ArrayUtil.printArray(countBits.countBits(2));
        ArrayUtil.printArray(countBits.countBits(3));
        ArrayUtil.printArray(countBits.countBits(4));
        ArrayUtil.printArray(countBits.countBits(5));
        ArrayUtil.printArray(countBits.countBits(6));
        ArrayUtil.printArray(countBits.countBits(7));
    }
}
