package src.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/intersection-of-two-arrays
 * @author: wqdong
 * @create: 2019-05-23 12:24
 *
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Note:
 *
 * Each element in the result must be unique.
 * The result can be in any order.
 *
 **/
public class Intersection_of_two_arrays {

    public static  void main(String[] args){
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};

        for(int i : intersection(nums1, nums2)){
            System.out.print(i + " ");
        }

        System.out.println();

        nums1 = new int[]{4,9,5};
        nums2 = new int[]{9,4,9,8,4};

        for(int i : intersection(nums1, nums2)){
            System.out.print(i + " ");
        }

    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set = new HashSet<>();
        for (int num : nums1) {
            nums1Set.add(num);
        }
        Set<Integer> intersect = new HashSet<>();
        for (int num : nums2) {
            if (nums1Set.contains(num)) {
                intersect.add(num);
            }
        }
        int[] intersectArray = new int[intersect.size()];
        int i = 0;
        for (int num : intersect) {
            intersectArray[i++] = num;
        }
        return intersectArray;
    }
}
