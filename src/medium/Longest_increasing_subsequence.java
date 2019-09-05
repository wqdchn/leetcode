package src.medium;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/longest-increasing-subsequence/
 * @author: wqdong
 * @create: 2019-05-27 19:04
 *
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 *
 * Example:
 *
 * Input: [10,9,2,5,3,7,101,18] Output: 4 Explanation: The longest increasing subsequence is
 * [2,3,7,101], therefore the length is 4. Note:
 *
 * There may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n2) complexity. Follow up: Could you improve it to O(n log n) time
 * complexity?
 **/
public class Longest_increasing_subsequence {

  public static void main(String[] args) {

    int[] nums = new int[]{0,5,0};

    System.out.println(lengthOfLIS_1(nums));
    System.out.println(lengthOfLIS_2(nums));
    System.out.println(lengthOfLIS_3(nums));
  }

  public static int lengthOfLIS_1(int[] nums) {
    TreeSet<Integer> set = new TreeSet<Integer>();//一个空的有序set
    for (int num : nums) {
      Integer ceil = set.ceiling(num);//返回此set中大于等于给定元素num的最小元素；如果不存在这样的元素，则返回 null。
      if (ceil != null) {
        set.remove(ceil);//当ceil不是null的时候，移除set中的这个ceil
      }
      set.add(num);
    }
    return set.size();
  }

  public static int lengthOfLIS_2(int[] nums) { //O(N)
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int res = 1;
    int[] dp = new int[nums.length + 1];

    for (int i = 0; i < dp.length; i++) {
      dp[i] = 1;
    }

    for (int i = 1; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[j] < nums[i]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      res = Math.max(res, dp[i]);
    }
    return res;
  }

  public static int lengthOfLIS_3(int[] nums) { //O(Nlog(N))
    int[] dp = new int[nums.length];
    int len = 0;
    for (int num : nums) {
      int i = Arrays.binarySearch(dp, 0, len, num);
      if (i < 0) {
        i = -(i + 1);
      }
      dp[i] = num;
      if (i == len) {
        len++;
      }
    }
    return len;
  }
}
