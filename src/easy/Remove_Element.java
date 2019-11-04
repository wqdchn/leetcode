package src.easy;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/remove-element/
 * @author: wqdong
 * @create: 2019-11-04 19:34
 **/
public class Remove_Element {

  public static void main(String[] args) {
    int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
    int val = 2;
    System.out.println(removeElement(nums, val));
    for (int i = 0; i < nums.length; i++) {
      System.out.print(nums[i] + " ");
    }
  }

  public static int removeElement(int[] nums, int val) {
    if (nums.length == 0) {
      return 0;
    }
    int result = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != val) {
        nums[result] = nums[i];
        result++;
      }
    }
    return result;
  }
}
