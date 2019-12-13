package src.easy;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/merge-sorted-array/
 * @author: wqdong
 * @create: 2019-12-13 19:46
 *
 * nums1.length() >= m + n
 **/
public class merge_sorted_array {

  public static void main(String[] args) {
    int m = 3;
    int n = 3;

    int[] nums1 = new int[]{1, 2, 3, 4, 0, 0, 0};
    int[] nums2 = new int[]{2, 5, 6};

    merge(nums1, m, nums2, n);

    for (int num : nums1) {
      System.out.print(num + " ");
    }

  }

  public static void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1, j = n - 1, k = m + n - 1;
    while (i >= 0 && j >= 0) {
      nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
    }
    while (j >= 0){
      nums1[k--] = nums2[j--];
    }
  }

}
