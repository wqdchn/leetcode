package src.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/two-sum/
 *
 * 给定一个整型数组和指定值，返回数组内两数相加等于指定值的两数的数组下标
 * @author: wqdong
 * @create: 2018-08-23 12:18
 **/
public class TwoSum {

  //暴力法
  public static int[] twoSum(int[] nums, int target) {
    int[] result = new int[2];
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          result[0] = i;
          result[1] = j;
        }
      }
    }
    return result;
  }

  //哈希
  public static int[] twoSum2(int[] nums, int target) {
    int[] result = new int[2];
    HashMap<Integer, Integer> mp = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (mp.containsKey(target - nums[i])) {
        result[0] = mp.get(target - nums[i]);
        result[1] = i;
        return result;
      }
      mp.put(nums[i], i);
    }

    return result;
  }

  // Runtime: 2 ms, faster than 64.77% of Java online submissions for Two Sum.
  public static int[] twoSum3(int[] nums, int target) {

    HashMap<Integer, Integer> mp = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      mp.put(nums[i], i);
    }

    for (int i = 0; i < nums.length; i++) {
      int temp = target - nums[i];

      if (mp.containsKey(temp) && mp.get(temp) != i) {
        return new int[]{i, mp.get(temp)};
      }

    }

    return null;
  }


  public static void main(String[] args) {
    int[] nums = {155, 2, 7, 11, 15};
    int target = 9;
    int[] rs = twoSum(nums, target);
    System.out.println(rs[0] + "," + rs[1]);
    rs = twoSum2(nums, target);
    System.out.println(rs[0] + "," + rs[1]);
  }
}
