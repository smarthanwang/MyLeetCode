package leetcode.solution.array;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log
 * (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Example 1:
 *
 * nums1 = [1, 3] nums2 = [2]
 *
 * The median is 2.0
 *
 * Example 2:
 *
 * nums1 = [1, 2] nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 */
public class MedianOfTwoSortedArrays {

  public double findMedianInSortedArray(int[] nums) {
    int length = nums.length;
    if (length % 2 == 0) {
      return (nums[length / 2 - 1] + nums[length / 2]) / 2.0;
    } else {
      return nums[length / 2 - 1];
    }
  }

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {

    if (nums1.length == 0) {
      return findMedianInSortedArray(nums2);
    }
    if (nums2.length == 0) {
      return findMedianInSortedArray(nums1);
    }


    return 1.0;
  }
}
