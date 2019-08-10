package src.easy;

import java.util.Stack;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/implement-queue-using-stacks/
 * Implement the following operations of a queue using stacks.
 *
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 * Example:
 *
 * MyQueue queue = new MyQueue();
 *
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // returns 1
 * queue.pop();   // returns 1
 * queue.empty(); // returns false
 * Notes:
 *
 * You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
 * You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 * @author: wqdong
 * @create: 2019-08-10 11:56
 **/
public class Implement_queue_using_stacks {

    Stack<Integer> input ;
    Stack<Integer> output ;

    public static void main(String[] args){
        Implement_queue_using_stacks q = new Implement_queue_using_stacks();

        q.push(1);
        q.push(2);
        q.push(3);

        q.pop();

        System.out.println(q.peek());//应该输出 2
    }

    /** Initialize your data structure here. */
    public Implement_queue_using_stacks() {
        input = new Stack<>();
        output = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (input.isEmpty()){
            while (!output.isEmpty()){
                input.push(output.pop());
            }
        }

        input.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (output.isEmpty()){
            while (!input.isEmpty()){
                output.push(input.pop());
            }
        }

        return output.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (output.isEmpty()){
            while (!input.isEmpty()){
                output.push(input.pop());
            }
        }
        return output.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }

}
