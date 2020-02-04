package src.easy;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/contains-duplicate/
 * @author: wqdong
 * @create: 2020-02-04 09:28
 **/
public class contains_duplicate {

  public static void main(String[] args) {

    int[] nums = new int[]{1, 2, 3, 1};

    if (containsDuplicate(nums)) {
      System.out.println("True");
    } else {
      System.out.println("False");
    }

    if (containsDuplicate2(nums)) {
      System.out.println("True");
    } else {
      System.out.println("False");
    }

  }

  // Runtime: 6 ms, faster than 82.75% of Java online submissions for Contains Duplicate.
  public static boolean containsDuplicate(int[] nums) {

    HashSet<Integer> set = new HashSet();
    for (int i = 0; i < nums.length; i++) {
      if (set.contains(nums[i])) {
        return true;
      } else {
        set.add(nums[i]);
      }
    }
    return false;
  }

  // Runtime: 3 ms, faster than 99.56% of Java online submissions for Contains Duplicate.
  public static boolean containsDuplicate2(int[] nums) {
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] == nums[i + 1]) {
        return true;
      }
    }
    return false;
  }

}
