package src.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * @author: wqdong
 * @create: 2020-01-26 15:20
 **/
public class two_sum_ii {

  public static void main(String[] args) {
    int[] numbers = {2, 7, 11, 15};
    int target = 9;

    int[] rs = twoSum(numbers, target);
    System.out.println(rs[0] + "," + rs[1]);

    rs = twoSum2(numbers, target);
    System.out.println(rs[0] + "," + rs[1]);

    rs = twoSum3(numbers, target);
    System.out.println(rs[0] + "," + rs[1]);
  }

  // Runtime: 365 ms, faster than 5.07% of Java online submissions for Two Sum II - Input array is sorted.
  public static int[] twoSum(int[] numbers, int target) {
    int[] result = new int[2];
    for (int i = 0; i < numbers.length; i++) {
      for (int j = i + 1; j < numbers.length; j++) {
        if (numbers[i] + numbers[j] == target) {
          result[0] = i + 1;
          result[1] = j + 1;
        }
      }
    }
    return result;
  }

  // Runtime: 1 ms, faster than 53.81% of Java online submissions for Two Sum II - Input array is sorted.
  public static int[] twoSum2(int[] numbers, int target) {
    int[] result = new int[2];
    Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
    for (int i = 0; i < numbers.length; i++) {
      if (mp.containsKey(target - numbers[i])) {
        result[0] = mp.get(target - numbers[i]);
        result[1] = i + 1;
        return result;
      }
      mp.put(numbers[i], i + 1);
    }
    return result;
  }

  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Two Sum II - Input array is sorted.
  public static int[] twoSum3(int[] numbers, int target) {
    int l = 0, r = numbers.length - 1;
    while (numbers[l] + numbers[r] != target) {
      if (numbers[l] + numbers[r] > target) {
        r--;
      } else {
        l++;
      }
      if (r == l) {
        return new int[]{};
      }
    }
    return new int[]{l + 1, r + 1};
  }
}
