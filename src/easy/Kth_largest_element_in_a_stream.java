package src.easy;

import java.util.PriorityQueue;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/kth-largest-element-in-a-stream/
 * Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Your KthLargest class will have a constructor which accepts an integer k and an integer array nums, which contains initial elements from the stream. For each call to the method KthLargest.add, return the element representing the kth largest element in the stream.
 *
 * Example:
 *
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 * Note:
 * You may assume that nums' length ≥ k-1 and k ≥ 1.
 *
 * @author: wqdong
 * @create: 2019-08-11 10:36
 **/
public class Kth_largest_element_in_a_stream {

    final PriorityQueue<Integer> q;
    final int k;

    public Kth_largest_element_in_a_stream(int k, int[] nums) {
        this.k = k;
        q = new PriorityQueue<>(k);
        for (int n : nums){
           this.add(n);//想想看这里为什么不是q.add(n)呢
        }
    }

    public int add(int val) {
        if (q.size() < k){
            q.offer(val);
        }else if (q.peek() < val){
            q.poll();
            q.offer(val);
        }
        return q.peek();
    }

    /////////////////////////////////////////////////////////////



    public static void main(String[] args){
        int k = 3;
        int[] arr = new int[] {4,5,8,2};

        Kth_largest_element_in_a_stream kth = new Kth_largest_element_in_a_stream(3, arr);

        System.out.println(kth.add(3));
        System.out.println(kth.add(5));
        System.out.println(kth.add(10));
        System.out.println(kth.add(9));
        System.out.println(kth.add(4));
    }

}
