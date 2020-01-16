package leetcode.solution.binarysearch;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 *
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 *
 * 示例 1:
 *
 * 输入: nums = [2,5,6,0,0,1,2], target = 0
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [2,5,6,0,0,1,2], target = 3
 * 输出: false
 * 进阶:
 *
 * 这是 搜索旋转排序数组 的延伸题目，本题中的 nums  可能包含重复元素。
 * 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchRotatedSortedArrayII {

    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            while (left < mid && nums[left] == nums[mid]) {
                left++;
            }
            //右侧有序
            if (nums[left] > nums[mid]) {
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {  //左侧有序
                if (nums[mid] > target && nums[left] <= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return false;
    }

    // 找到旋转点，二分查找两边
    private int searchRotateIndex(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right - 1) {
            int mid = (right + left) / 2;
            while (left < mid && nums[left] == nums[mid]) {
                left++;
            }
            if (nums[mid] < nums[left]) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return nums[left] < nums[right] ? right : left;
    }

    public static void main(String[] args) {
        SearchRotatedSortedArrayII searcher = new SearchRotatedSortedArrayII();
        int[] nums = new int[]{2, 3, 5, 0, 0, 1, 2};
        System.out.println(searcher.search(nums, 5));
        nums = new int[]{1, 1, 1, 2, 2, 3, 1, 1};
        System.out.println(searcher.search(nums, 4));
        nums = new int[]{3, 1, 2};
        System.out.println(searcher.search(nums, 2));
    }
}
