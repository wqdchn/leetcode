package src.easy;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/single-number/
 * @author: wqdong
 * @create: 2020-01-30 09:37
 **/
public class single_number {

  public static void main(String[] args) {
    int[] nums = new int[]{4, 1, 2, 1, 2};
    System.out.println(singleNumber(nums));
    System.out.println(singleNumber2(nums));
  }

  // Runtime: 8 ms, faster than 26.54% of Java online submissions for Single Number.
  public static int singleNumber(int[] nums) {
    int result = 0;
    HashMap<Integer, Integer> mp = new LinkedHashMap<>();
    for (int i = 0; i < nums.length; i++) {
      mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
    }

    for (int k : mp.keySet()) {
      if (mp.get(k) == 1) {
        result = k;
      }
    }

    return result;
  }

  // 异或位运算 x ^ x = 0; 0 ^ x = x;
  // Runtime: 1 ms, faster than 55.65% of Java online submissions for Single Number.
  public static int singleNumber2(int[] nums) {
    int result = 0;
    for (int i : nums) {
      result ^= i;
    }
    return result;
  }
}
