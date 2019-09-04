package src.medium;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/maximum-product-subarray/ Example 1:
 *
 * Input: [2,3,-2,4] Output: 6 Explanation: [2,3] has the largest product 6.
 * @author: wqdong
 * @create: 2019-09-04 09:00
 **/
public class Maximum_Product_Subarray {

  public static void main(String[] args) {
    int[] nums = new int[]{2, 3, -2, 4};
    System.out.println(maxProduct(nums));
    System.out.println(maxProduct2(nums));
    System.out.println(maxProduct3(nums));
  }

  public static int maxProduct(int[] nums) {
    if (nums.length == 0 || nums == null) {
      return 0;
    }
    int[][] dp = new int[2][2];

    dp[0][0] = nums[0];
    dp[0][1] = nums[0];

    int res = nums[0];

    for (int i = 1; i < nums.length; i++) {
      int x = i % 2;
      int y = (i - 1) % 2;
      dp[x][0] = Math.max(Math.max(dp[y][0] * nums[i], dp[y][1] * nums[i]), nums[i]);
      dp[x][1] = Math.min(Math.min(dp[y][0] * nums[i], dp[y][1] * nums[i]), nums[i]);

      res = Math.max(res, dp[x][0]);
    }
    return res;
  }

  public static int maxProduct2(int[] A) {
    int n = A.length, res = A[0], l = 0, r = 0;
    for (int i = 0; i < n; i++) {
      l = (l == 0 ? 1 : l) * A[i];
      r = (r == 0 ? 1 : r) * A[n - 1 - i];
      res = Math.max(res, Math.max(l, r));
    }
    return res;
  }

  public static int maxProduct3(int[] A) {
    if (A == null || A.length == 0) {
      return 0;
    }
    int max = A[0], min = A[0], result = A[0];
    for (int i = 1; i < A.length; i++) {
      int temp = max;
      max = Math.max(Math.max(max * A[i], min * A[i]), A[i]);
      min = Math.min(Math.min(temp * A[i], min * A[i]), A[i]);
      if (max > result) {
        result = max;
      }
    }
    return result;
  }
}
