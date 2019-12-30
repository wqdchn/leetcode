package src.easy;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/maximum-subarray/
 * @author: wqdong
 * @create: 2019-12-30 12:03
 **/
public class maximum_subarray {

  public static void main(String[] args) {
    int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
    System.out.println(maxSubArray(nums));
  }

  // Runtime: 1 ms, faster than 76.05% of Java online submissions for Maximum Subarray.
  public static int maxSubArray(int[] nums) {
    int[] dp = new int[nums.length];
    int max_sum = nums[0];
    dp[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
      max_sum = Math.max(max_sum, dp[i]);
    }
    return max_sum;
  }
}
