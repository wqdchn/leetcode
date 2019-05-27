package src.medium;

import java.util.TreeSet;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/longest-increasing-subsequence/
 * @author: wqdong
 * @create: 2019-05-27 19:04
 *
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 *
 * Example:
 *
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Note:
 *
 * There may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n2) complexity.
 * Follow up: Could you improve it to O(n log n) time complexity?
 **/
public class Longest_increasing_subsequence {

    public static  void main(String[] args){

        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};

        System.out.println(lengthOfLIS_1(nums));

    }

    public static int lengthOfLIS_1(int[] nums) {
        TreeSet<Integer> set = new TreeSet<Integer>();//一个空的有序set
        for(int num : nums) {
            Integer ceil = set.ceiling(num);//返回此set中大于等于给定元素num的最小元素；如果不存在这样的元素，则返回 null。
            if(ceil != null) set.remove(ceil);//当ceil不是null的时候，移除set中的这个ceil
            set.add(num);
        }
        return set.size();
    }

}
