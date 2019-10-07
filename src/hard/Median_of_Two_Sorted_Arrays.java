package src.hard;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/median-of-two-sorted-arrays/ Example 1:
 *
 * nums1 = [1, 3] nums2 = [2]
 *
 * The median is 2.0
 * @author: wqdong
 * @create: 2019-10-07 14:08
 **/
public class Median_of_Two_Sorted_Arrays {

  public static void main(String[] args) {
    int[] nums1 = new int[]{1, 3};
    int[] nums2 = new int[]{2};
    System.out.println(findMedianSortedArrays(nums1, nums2));
  }

  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    if (nums1.length > nums2.length) {
      return findMedianSortedArrays(nums2, nums1);
    }

    int len = nums1.length + nums2.length;
    int cut1 = 0;
    int cut2 = 0;
    int cutL = 0;
    int cutR = nums1.length;
    while (cutL < cutR) {
      cut1 = (cutR - cutL) / 2 + cutL;
      cut2 = len / 2 - cut1;

      int l1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
      int l2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
      int r1 = (cut1 == nums1.length) ? Integer.MAX_VALUE : nums1[cut1];
      int r2 = (cut2 == nums2.length) ? Integer.MAX_VALUE : nums2[cut2];

      if (l1 > r2) {
        cutR = cut1 - 1;
      } else if (l2 > r1) {
        cutL = cut1 + 1;
      } else {
        if (len % 2 == 0) {
          l1 = (l1 > l2) ? l1 : l2;
          r1 = (r1 < r2) ? r1 : r1;
          return (l1 + r1) / 2;
        } else {
          r1 = (r1 < r2) ? r1 : r2;
          return r1;
        }
      }
    }
    return -1;
  }
}
