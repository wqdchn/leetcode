package src.medium;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 * @author: wqdong
 * @create: 2019-05-28 22:05
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 *
 * You are given a target value to search. If found in the array return true, otherwise return false.
 *
 * Example 1:
 *
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 * Example 2:
 *
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 * Follow up:
 *
 * This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
 * Would this affect the run-time complexity? How and why?
 *
 **/
public class Search_in_rotated_sorted_array_ii {
    public static  void main(String[] args){
        int[] nums = new int[]{2,5,6,0,0,1,2};
        int target = 0;
        System.out.println(search(nums, target));

        target = 3;
        System.out.println(search(nums, target));
    }


    public static boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) return true;
            if (nums[mid] == nums[left]) left++;
            else if (nums[mid] > nums[left]) {
                if (nums[left] <= target && nums[mid] > target) right = mid - 1;
                else left = mid + 1;
            } else {
                if (nums[mid] < target && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return false;
    }
}
