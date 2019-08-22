package src.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/permutations/ Given a collection of distinct
 * integers, return all possible permutations.
 *
 * Example:
 *
 * Input: [1,2,3] Output: [ [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1] ]
 * @author: wqdong
 * @create: 2019-08-22 13:41
 **/
public class Permutations {

  public static void main(String[] args) {

    int[] nums = new int[]{1, 2, 3};
    System.out.println(permute(nums));
  }

  public static List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    // Arrays.sort(nums); // not necessary
    backtrack(list, new ArrayList<>(), nums);
    return list;
  }

  private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
    if (tempList.size() == nums.length) {
      list.add(new ArrayList<>(tempList));
    } else {
      for (int i = 0; i < nums.length; i++) {
        if (tempList.contains(nums[i])) {
          continue; // element already exists, skip
        }
        tempList.add(nums[i]);
        backtrack(list, tempList, nums);
        tempList.remove(tempList.size() - 1);
      }
    }
  }

}
