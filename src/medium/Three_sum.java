package src.medium;

import java.util.*;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/3sum/
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 * @author: wqdong
 * @create: 2019-08-14 14:00
 **/
public class Three_sum {

    public static void main(String[] args){

        int[] nums = new int[]{0,0,0,0};

        for (List<Integer> s : threeSum(nums)){
            System.out.print(s);
        }

        System.out.println();

        nums = new int[]{0,0,0,0};

        for (List<Integer> s : threeSum2(nums)){
            System.out.print(s);
        }

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i + 2 < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {//令为a，寻找b和c使得a+b+c=0，故而跳过a=b或c的情况
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            int target = -nums[i];
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                } else if (nums[j] + nums[k] > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return res;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i<nums.length; i++) {
            map.put(nums[i], i);
        }

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                int compliement = -(nums[i] + nums[j]);
                int k = map.getOrDefault(compliement, -1);
                if (k > j) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }
                while(j < nums.length - 1 && nums[j + 1] == nums[j]) j++;
            }
        }
        return res;
    }

}

