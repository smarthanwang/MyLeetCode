package leetcode.solution.array;

import leetcode.util.ArrayUtil;

/**
 * 1089. Duplicate Zeros
 *
 * Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the
 * remaining elements to the right.
 *
 * Note that elements beyond the length of the original array are not written.
 *
 * Do the above modifications to the input array in place, do not return anything from your
 * function.
 *
 *
 * Example 1:
 *
 *  Input: [1,0,2,3,0,4,5,0]
 *  Output: null
 *  Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
 *
 * Example 2:
 *
 *  Input: [1,2,3]
 *  Output: null
 *  Explanation: After calling your function, the input array is modified to: [1,2,3]
 *
 * Note:
 *
 *  1 <= arr.length <= 10000
 *  0 <= arr[i] <= 9
 */
public class DuplicateZeros {

    public void duplicateZeros(int[] arr) {
        int[] temp = new int[arr.length];
        for (int i = 0, j = 0; i < arr.length && j < temp.length; i++, j++) {
            temp[j] = arr[i];
            if (arr[i] != 0) {
                continue;
            }
            if (++j >= temp.length) {
                return;
            } else {
                temp[j] = 0;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] a = {8,4,5,0,0,0,0,7};
        new DuplicateZeros().duplicateZeros(a);
        ArrayUtil.printArray(a);
    }

}
