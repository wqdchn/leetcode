package src.hard;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/sliding-window-maximum/
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
 *
 * Example:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 *
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
 * @author: wqdong
 * @create: 2019-08-12 12:33
 **/
public class slidingWindowMaximum {

    public static void main(String[] args){
        int[] nums = new int[] {1,3,-1,-3,5,3,6,7};
        int k = 3;

        for (int i : maxSlidingWindow(nums, k)){
            System.out.print(i + " ");
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {

        if (nums == null || k <= 0) return new int[0];
        int[] res = new int[nums.length - k + 1];//保存结果
        ArrayDeque<Integer> deque = new ArrayDeque<Integer>();//双端队列

        int index = 0;
        for (int i = 0; i < nums.length; i++){
            while (!deque.isEmpty() && deque.peek() < i - k + 1){//越界
                deque.poll();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){//从右向左剔除，确保最左是当前窗口最大值
                deque.pollLast();//
            }

            deque.offer(i);//存放的是位置索引

            if (i >= k - 1){

                res[index++] = nums[deque.peek()];
            }
        }

        return res;
    }
}
