package src.easy;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/rotate-array/
 * @author: wqdong
 * @create: 2020-02-10 07:50
 **/
public class rotate_array {

  public static void main(String[] args) {
    int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
    int k = 3;
    rotate(nums, k);
    for (int num : nums) {
      System.out.print(num + " ");
    }
  }

  // Runtime: 1 ms, faster than 50.56% of Java online submissions for Rotate Array.
  public static void rotate(int[] nums, int k) {
    int[] a = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      a[(i + k) % nums.length] = nums[i];
    }
    for (int i = 0; i < nums.length; i++) {
      nums[i] = a[i];
    }
  }

}
