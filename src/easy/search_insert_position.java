package src.easy;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/search-insert-position/
 * @author: wqdong
 * @create: 2019-12-02 12:20
 **/
public class search_insert_position {

  public static void main(String[] args) {
    int[] nums = new int[]{1, 3, 5, 6};
    int target = 2;

    System.out.println(searchInsert(nums, target));
    System.out.println(searchInsert2(nums, target));
  }

  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Search Insert Position.
  public static int searchInsert(int[] nums, int target) {
    if (target < nums[0]) {
      return 0;
    }
    if (target > nums[nums.length - 1]) {
      return nums.length;
    }

    for (int i = 0; i < nums.length; i++) {
      if (target <= nums[i]) {
        return i;
      }
    }

    return -1;
  }

  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Search Insert Position.
  public static int searchInsert2(int[] nums, int target) {
    if (target < nums[0]) {
      return 0;
    }
    if (target > nums[nums.length - 1]) {
      return nums.length;
    }

    int low = 0;
    int high = nums.length - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] < target) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return low;
  }

}
