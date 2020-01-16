package leetcode.solution.binarysearch;

public class SearchRotatedSortedArray {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 根据拐点判断区间
            if (nums[mid] > target) {
                if (nums[mid] >= nums[left] && nums[left] > target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[mid] <= nums[right] && nums[right] < target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchRotatedSortedArray searcher = new SearchRotatedSortedArray();
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(searcher.search(nums, 5));
        nums = new int[]{3, 1};
        System.out.println(searcher.search(nums, 1));
        nums = new int[]{3, 1, 2};
        System.out.println(searcher.search(nums, 2));
    }
}
