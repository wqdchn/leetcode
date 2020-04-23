package src.medium;

import java.util.HashMap;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/subarray-sum-equals-k/
 * @author: wqdong
 * @create: 2020-04-23 08:07
 **/
public class SubarraySumEqualsK {

  // Time Limit Exceeded
  public int subarraySum(int[] nums, int k) {
    int count = 0;

    for (int i = 0; i < nums.length; i++) {

      for (int j = i + 1; j <= nums.length; j++) {

        int temp = k;
        for (int t = i; t < j; t++) {
          temp -= nums[t];
        }
        if (temp == 0) {
          count++;
        }

      }
    }

    return count;
  }

  // Runtime: 255 ms, faster than 8.00% of Java online submissions for Subarray Sum Equals K.
  public int subarraySum2(int[] nums, int k) {
    int count = 0;

    for (int i = 0; i < nums.length; i++) {
      int temp = k;
      for (int j = i; j < nums.length; j++) {
        temp -= nums[j];
        if (temp == 0) {
          count++;
        }
      }
    }

    return count;
  }

  // Runtime: 11 ms, faster than 95.48% of Java online submissions for Subarray Sum Equals K.
  public int subarraySum3(int[] nums, int k) {
    int count = 0;
    int temp = 0;

    HashMap<Integer, Integer> mp = new HashMap<>();
    mp.put(0, 1);
    for (int i = 0; i < nums.length; i++){
      temp += nums[i];
      if (mp.containsKey(temp - k)){
        count += mp.get(temp - k);
      }

      mp.put(temp, mp.getOrDefault(temp, 0) + 1);
    }

    return count;
  }

}
