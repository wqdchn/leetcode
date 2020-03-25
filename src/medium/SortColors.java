package src.medium;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/sort-colors/
 * @author: wqdong
 * @create: 2020-03-25 15:47
 **/
public class SortColors {

  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Sort Colors.
  public void sortColors(int[] nums) {

    int p1 = 0;
    int p2 = nums.length - 1;
    int index = 0;
    while (index <= p2) {
      if (nums[index] == 0) {
        nums[index] = nums[p1];
        nums[p1] = 0;
        p1++;
      }

      if (nums[index] == 2) {
        nums[index] = nums[p2];
        nums[p2] = 2;
        p2--;
        index--;
      }

      index++;
    }

  }

}
