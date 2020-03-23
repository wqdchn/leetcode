package src.easy;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/rotate-array/
 * @author: wqdong
 * @create: 2020-02-10 07:50
 **/
public class RotateArray {

  public static void main(String[] args) {
    int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
    int k = 3;
    rotate2(nums, k);
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

  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate Array.
  public static void rotate2(int[] nums, int k) {
    k %= nums.length;
    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
  }

  private static void reverse(int[] nums, int left, int right) {
    while (left < right) {
      int temp = nums[left];
      nums[left] = nums[right];
      nums[right] = temp;
      left++;
      right--;
    }
  }

}
