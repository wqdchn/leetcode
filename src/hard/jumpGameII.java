package src.hard;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/jump-game-ii/
 * @author: wqdong
 * @create: 2019-06-17 13:53
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * Example:
 *
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 *     Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Note:
 *
 * You can assume that you can always reach the last index.
 **/
public class jumpGameII {

    public static void main(String[] args){
        int[] nums = new int[]{2, 3, 1, 1, 4};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        if (nums.length <= 1) return 0;
        int jumps = 0;
        int reached_index = 0;
        int max_index = 0;
        for(int index =0; index < nums.length; index ++){
            if(reached_index < index){
                jumps++;
                reached_index = max_index;
            }
            max_index = Math.max(max_index, index + nums[index]);
        }
        return jumps;
    }
}
