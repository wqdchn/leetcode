package src.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/majority-element/
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Example 1:
 *
 * Input: [3,2,3]
 * Output: 3
 * Example 2:
 *
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 * @author: wqdong
 * @create: 2019-08-17 11:13
 **/
public class Majority_Element {

    public static void main(String[] args){
        int[] nums = new int[] {2,2,1,1,1,2,2};

        System.out.println(majorityElement(nums));
        System.out.println(majorityElement2(nums));
        System.out.println(majorityElement3(nums));
        System.out.println(majorityElement5(nums));
    }

    // force
    public static int majorityElement(int[] nums) {
        int maj_count = nums.length/2;

        for (int num : nums) {
            int count = 0;
            for (int elem : nums) {
                if (elem == num) {
                    count += 1;
                }
            }

            if (count > maj_count) {
                return num;
            }

        }

        return -1;
    }

    // map
    public static int majorityElement2(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 1);
            }
            else {
                counts.put(num, counts.get(num)+1);
            }
        }

        Map.Entry<Integer, Integer> maj_Entry = null;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (maj_Entry == null || entry.getValue() > maj_Entry.getValue()) {
                maj_Entry = entry;
            }
        }

        return maj_Entry.getKey();
    }

    // sort
    public static int majorityElement3(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

//    // divide and conquer
//    public static int majorityElement4(int[] nums) {
//
//    }

    // boyer-moore voting algorithm
    public static int majorityElement5(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

}
