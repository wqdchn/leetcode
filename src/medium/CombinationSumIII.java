package src.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/combination-sum-iii/
 * @author: wqdong
 * @create: 2020-03-30 20:11
 **/
public class CombinationSumIII {

  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Combination Sum III.
  public List<List<Integer>> combinationSum3(int k, int n) {

    List<List<Integer>> res = new ArrayList<>();
    backTrack(res, new ArrayList<Integer>(), k, n, 1);
    return res;
  }

  private void backTrack(List<List<Integer>> res, List<Integer> temp, int k, int remain,
      int start) {
    if (temp.size() > k) {
      return;
    } else if (temp.size() == k && remain == 0) {
      res.add(new ArrayList<>(temp));
    } else {
      for (int i = start; i <= 9; i++) {
        temp.add(i);
        backTrack(res, temp, k, remain - i, i + 1);
        temp.remove(temp.size() - 1);
      }
    }
  }

}
