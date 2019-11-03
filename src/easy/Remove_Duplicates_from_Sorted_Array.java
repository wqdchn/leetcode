package src.easy;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * @author: wqdong
 * @create: 2019-11-03 18:46
 **/
public class Remove_Duplicates_from_Sorted_Array {

  public static void main(String[] args) {
    int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    System.out.print(removeDuplicates(nums));
  }

  public static int removeDuplicates(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int result = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != nums[i - 1]) {
        nums[result] = nums[i];
        result++;
      }
    }
    return result;
  }
}
