package leetcode.solution.array;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *    输入: [1,3,5,6], 5
 *    输出: 2
 *
 * 示例 2:
 *    输入: [1,3,5,6], 2
 *    输出: 1
 *
 * 示例 3:
 *    输入: [1,3,5,6], 7
 *    输出: 4
 *
 * 示例 4:
 *    输入: [1,3,5,6], 0
 *    输出: 0
 */
public class SearchInsertPosition {

    private int binarySearch(int[] nums, int left, int right, int target) {

        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] < target) {
            if (mid < right) {
                return binarySearch(nums, mid + 1, right, target);
            } else {
                return right + 1;
            }
        } else {
            if (mid > left) {
                return binarySearch(nums, left, mid - 1, target);
            } else {
                return left;
            }
        }
    }

    public int searchInsertByRecursion(int[] nums, int target) {
        int length = nums.length;
        if (target < nums[0]) {
            return 0;
        }
        if (target > nums[length - 1]) {
            return length;
        }

        return binarySearch(nums, 0, nums.length - 1, target);
    }

    public int searchInsertByLoop(int[] nums, int target) {
        int length = nums.length;
        if (target < nums[0]) {
            return 0;
        }
        if (target > nums[length - 1]) {
            return length;
        }

        int left = 0;
        int right = length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        SearchInsertPosition search = new SearchInsertPosition();
        int[] a = {1, 3, 5, 6};
        System.out.println(search.searchInsertByRecursion(a, 5));
        System.out.println(search.searchInsertByLoop(a, 5));
        System.out.println(search.searchInsertByRecursion(a, 2));
        System.out.println(search.searchInsertByLoop(a, 2));
        System.out.println(search.searchInsertByRecursion(a, 7));
        System.out.println(search.searchInsertByLoop(a, 7));
        System.out.println(search.searchInsertByRecursion(a, 1));
        System.out.println(search.searchInsertByLoop(a, 1));
        System.out.println(search.searchInsertByRecursion(a, 0));
        System.out.println(search.searchInsertByLoop(a, 0));
        System.out.println(search.searchInsertByRecursion(a, 6));
        System.out.println(search.searchInsertByLoop(a, 6));
    }

}
